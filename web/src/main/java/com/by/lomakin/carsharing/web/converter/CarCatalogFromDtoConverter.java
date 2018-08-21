package com.by.lomakin.carsharing.web.converter;

import com.by.lomakin.carsharing.dao.api.model.ICarCatalog;
import com.by.lomakin.carsharing.service.ICarCatalogService;
import com.by.lomakin.carsharing.web.dto.CarCatalogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CarCatalogFromDtoConverter implements Function<CarCatalogDTO, ICarCatalog> {

    @Autowired
    private ICarCatalogService carCatalogService;

    @Override
    public ICarCatalog apply(final CarCatalogDTO dto) {
        final ICarCatalog entity = carCatalogService.createEntity();
        entity.setId(dto.getId());
        entity.setCatalogType(dto.getCatalogType());
        entity.setCatalogNameType(dto.getCatalogNameType());
        entity.setName(dto.getName());

        return entity;
    }
}
