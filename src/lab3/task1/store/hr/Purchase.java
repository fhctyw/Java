package lab3.task1.store.hr;

import lab3.task1.store.hr.human.Buyer;
import lab3.task1.store.workers.human.Seller;
import lab3.task1.store.storage.Good;

import java.time.LocalDateTime;

public class Purchase {
    private LocalDateTime dateTime;
    private Good good;
    private Buyer buyer;
    private Seller seller;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(final LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(final Good good) {
        this.good = good;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(final Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(final Seller seller) {
        this.seller = seller;
    }

    public Purchase(final LocalDateTime dateTime, final Good good, final Buyer buyer, final Seller seller) {
        this.dateTime = dateTime;
        this.good = good;
        this.buyer = buyer;
        this.seller = seller;
    }

    @Override
    public String toString() {
        return dateTime + " " + good + " " + buyer + " " + seller;
    }
}
