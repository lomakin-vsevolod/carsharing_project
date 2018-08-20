package com.by.lomakin.carsharing.dao.api.model;

public interface ICar {
    Integer getId();

    void setId(Integer id);

    String getBrand();

    void setBrand(String brand);

    String getModel();

    void setModel(String model);

    String getGovNumber();

    void setGovNumber(String govNumber);

    Integer getRun();

    void setRun(Integer run);
}
