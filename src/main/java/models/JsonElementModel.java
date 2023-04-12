package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public class JsonElementModel {

    String api;
    String description;
    String auth;
    String https;
    String cors;
    String link;
    String category;

}


