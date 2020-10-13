package seedu.duke.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Stock implements Serializable {
    LocalDateTime purchasedDateTime;
    double purchasedPrice;

    public Stock(double purchasedPrice, LocalDateTime purchasedDateTime) {
        this.purchasedPrice = purchasedPrice;
        this.purchasedDateTime = purchasedDateTime;
    }
}
