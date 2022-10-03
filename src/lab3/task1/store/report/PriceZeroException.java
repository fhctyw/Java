package lab3.task1.store.report;

public class PriceZeroException extends ReportException {
    public PriceZeroException() {
        super();
    }

    public PriceZeroException(final String message) {
        super(message);
    }

    public PriceZeroException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PriceZeroException(final Throwable cause) {
        super(cause);
    }

    protected PriceZeroException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
