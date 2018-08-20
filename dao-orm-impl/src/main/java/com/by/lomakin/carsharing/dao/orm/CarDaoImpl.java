package com.by.lomakin.carsharing.dao.orm;

import com.by.lomakin.carsharing.dao.api.ICarDao;
import com.by.lomakin.carsharing.dao.api.filter.CarFilter;
import com.by.lomakin.carsharing.dao.api.model.ICar;
import com.by.lomakin.carsharing.dao.orm.model.Car;
import com.by.lomakin.carsharing.dao.orm.model.Car_;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CarDaoImpl extends AbstractDaoImpl<ICar, Integer>
        implements ICarDao {

    protected CarDaoImpl() {
        super(Car.class);
    }

    @Override
    public ICar createEntity() {
        return new Car();
    }

    @Override
    public long getCount(CarFilter filter) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        final Root<Car> from = cq.from(Car.class);
        cq.select(cb.count(from));
        applyFilter(filter, cb, cq, from);
        final TypedQuery<Long> q = em.createQuery(cq);
        return q.getSingleResult();
    }

    @Override
    public List<ICar> find(CarFilter filter) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<ICar> cq = cb.createQuery(ICar.class);
        final Root<Car> from = cq.from(Car.class);
        cq.select(from);

        applyFilter(filter, cb, cq, from);

        if (filter.getSortColumn() != null) {
            final SingularAttribute<? super Car, ?> sortProperty = toMetamodelFormat(
                    filter.getSortColumn());
            final Path<?> expression = from.get(sortProperty);
            cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
        }

        final TypedQuery<ICar> q = em.createQuery(cq);
        setPaging(filter, q);
        return q.getResultList();
    }

    private void applyFilter(final CarFilter filter, final CriteriaBuilder cb,
            final CriteriaQuery<?> cq, final Root<Car> from) {
        final List<Predicate> ands = new ArrayList<>();

        final String model = filter.getModel();

        if (!StringUtils.isBlank(model)) {
            ands.add(cb.equal(from.get(Car_.model), model));
        }

        if (filter.getSearchStatus()) {
            if (!ands.isEmpty()) {
                cq.where(cb.and(ands.toArray(new Predicate[0])));
            }
        }
    }

    private SingularAttribute<? super Car, ?> toMetamodelFormat(
            final String sortColumn) {
        switch (sortColumn) {
        case "model":
            return Car_.model;
        case "brand":
            return Car_.brand;
        case "run":
            return Car_.run;
        case "id":
            return Car_.id;
        default:
            throw new UnsupportedOperationException(
                    "sorting is not supported by column:" + sortColumn);
        }
    }

}
