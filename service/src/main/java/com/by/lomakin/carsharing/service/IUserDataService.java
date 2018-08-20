package com.by.lomakin.carsharing.service;

import com.by.lomakin.carsharing.dao.api.filter.UserDataFilter;
import com.by.lomakin.carsharing.dao.api.model.IUserData;

import javax.transaction.Transactional;
import java.util.List;

public interface IUserDataService {

    IUserData get(Integer id);

    List<IUserData> getAll();

    @Transactional
    void save(IUserData entity);

    @Transactional
    void saveTest(IUserData entity);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    IUserData createEntity();

    long getCount(UserDataFilter filter);

    List<IUserData> find(UserDataFilter filter);

    IUserData getByEmail(String email);

    String getSalt();

}
