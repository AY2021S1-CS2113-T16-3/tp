package seedu.duke.controller;

import org.patriques.output.timeseries.data.StockData;
import seedu.duke.api.StockPriceFetcher;
import seedu.duke.command.ByeCommand;
import seedu.duke.command.Command;
import seedu.duke.command.InvalidCommand;
import seedu.duke.command.SearchCommand;
import seedu.duke.data.exception.DukeException;
import seedu.duke.model.Portfolio;
import seedu.duke.model.PortfolioManager;
import seedu.duke.model.Stock;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

import java.time.LocalDateTime;

public class Controller {
    private Ui ui;
    private StockPriceFetcher stockPriceFetcher;
    private PortfolioManager portfolioManager;

    public Controller() {
        ui = new Ui();
        stockPriceFetcher = new StockPriceFetcher();
    }

    private void buyStock(String symbol) throws DukeException {
        double price = stockPriceFetcher.fetchLatestPrice(symbol);
        Stock stock = new Stock(symbol, price, LocalDateTime.now());
        portfolioManager.buyStock(stock);
    }

    // private void sellStock() {}

    public void runApp() {
        ui.greetUser();

        while (true) {
            String userInput = ui.getUserInput();
            Command command = Parser.parseCommand(userInput);

            if (command instanceof SearchCommand) {
                SearchCommand searchCommand = (SearchCommand) command;
                searchSymbol(searchCommand.getSearchKey());
            } else if (command instanceof InvalidCommand) {
                InvalidCommand invalidCommand = (InvalidCommand) command;
                ui.printWithDivider(invalidCommand.getErrorMessage());
            } else if (command instanceof ByeCommand) {
                break;
            }
        }
    }

    public void searchSymbol(String symbol) {
        try {
            StockData stockData = stockPriceFetcher.fetchLatestStockData(symbol);

            ui.printWithDivider(
                    "Here is the latest information on " + symbol + ":",
                    "date:   " + stockData.getDateTime(),
                    "open:   " + stockData.getOpen(),
                    "high:   " + stockData.getHigh(),
                    "low:    " + stockData.getLow(),
                    "close:  " + stockData.getClose(),
                    "volume: " + stockData.getVolume()
            );
        } catch (DukeException e) {
            ui.printWithDivider(e.getMessage());
        }
    }

}
