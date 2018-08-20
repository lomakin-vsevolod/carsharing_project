package com.by.lomakin.carsharing.dao.orm.model;

import com.by.lomakin.carsharing.dao.api.model.ICar;

import javax.persistence.*;

@Entity
@Table(name="CAR")
public class Car implements ICar {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="CAR_SEQ")
    @SequenceGenerator(sequenceName = "CAR_SEQ", allocationSize = 1, name = "CAR_SEQ")
    private Integer id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column(name="gov_number")
    private String govNumber;

    @Column
    private Integer run;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand=brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model=model;
    }

    @Override
    public String getGovNumber() {
        return govNumber;
    }

    @Override
    public void setGovNumber(String govNumber) {
        this.govNumber=govNumber;
    }

    @Override
    public Integer getRun() {
        return run;
    }

    @Override
    public void setRun(Integer run) {
        this.run=run;
    }
}
