package com.by.lomakin.carsharing.service;

import com.by.lomakin.carsharing.dao.api.filter.CarCatalogFilter;
import com.by.lomakin.carsharing.dao.api.model.ICarCatalog;

import javax.transaction.Transactional;
import java.util.List;

public interface ICarCatalogService {

	ICarCatalog get(Integer id);

	List<ICarCatalog> getAll();

	@Transactional
	void save(ICarCatalog entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	ICarCatalog createEntity();

	long getCount(CarCatalogFilter filter);

	List<ICarCatalog> find(CarCatalogFilter filter);
}
