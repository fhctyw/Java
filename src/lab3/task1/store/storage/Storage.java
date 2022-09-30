package lab3.task1.store.storage;

import java.io.Serializable;
import java.util.TreeMap;
import java.util.UUID;

public class Storage implements Serializable {
    private TreeMap<UUID, Good> goods;

    public TreeMap<UUID, Good> getGoods() {
        return goods;
    }

    public void setGoods(final TreeMap<UUID, Good> goods) {
        this.goods = goods;
    }

    public Storage(final TreeMap<UUID, Good> goods) {
        this.goods = goods;
    }

}
