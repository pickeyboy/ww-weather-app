package au.com.challenge.ww.weatherapp.retrofit;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class RestExceptionTest {

    private int code;
    private RestException exception;

    @Before
    public void setUp() throws Exception {
        code = (new Random()).nextInt(100);
        exception = new RestException();
        exception.assertStatusCode(code);
    }

    @Test
    public void testCheckGeneratedMessageFormat() throws Exception {
        String message = "status: " + code + ", code: " + code;
        Assert.assertEquals(message, exception.getMessage());
    }

}