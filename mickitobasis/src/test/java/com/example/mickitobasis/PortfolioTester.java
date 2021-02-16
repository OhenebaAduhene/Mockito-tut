package com.example.mickitobasis;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PortfolioTester {
    Portfolio portfolio;
    StockService stockService;
    Mock mock;

    @Test
    public void testMarketValue(){

        portfolio = new Portfolio();
        stockService = mock(StockService.class);

        portfolio.setStockService(stockService);

        List<Stock> stocks = new ArrayList<>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock appleStock = new Stock("2", "Apple", 100);

        stocks.add(googleStock);
        stocks.add(appleStock);

        portfolio.setStocks(stocks);

        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(appleStock)).thenReturn(1000.00);

        double marketValue = portfolio.getMarketValue();
//        return marketValue == 100500.0;

        assertEquals(100500.0, marketValue);
    }
}
