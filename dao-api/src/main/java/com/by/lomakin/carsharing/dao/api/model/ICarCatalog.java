package com.by.lomakin.carsharing.dao.api.model;

public interface ICarCatalog {

	Integer getId();

	void setId(Integer id);

	Integer getCatalogType();

	void setCatalogType(Integer catalogType);

	String getCatalogNameType();

	void setCatalogNameType(String catalogNameType);

	String getName();

	void setName(String name);

}
