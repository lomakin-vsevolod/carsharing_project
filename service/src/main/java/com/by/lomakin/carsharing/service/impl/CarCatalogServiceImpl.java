package com.by.lomakin.carsharing.service.impl;

import com.by.lomakin.carsharing.dao.api.ICarCatalogDao;
import com.by.lomakin.carsharing.dao.api.filter.CarCatalogFilter;
import com.by.lomakin.carsharing.dao.api.model.ICarCatalog;
import com.by.lomakin.carsharing.service.ICarCatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarCatalogServiceImpl implements ICarCatalogService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(CarCatalogServiceImpl.class);

    @Autowired
    private ICarCatalogDao dao;

    @Override
    public ICarCatalog get(final Integer id) {
        ICarCatalog entity = dao.get(id);
        LOGGER.info("entityById: {}", entity);
        return entity;
    }

    @Override
    public List<ICarCatalog> getAll() {
        List<ICarCatalog> all = dao.selectAll();
        LOGGER.info("total count in DB:", all.size());
        return all;
    }

    @Override
    public void save(final ICarCatalog entity) {
        if (entity.getId() == null) {
            dao.insert(entity);
            LOGGER.info("new saved carcatalog: {}", entity);
        } else {
            dao.update(entity);
        }
    }

    @Override
    public void delete(final Integer id) {
        LOGGER.info("delete entity: {}", id);
        dao.delete(id);
    }

    @Override
    public void deleteAll() {
        LOGGER.info("delete all category entities {}");
        dao.deleteAll();
    }

    @Override
    public ICarCatalog createEntity() {
        return dao.createEntity();
    }

    @Override
    public long getCount(final CarCatalogFilter filter) {
        return dao.getCount(filter);
    }

    @Override
    public List<ICarCatalog> find(final CarCatalogFilter filter) {
        return dao.find(filter);
    }

}
