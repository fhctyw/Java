package lab3.task1.store.report;

public class NameIsEmptyException extends ReportException {
    public NameIsEmptyException() {
        super();
    }

    public NameIsEmptyException(final String message) {
        super(message);
    }

    public NameIsEmptyException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NameIsEmptyException(final Throwable cause) {
        super(cause);
    }

    protected NameIsEmptyException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
