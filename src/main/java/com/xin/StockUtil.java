package com.xin;

import com.google.gson.Gson;
import com.xin.utils.AssertUtil;
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
        AssertUtil.checkCondition(StringUtil.isInteger(stockCode), "股票代码必须为整数。");
        AssertUtil.checkCondition(year > 1900, "输入的年份不对。");

        String url = "http://img1.money.126.net/data/hs/kline/day/history/" + year + "/1" + stockCode + ".json";
        List<Stock> stocks = new ArrayList<>();
        String result = HttpUtil.get(url);

        List<List<Object>> datas = new ArrayList<>();
        Map<String, Object> map = new Gson().fromJson(result, Map.class);
        datas = (List<List<Object>>) map.get("data");
        for (List<Object> item : datas) {
            item.add(stockCode);
            stocks.add(new Stock.Builder(item).build());
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
