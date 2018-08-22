package com.xin;

import com.xin.utils.AssertUtil;
import com.xin.utils.StringUtil;

import java.util.List;
import java.util.Objects;

/**
 * @author Luchaoxin
 * @version V1.0
 * @Description: 股票实体类
 * @date 2018-08-22 20:38
 * @Copyright (C)2018 , Luchaoxin
 */
public class Stock {
    //["20180822",63.99,63.69,64.37,63.28,14773268,-0.99]
    private String stockCode;

    private String date;

    private double openPrice;

    private double closePrice;

    private double highPrice;

    private double lowPrice;

    private int volume;

    private double increase;

    public Stock() {
    }

    public Stock(String stockCode, String date, double openPrice, double closePrice, double highPrice, double lowPrice, int volume, double increase) {
        this.stockCode = stockCode;
        this.date = date;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.volume = volume;
        this.increase = increase;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getCurrPrice() {
        return closePrice;
    }

    public void setCurrPrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getIncrease() {
        return increase;
    }

    public void setIncrease(double increase) {
        this.increase = increase;
    }

    public static class Builder {
        private String stockCode;
        private String date;
        private double openPrice;
        private double closePrice;
        private double highPrice;
        private double lowPrice;
        private int volume;
        private double increase;

        public Builder() {
        }

        public Builder(List<Object> data) {
            AssertUtil.checkNotEmpty(data, "List must not be null.");

            date = StringUtil.toString(data.get(0));
            openPrice = StringUtil.toDouble(data.get(1));
            closePrice = StringUtil.toDouble(data.get(2));
            highPrice = StringUtil.toDouble(data.get(3));
            lowPrice = StringUtil.toDouble(data.get(4));
            volume = StringUtil.toInteger(data.get(5));
            increase = StringUtil.toDouble(data.get(6));
            stockCode = StringUtil.toString(data.get(7));
        }

        public Builder addStockCode(String stockCode) {
            this.stockCode = stockCode;
            return this;
        }

        public Builder addDate(String date) {
            this.date = date;
            return this;
        }

        public Builder addOpenPrice(double openPrice) {
            this.openPrice = openPrice;
            return this;
        }

        public Builder addClosePrice(double closePrice) {
            this.closePrice = closePrice;
            return this;
        }

        public Builder addHighPrice(double highPrice) {
            this.highPrice = highPrice;
            return this;
        }

        public Builder addHighLow(double lowPrice) {
            this.lowPrice = lowPrice;
            return this;
        }

        public Builder addVolume(int volume) {
            this.volume = volume;
            return this;
        }

        public Builder addIncrease(double increase) {
            this.increase = increase;
            return this;
        }


        public Stock build() {
            return new Stock(stockCode, date, openPrice, closePrice, highPrice, lowPrice, volume, increase);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stock stock = (Stock) o;
        return Double.compare(stock.openPrice, openPrice) == 0 &&
                Double.compare(stock.closePrice, closePrice) == 0 &&
                Double.compare(stock.highPrice, highPrice) == 0 &&
                Double.compare(stock.lowPrice, lowPrice) == 0 &&
                volume == stock.volume &&
                Double.compare(stock.increase, increase) == 0 &&
                Objects.equals(date, stock.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, openPrice, closePrice, highPrice, lowPrice, volume, increase);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockCode='" + stockCode + '\'' +
                ", date='" + date + '\'' +
                ", openPrice=" + openPrice +
                ", closePrice=" + closePrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", volume=" + volume +
                ", increase=" + increase +
                '}';
    }
}
