package lab3.task1.store.report;

import lab3.task1.store.storage.Good;

import java.util.List;

public class Report {
    private List<Good> goods;

    public Report(final List<Good> goods) {
        this.goods = goods;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(final List<Good> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        goods.forEach(e->stringBuilder.append(e).append('\n'));
        return stringBuilder.toString();
    }

    private void validateGood(final Good good) throws NameIsEmptyException, PriceZeroException {
        if (good.getName().isEmpty()) {
            throw new NameIsEmptyException();
        }
        if (good.getPrice() <= 0) {
            throw new PriceZeroException();
        }
    }

    public void validate() throws NameIsEmptyException, PriceZeroException {
        try {
            for (final Good good : goods) {
                validateGood(good);
            }
        } catch (final NameIsEmptyException nameIsEmptyException) {
            throw new NameIsEmptyException();
        } catch (final PriceZeroException priceZeroException) {
            throw new PriceZeroException();
        }
    }
}
