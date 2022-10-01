package lab3.task1.menu;

public enum Operation {
    SAVE_DATABASE("Save database"),
    LOAD_DATABASE("Load database"),
    INFO_DATABASE("Show info about database"),
    GET_GOOD("Get good"),
    GET_GOODS("Get list of all goods"),
    ADD_GOOD("Add good"),
    SELL_GOOD("Sell good"),
    ADD_CASHIER("Add cashier"),
    GET_WORKERS("Get list of all workers"),
    GET_PURCHASE_HISTORY("Get purchase history"),
    STOP_STORE("Stop store"),
    GET_BUYER("Get buyer by index"),
    ADD_CUSTOMER("Add customer"),
    GET_BUYERS("Get all buyers"),
    ;

    final private String title;

    Operation(final String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
