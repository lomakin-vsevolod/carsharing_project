package com.by.lomakin.carsharing.web.converter;

import com.by.lomakin.carsharing.dao.api.model.ICar;
import com.by.lomakin.carsharing.service.ICarService;
import com.by.lomakin.carsharing.web.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CarFromDtoConverter implements Function<CarDTO, ICar> {

    @Autowired
    private ICarService carService;

    /*@Autowired
    private IProducerService producerService;

    @Autowired
    private ICategoryService categoryService;
    */
    @Override
    public ICar apply(final CarDTO dto) {
        final ICar entity = carService.createEntity();
        entity.setId(dto.getId());
        entity.setBrand(dto.getBrand());
        entity.setModel(dto.getModel());
        entity.setGovNumber(dto.getGovNumber());
        entity.setRun(dto.getRun());

        /*final ICategory category = categoryService.createEntity();
        category.setId(dto.getCategoryId());
        entity.setCategory(category);

        final IProducer producer = producerService.createEntity();
        producer.setId(dto.getProducerId());
        entity.setProducer(producer);
        */
        return entity;
    }
}
