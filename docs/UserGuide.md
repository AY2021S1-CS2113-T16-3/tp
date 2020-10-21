# User Guide

## Introduction

Duke is a command line trading simulator that lets you try your hand at trading stocks with no risk!

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](https://github.com/AY2021S1-CS2113-T16-3/tp/releases/tag/v1.0).

## Features 

### Buying a stock: `buy /aapl`
Buys the specified stock at market price

Format: `buy /STOCK_TICKER`

* The `STOCK_TICKER` is the stock's short form

Example of usage: 

`buy /fb`

`buy /tsla`

### Selling a stock: `sell /aapl`
Sells the specified stock at market price

Format: `sell /STOCK_TICKER`

* The `STOCK_TICKER` is the stock's short form

Example of usage: 

`sell /goog`

`sell /amzn`

### Searching for info about a stock: `search /aapl`
Shows information about a stock like price and volume

Format: `search /STOCK_TICKER`

* The `STOCK_TICKER` is the stock's short form

Example of usage: 

`search /nflx`

`search /shop`

### View your portfolio: `view`
Shows the stocks you have, its quantity and current price. Also shows transaction history.

Format: `view`

Example of usage: 

`view`

### Check your wallet: `wallet`
Shows you how much cash you have left in your wallet to buy stocks, how much you have allocated to stocks and your net profit.

Format: `wallet`

Example of usage: 

`wallet`

### Exit: `bye`
Exits the program. Duke will save your info for the next time you come back!

Format: `bye`

Example of usage: 

`bye`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Just copy the txt file over.

## Command Summary

{Give a 'cheat sheet' of commands here}

* Buy a stock `buy /aapl`
* Sell a stock `sell /aapl`
* Search for a stock's info `search /aapl`
* View portfolio `view`
* Exit program `bye`
