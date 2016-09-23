package au.com.challenge.ww.weatherapp.retrofit;

public class RestException extends Exception {

    private String status;
    private int code;

    protected void assertStatusCode(int statusCode) {
        if (this.status == null && this.code == 0) {
            this.status = String.valueOf(statusCode);
            this.code = statusCode;
        }
    }

    public String getStatus() {
        return this.status;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return String.format("status: %s, code: %s",
                status,
                code);
    }
}
