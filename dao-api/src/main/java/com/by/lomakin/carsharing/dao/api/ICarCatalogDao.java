package com.by.lomakin.carsharing.dao.api;

import com.by.lomakin.carsharing.dao.api.filter.CarCatalogFilter;
import com.by.lomakin.carsharing.dao.api.model.ICarCatalog;

import java.util.List;

public interface ICarCatalogDao extends BaseDao<ICarCatalog, Integer> {

	long getCount(CarCatalogFilter filter);

	List<ICarCatalog> find(CarCatalogFilter filter);

}
