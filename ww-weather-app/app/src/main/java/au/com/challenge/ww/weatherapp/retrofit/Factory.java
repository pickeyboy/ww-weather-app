package au.com.challenge.ww.weatherapp.retrofit;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import au.com.challenge.ww.weatherapp.service.WeatherDataDownloadService;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class Factory {

    protected static final String TAG = Factory.class.getSimpleName();

    protected static final String BASE_URL = "https://api.forecast.io/forecast/";

    protected static final Interceptor BASIC_INTERCEPTOR = new Interceptor() {
        @Override
        public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder()
                    .header("connection", "close")
                    .method(original.method(), original.body());

            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
    };

    protected static final Retrofit RETROFIT_BASIC = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient(BASIC_INTERCEPTOR))
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    protected Factory() {
        //
    }

    protected static OkHttpClient httpClient(Interceptor... interceptors) {
        OkHttpClient httpClient = new OkHttpClient();
        try {
            trustMe(httpClient);
        } catch (GeneralSecurityException e) {
            Log.w(TAG, "Unable to create trusting http client.", e);
        }
        for (Interceptor interceptor : interceptors) {
            httpClient.interceptors().add(interceptor);
        }
        return httpClient;
    }

    private static void trustMe(OkHttpClient httpClient) throws GeneralSecurityException {

        // Create a trust manager that does not validate certificate chains
        final TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @SuppressLint("TrustAllX509TrustManager")
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType)
                            throws CertificateException {
                    }

                    @SuppressLint("TrustAllX509TrustManager")
                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType)
                            throws CertificateException {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }
        };

        // Install the all-trusting trust manager
        final SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

        // Create an ssl socket factory with our all-trusting manager
        httpClient.setSslSocketFactory(sslContext.getSocketFactory());
        httpClient.setHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
    }

    public static <T> T execute(Call<T> call) throws IOException, RestException {
        Response<T> response = call.execute();
        if (response.isSuccess()) {
            return response.body();
        } else {
            throw newRestException(response);
        }
    }

    public static <T> void enqueue(Call<T> call, final Feedback<T> feedback) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Response<T> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    feedback.received(true);
                    feedback.success(response.body());
                } else {
                    try {
                        onFailure(newRestException(response));
                    } catch (IOException e) {
                        onFailure(e);
                    }
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                feedback.received(false);
                feedback.error(throwable);
            }
        });
    }

    protected static RestException newRestException(Response<?> response) throws IOException {
        String json = response.errorBody().string();
        RestException exception = new GsonBuilder().create().fromJson(json, RestException.class);
        exception.assertStatusCode(response.code());
        return exception;
    }

    public static WeatherDataDownloadService weatherDataService() {
        return RETROFIT_BASIC.create(WeatherDataDownloadService.class);
    }

}
