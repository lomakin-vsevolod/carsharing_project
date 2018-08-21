package com.by.lomakin.carsharing.web.converter;

import com.by.lomakin.carsharing.dao.api.model.ICarCatalog;
import com.by.lomakin.carsharing.web.dto.CarCatalogDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CarCatalogToDtoConverter implements Function<ICarCatalog, CarCatalogDTO> {

    @Override
    public CarCatalogDTO apply(final ICarCatalog entity) {
        final CarCatalogDTO carCatalogDTO = new CarCatalogDTO();
        carCatalogDTO.setId(entity.getId());
        carCatalogDTO.setCatalogType(entity.getCatalogType());
        carCatalogDTO.setCatalogNameType(entity.getCatalogNameType());
        carCatalogDTO.setName(entity.getName());

        return carCatalogDTO;

    }

}
