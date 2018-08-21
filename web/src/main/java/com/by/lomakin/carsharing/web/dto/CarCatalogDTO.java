package com.by.lomakin.carsharing.web.dto;

import com.by.lomakin.carsharing.dao.api.model.ICarCatalog;

import javax.persistence.*;

public class CarCatalogDTO {

    private Integer id;

    private Integer catalogType;

    private String catalogNameType;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id=id;
    }

    public Integer getCatalogType() {
        return catalogType;
    }

    public void setCatalogType(Integer catalogType) {
        this.catalogType=catalogType;
    }

    public String getCatalogNameType() {
        return catalogNameType;
    }

    public void setCatalogNameType(String catalogNameType) {
        this.catalogNameType=catalogNameType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }
}
