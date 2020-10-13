package seedu.duke.model;

import org.junit.jupiter.api.Test;
import seedu.duke.api.StockPriceFetcher;
import seedu.duke.data.exception.DukeException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PortfolioTest {

    @Test
    void sellStock_invalidStock_expectException() {
        Portfolio portfolio = new Portfolio();
        StockPriceFetcher stockPriceFetcher = new StockPriceFetcher();
        String symbol = "abcdefg";
        int quantity = 1;
        // Use a lambda
        assertThrows(DukeException.class, () ->
        {
            portfolio.sellStock(symbol, quantity, stockPriceFetcher.fetchLatestPrice(symbol));
        });
    }

    @Test
    void sellStock_higherQuantityThanBought_expectException() {
        Portfolio portfolio = new Portfolio();
        StockPriceFetcher stockPriceFetcher = new StockPriceFetcher();
        String symbol = "aapl";
        int buyQuantity = 1;
        int sellQuantity = 2;

        // Use a lambda
        assertThrows(DukeException.class, () ->
        {
            // buy 1 aapl stock
            portfolio.buyStock(symbol, buyQuantity, stockPriceFetcher.fetchLatestPrice(symbol));
            // attempt to sell 2 aapl stock
            portfolio.sellStock(symbol, sellQuantity, stockPriceFetcher.fetchLatestPrice(symbol));
        });
    }
}
