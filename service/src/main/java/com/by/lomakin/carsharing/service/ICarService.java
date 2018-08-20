package com.by.lomakin.carsharing.service;

import com.by.lomakin.carsharing.dao.api.filter.CarFilter;
import com.by.lomakin.carsharing.dao.api.model.ICar;
import com.by.lomakin.carsharing.dao.orm.model.Car;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

public interface ICarService {

    ICar get(Integer id);

    //ICar getFullInfo(Integer id);

    //Map<Integer, String> getPictureLink(Integer id);

    List<ICar> getAll();

    @Transactional
    void save(ICar entity);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    ICar createEntity();

    List<ICar> find(CarFilter filter);

    long getCount(CarFilter filter);

}
