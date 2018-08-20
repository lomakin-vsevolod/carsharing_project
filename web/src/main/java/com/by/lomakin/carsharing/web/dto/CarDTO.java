package com.by.lomakin.carsharing.web.dto;

public class CarDTO {

    private Integer id;

    private String brand;

    private String model;

    private String govNumber;

    private Integer run;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id=id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand=brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model=model;
    }

    public String getGovNumber() {
        return govNumber;
    }

    public void setGovNumber(String govNumber) {
        this.govNumber=govNumber;
    }

    public Integer getRun() {
        return run;
    }

    public void setRun(Integer run) {
        this.run=run;
    }
}
