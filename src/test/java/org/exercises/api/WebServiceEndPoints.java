package org.exercises.api;

public enum WebServiceEndPoints {


    CREATE_USER("https://petstore.swagger.io/v2/user"),
    FIND_USER("https://petstore.swagger.io/v2/user/{username}"),
    ADD_PET("https://petstore.swagger.io/v2/pet"),
    FIND_PET("https://petstore.swagger.io/v2/pet/{id}");




    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
