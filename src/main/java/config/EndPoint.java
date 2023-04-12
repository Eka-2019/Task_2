package config;

import lombok.Getter;

@Getter
public enum EndPoint {

    ENTRIES(String.format("/entries"));

    String path;

    EndPoint(String path) {
        this.path = path;
    }

}
