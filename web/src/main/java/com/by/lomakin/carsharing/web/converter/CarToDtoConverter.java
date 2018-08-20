package com.by.lomakin.carsharing.web.converter;

import com.by.lomakin.carsharing.dao.api.model.ICar;
import com.by.lomakin.carsharing.web.dto.CarDTO;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CarToDtoConverter implements Function<ICar, CarDTO> {

    @Override
    public CarDTO apply(final ICar entity) {
        final CarDTO carDto = new CarDTO();
        carDto.setId(entity.getId());
        carDto.setBrand(entity.getBrand());
        carDto.setModel(entity.getModel());
        carDto.setGovNumber(entity.getGovNumber());
        carDto.setRun(entity.getRun());

        /*final IProducer producer = entity.getProducer();
        if (producer != null) {
            productDto.setProducerId(producer.getId());
            productDto.setProducerName(producer.getName());
        }

        final ICategory category = entity.getCategory();
        if (category != null) {
            productDto.setCategoryId(category.getId());
            productDto.setCategoryName(category.getName());
        }*/

        return carDto;

    }

}
