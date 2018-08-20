package com.by.lomakin.carsharing.service.impl;

import com.by.lomakin.carsharing.dao.api.IUserDataDao;
import com.by.lomakin.carsharing.dao.api.filter.UserDataFilter;
import com.by.lomakin.carsharing.dao.api.model.IUserData;
import com.by.lomakin.carsharing.service.IUserDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserDataServiceImpl implements IUserDataService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserDataServiceImpl.class);

    private final String salt = BCrypt.gensalt(5);

    @Autowired
    private IUserDataDao dao;

    private MailServiceImpl mail = new MailServiceImpl();

    @Override
    public IUserData get(final Integer id) {
        IUserData entity = dao.get(id);
        LOGGER.info("entityById: {}", entity);
        return entity;
    }

    @Override
    public List<IUserData> getAll() {
        List<IUserData> all = dao.selectAll();
        LOGGER.info("total count in DB:", all.size());
        return all;
    }

    @Override
    public void save(final IUserData entity) {
        Date modifedOn = new Date();
        entity.setDateUpdate(modifedOn);
        if (entity.getId() == null) {
            entity.setDateCreate(modifedOn);
            dao.insert(entity);
            LOGGER.info("new saved user: {}", entity);
            //mail.sentEmail(entity.getEmail());
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
        LOGGER.info("delete all user entities {}");
        dao.deleteAll();
    }

    @Override
    public IUserData createEntity() {
        return dao.createEntity();
    }

    @Override
    public long getCount(final UserDataFilter filter) {
        return dao.getCount(filter);
    }

    @Override
    public List<IUserData> find(final UserDataFilter filter) {
        return dao.find(filter);
    }

    @Override
    public IUserData getByEmail(final String email) {
        IUserData entity = dao.getByEmail(email);
        LOGGER.info("entityById: {}", entity);
        return entity;
    }

    @Override
    public String getSalt() {
        return salt;
    }

    @Override
    public void saveTest(final IUserData entity) {
        Date modifedOn = new Date();
        entity.setDateUpdate(modifedOn);
        if (entity.getId() == null) {
            entity.setDateCreate(modifedOn);
            dao.insert(entity);
            LOGGER.info("new saved user: {}", entity);
        } else {
            dao.update(entity);
        }
    }

}
