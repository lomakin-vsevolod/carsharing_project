package com.by.lomakin.carsharing.dao.orm;

import com.by.lomakin.carsharing.dao.api.IUserDataDao;
import com.by.lomakin.carsharing.dao.api.filter.UserDataFilter;
import com.by.lomakin.carsharing.dao.api.model.IUserData;
import com.by.lomakin.carsharing.dao.orm.model.UserData;
import com.by.lomakin.carsharing.dao.orm.model.UserData_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDataDaoImpl extends AbstractDaoImpl<IUserData, Integer>
        implements IUserDataDao {

    protected UserDataDaoImpl() {
        super(UserData.class);
    }

    @Override
    public IUserData createEntity() {
        final UserData user = new UserData();
        return user;
    }

    @Override
    public long getCount(UserDataFilter filter) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        final Root<UserData> from = cq.from(UserData.class);
        cq.select(cb.count(from));
        final TypedQuery<Long> q = em.createQuery(cq);
        return q.getSingleResult();
    }

    @Override
    public List<IUserData> find(UserDataFilter filter) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<IUserData> cq = cb.createQuery(IUserData.class);
        final Root<UserData> from = cq.from(UserData.class);
        cq.select(from);

        final TypedQuery<IUserData> q = em.createQuery(cq);
        setPaging(filter, q);
        return q.getResultList();
    }

    @Override
    public IUserData getByEmail(String email) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<IUserData> cq = cb.createQuery(IUserData.class);
        final Root<UserData> from = cq.from(UserData.class);
        cq.select(from);

        cq.where(cb.equal(from.get(UserData_.email), email));

        final TypedQuery<IUserData> q = em.createQuery(cq);

        final List<IUserData> resultList = q.getResultList();
        final int size = resultList.size();
        if (size != 0) {
            return resultList.get(0);
        }
        return null;
    }

}
