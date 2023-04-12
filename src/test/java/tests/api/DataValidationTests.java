package tests.api;

import config.EndPoint;
import models.JsonElementModel;
import models.JsonModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ValidateResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static tests.utils.UtilsMethods.checkJsonElementConsistency;

public class DataValidationTests {

    List<JsonElementModel> jsonElementsList = ValidateResponse.getJsonElementList(EndPoint.ENTRIES.getPath());

    @Test
    public void findAllEmptyValuesTest() {
        List<JsonElementModel> listWithEmptyValue = new ArrayList<>();
        for (JsonElementModel element : jsonElementsList) {
            if (element.getApi().isEmpty()
                    || element.getDescription().isEmpty()
                    || element.getAuth().isEmpty()
                    || element.getHttps().isEmpty()
                    || element.getCors().isEmpty()
                    || element.getLink().isEmpty()
                    || element.getCategory().isEmpty()) {
                listWithEmptyValue.add(element);
            }
        }
        System.out.println(listWithEmptyValue.size());
        for (JsonElementModel element : listWithEmptyValue) {
            System.out.println(element);
        }
    }

    @Test
    public void getCountTest() {
        JsonModel jsonCountElements = ValidateResponse.getJSON(EndPoint.ENTRIES.getPath());
        System.out.println(jsonCountElements.getCount());
    }

    @Test
    public void JSONDataBodyConsistencyTest() {
        for (JsonElementModel element : jsonElementsList) {
            checkJsonElementConsistency(element);
        }
    }

    @Test
    public void JSONDataDuplicationTest() {
        Map<JsonElementModel, Integer> mapWithDuplication = new HashMap<>();
        int count = 1;

        for (int i = 0; i < jsonElementsList.size(); i++) {
            JsonElementModel element = jsonElementsList.get(i);
            mapWithDuplication.put(element, mapWithDuplication.getOrDefault(element, 0) + 1);
        }

        for (Map.Entry element : mapWithDuplication.entrySet()) {
            if ((int) element.getValue() > 1) {
                element.toString();
                count++;
            }
        }
        Assert.assertEquals(1, count);
    }

}
