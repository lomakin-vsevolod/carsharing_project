package com.by.lomakin.carsharing.dao.api.filter;

public class CarFilter extends AbstractFilter {
    private String model;

    private boolean searchStatus;

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public boolean getSearchStatus() {
        return searchStatus;
    }

    public void setSearchStatus(boolean searchStatus) {
        this.searchStatus = searchStatus;
    }

}
