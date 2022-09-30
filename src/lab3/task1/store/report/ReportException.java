package lab3.task1.store.report;

public class ReportException extends Exception {
    public ReportException() {
        super();
    }

    public ReportException(final String message) {
        super(message);
    }

    public ReportException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ReportException(final Throwable cause) {
        super(cause);
    }

    protected ReportException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
