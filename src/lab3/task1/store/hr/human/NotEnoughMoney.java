package lab3.task1.store.hr.human;

public class NotEnoughMoney extends RuntimeException {
    public NotEnoughMoney() {
    }

    public NotEnoughMoney(final String message) {
        super(message);
    }

    public NotEnoughMoney(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NotEnoughMoney(final Throwable cause) {
        super(cause);
    }

    public NotEnoughMoney(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
