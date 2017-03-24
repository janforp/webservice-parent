package org.jsoso.jws.server;

/**
 * Created by Janita on 2017-03-24 21:57
 */
public class HelloException extends RuntimeException {

    public HelloException() {
    }

    public HelloException(String message) {
        super(message);
    }

    public HelloException(String message, Throwable cause) {
        super(message, cause);
    }

    public HelloException(Throwable cause) {
        super(cause);
    }

    public HelloException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
