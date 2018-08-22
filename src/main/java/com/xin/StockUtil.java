package com.xin;

import com.google.gson.Gson;
import com.xin.utils.StringUtil;
import com.xin.utils.http.HttpUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Luchaoxin
 * @version V1.0
 * @Description: 股票工具类
 * @date 2018-08-22 21:20
 * @Copyright (C)2018 , Luchaoxin
 */
public class StockUtil {


    public static List<Stock> getStocks(String stockCode, int year) {
        String url = "http://img1.money.126.net/data/hs/kline/day/history/" + year + "/1" + stockCode + ".json";
        List<Stock> stocks = new ArrayList<>();
        String result = HttpUtil.get(url);

        if (StringUtil.isEmpty(result)) {
            return stocks;
        }

        Map<String, Object> map = new Gson().fromJson(result, Map.class);

        List<List<Object>> datas = (List<List<Object>>) map.get("data");
        Stock stock = null;
        for (List<Object> item : datas) {
                item.add(stockCode);
                stock = new Stock.Builder(item).build();
                stocks.add(stock);
        }
        return stocks;
    }

    @Test
    public void test1() {
//        String url = "http://img1.money.126.net/data/hs/kline/day/history/2015/1399001.json";
        String stockCode = "000858";
        System.out.println(getStocks(stockCode, 2018));
    }
}
