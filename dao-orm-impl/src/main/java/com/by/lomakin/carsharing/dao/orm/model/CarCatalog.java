package com.by.lomakin.carsharing.dao.orm.model;

import com.by.lomakin.carsharing.dao.api.model.ICar;
import com.by.lomakin.carsharing.dao.api.model.ICarCatalog;

import javax.persistence.*;

@Entity
@Table(name="CAR_CATALOG")
public class CarCatalog implements ICarCatalog {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="CAR_CATALOG_SEQ")
    @SequenceGenerator(sequenceName = "CAR_CATALOG_SEQ", allocationSize = 1, name = "CAR_CATALOG_SEQ")
    private Integer id;

    @Column(name="catalog_type")
    private Integer catalogType;

    @Column(name="catalog_name_type")
    private String catalogNameType;

    @Column
    private String name;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }

    @Override
    public Integer getCatalogType() {
        return catalogType;
    }

    @Override
    public void setCatalogType(Integer catalogType) {
        this.catalogType=catalogType;
    }

    @Override
    public String getCatalogNameType() {
        return catalogNameType;
    }

    @Override
    public void setCatalogNameType(String catalogNameType) {
        this.catalogNameType=catalogNameType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }
}
