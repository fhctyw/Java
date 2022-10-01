package lab3.task1.menu;

public enum Operation {
    INFO_DATABASE("Show info about database"),
    GET_GOOD("Get good"),
    GET_GOODS("Get list of all goods"),
    GET_SORT_GOODS("Get sorted goods"),
    GET_AVG_PRICE("Get average price of all goods"),
    GET_PURCHASE_HISTORY_BY("Get purchase history by buyer and time duration"),
    GET_GOODS_BY_BUYER("Get goods by buyer"),
    GET_POPULAR_GOOD("Get most popular good"),
    GET_MAX_PROFIT("Get maximum profit by days"),
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
