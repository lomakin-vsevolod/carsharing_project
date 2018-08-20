package com.by.lomakin.carsharing.service.impl;

import com.by.lomakin.carsharing.dao.api.ICarDao;
import com.by.lomakin.carsharing.dao.api.filter.CarFilter;
import com.by.lomakin.carsharing.dao.api.model.ICar;
import com.by.lomakin.carsharing.service.ICarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements ICarService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(CarServiceImpl.class);

    @Autowired
    private ICarDao dao;

    @Override
    public ICar get(final Integer id) {
        ICar entity = dao.get(id);
        LOGGER.info("entityById: {}", entity);
        return entity;
    }

    @Override
    public List<ICar> getAll() {
        List<ICar> all = dao.selectAll();
        LOGGER.info("total count in DB:", all.size());
        return all;
    }

    @Override
    public void save(final ICar entity) {
        if (entity.getId() == null) {
            dao.insert(entity);
            LOGGER.info("new saved product: {}", entity);
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
        LOGGER.info("delete all product entities {}");
        dao.deleteAll();
    }

    @Override
    public ICar createEntity() {
        return dao.createEntity();
    }

    @Override
    public List<ICar> find(final CarFilter filter) {
        return dao.find(filter);
    }

    @Override
    public long getCount(final CarFilter filter) {
        return dao.getCount(filter);
    }

}
