package models;

import lombok.Data;

import java.util.List;
@Data
public class JsonModel {

    int count;
    List<JsonElementModel> entries;
}
