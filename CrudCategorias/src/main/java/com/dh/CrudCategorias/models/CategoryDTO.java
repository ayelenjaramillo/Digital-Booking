package com.dh.CrudCategorias.models;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.HashSet;

public class CategoryDTO {

    private String title;
    private String description;
    private String urlImage;


    @JsonCreator
    public CategoryDTO(String title, String description, String urlImage) {
        this.title = title;
        this.description = description;
        this.urlImage = urlImage;
    }


    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getUrlImage() {
        return urlImage;
    }


}
