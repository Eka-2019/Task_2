package tests.utils;

import models.JsonElementModel;
import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.ValidateResponse;

import java.text.SimpleDateFormat;
import java.util.*;

public class UtilsMethods {

    private static final Logger LOGGER = Logger.getLogger(UtilsMethods.class);
    public static String getServerCurrentDate() {
        LOGGER.info("Changing current time zone");
        TimeZone.setDefault(TimeZone.getTimeZone("Spain"));
        String pattern = "E, dd MMM yyyy HH:mm:ss z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    public static void checkJsonElementConsistency(JsonElementModel element) {
        Assert.assertNotNull(element.getApi(), element.toString());
        Assert.assertNotNull(element.getDescription(), element.toString());
        Assert.assertNotNull(element.getAuth(), element.toString());
        Assert.assertNotNull(element.getHttps(), element.toString());
        Assert.assertNotNull(element.getCors(), element.toString());
        Assert.assertNotNull(element.getLink(), element.toString());
        Assert.assertNotNull(element.getCategory(), element.toString());
    }

    public static Set<String> getUniqueListOfCors(List<JsonElementModel> list) {
        LOGGER.info("Getting unique cors list");
        Set<String> uniqueCorsSet = new HashSet<>();
        for (JsonElementModel element : list) {
            String el = element.getCors();
            uniqueCorsSet.add(el);
        }
        return uniqueCorsSet;
    }

    public static Map<String, Integer> getCountForEachCategory(List<JsonElementModel> list) {
        LOGGER.info("Getting counts for each Category");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String el = list.get(i).getCategory();
            map.put(el, map.getOrDefault(el, 0) + 1);
        }
        return map;
    }


}
