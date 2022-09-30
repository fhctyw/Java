package lab3.task1.store.storage.service;

public class GoodAlreadyExist extends RuntimeException {
    public GoodAlreadyExist() {
    }

    public GoodAlreadyExist(final String message) {
        super(message);
    }

    public GoodAlreadyExist(final String message, final Throwable cause) {
        super(message, cause);
    }

    public GoodAlreadyExist(final Throwable cause) {
        super(cause);
    }

    public GoodAlreadyExist(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
