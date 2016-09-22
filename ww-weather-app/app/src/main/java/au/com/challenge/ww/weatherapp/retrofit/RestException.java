package au.com.challenge.ww.weatherapp.retrofit;

import com.google.gson.annotations.SerializedName;

public class RestException extends Exception {

    private String status;
    private int code;
    private String message;
    private String developerMessage;

    @SerializedName("error")
    private String authError;

    @SerializedName("error_description")
    private String authErrorDescription;

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
        return String.format("status: %s, code: %s, message: %s, description: %s",
                status,
                code,
                message != null ? message : authError,
                developerMessage != null ? developerMessage : authErrorDescription);
    }
}
