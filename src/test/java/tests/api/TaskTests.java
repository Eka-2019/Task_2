package tests.api;

import config.EndPoint;
import models.JsonElementModel;
import org.testng.annotations.Test;
import tests.utils.UtilsMethods;
import utils.ValidateResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TaskTests {
    List<JsonElementModel> jsonElementList = ValidateResponse.getJsonElementList(EndPoint.ENTRIES.getPath());

    @Test
    public void getNumbersOfElementsWithCategoryAnimalsAndLinkContainsGithubTest() {

        List<JsonElementModel> listWithAnimalCategoryAndLinkContainGithub = new ArrayList<>();

        for (JsonElementModel element : jsonElementList) {
            if (element.getCategory().equals("Animals") && element.getLink().contains("github")) {
                listWithAnimalCategoryAndLinkContainGithub.add(element);
            }
        }
        System.out.println(listWithAnimalCategoryAndLinkContainGithub.size());
        for (JsonElementModel element : listWithAnimalCategoryAndLinkContainGithub) {
            System.out.println(element);
        }
    }


    @Test
    public void getUniqueListOfCorsTest() {
        Set<String> uniqueCorsList = UtilsMethods.getUniqueListOfCors(jsonElementList);
        System.out.println("All distinct cors value are: " + uniqueCorsList);
    }

    @Test
    public void getNumbersOfElementsWithCategoryAnimalsTest() {
        Map<String, Integer> map = UtilsMethods.getCountForEachCategory(jsonElementList);
        int count = 0;

        for (Map.Entry element : map.entrySet()) {
            if (element.getKey().equals("Animals")) {
                count = (int) element.getValue();
            }
        }
        System.out.println(count);
    }
}