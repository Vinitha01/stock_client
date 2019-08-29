package com.smcharts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smcharts.model.StockPrice;
import com.smcharts.service.StockPriceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StockPriceController {

	@Autowired
	StockPriceService stockPriceService;

	@GetMapping(path = "/stockPrices")
	public List<StockPrice> getStockPrices() {
		System.out.println("Get all Stock Prices...");
		return stockPriceService.getStockPrices();
	}

	@PostMapping(path = "/stockPrice/create")
	public StockPrice createIPOs(@RequestBody StockPrice stockPrice) {
		System.out.println("Creating Stock Price");
		StockPrice _stockPrice = stockPriceService.createStockPrice(stockPrice);
		return _stockPrice;
	}

	@GetMapping(path = "/stockPrice/{stockPriceId}")
	public Optional<StockPrice> getStockPriceById(@PathVariable Long id) {
		System.out.println("Get Stock Price with id " + id);
		return stockPriceService.getStockPriceById(id);
	}

	@GetMapping(path = "/stockPrices/{companyId}")
	public List<StockPrice> getStockPrices(@PathVariable long companyId) {
		System.out.println("Get all Stock Prices for companyId " + companyId);
		return stockPriceService.getStockPricesbyCompanyId(companyId);
	}

	@GetMapping(path = "/stockPrices/{companyId}/{stockExchangeId}/{periodicity}")
	public List<StockPrice> getStockPricesCompare1(@PathVariable long companyId, @PathVariable long stockExchangeId,
			@PathVariable String periodicity) {
		System.out.println(companyId + stockExchangeId + periodicity);
		return stockPriceService.getStockPricesCompare1(companyId, stockExchangeId, periodicity);
	}

}
