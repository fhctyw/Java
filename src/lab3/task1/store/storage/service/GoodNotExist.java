package lab3.task1.store.storage.service;

public class GoodNotExist extends RuntimeException {
    public GoodNotExist() {
    }

    public GoodNotExist(final String message) {
        super(message);
    }

    public GoodNotExist(final String message, final Throwable cause) {
        super(message, cause);
    }

    public GoodNotExist(final Throwable cause) {
        super(cause);
    }

    public GoodNotExist(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
