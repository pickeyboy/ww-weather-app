package au.com.challenge.ww.weatherapp.retrofit;

public class Feedback<Model> {

    /**
     * Invoked regardless of the response or lack of it.
     * @param success true if successful response is received.
     */
    public void received(boolean success) {
        //
    }

    /**
     * Invoked only if a successful response from server is received.
     * @param model response data
     */
    public void success(Model model) {
        //
    }

    /**
     * Invoked if the response received from server is erroneous, or no response is received.
     * @param throwable {@link RestException} for server errors, {@link java.io.IOException} for network issues.
     */
    public void error(Throwable throwable) {
        //
    }
}
