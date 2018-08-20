package com.by.lomakin.carsharing.web.converter;

import com.by.lomakin.carsharing.dao.api.model.IUserData;
import com.by.lomakin.carsharing.service.IUserDataService;
import com.by.lomakin.carsharing.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserFromDtoConverter implements Function<UserDTO, IUserData> {

    @Autowired
    private IUserDataService userService;

    @Override
    public IUserData apply(final UserDTO dto) {
        final IUserData entity = userService.createEntity();
        entity.setId(dto.getId());
        entity.setSurname(dto.getSurname());
        entity.setName(dto.getName());
        entity.setMiddleName(dto.getMiddleName());
        entity.setPassSerAndNum(dto.getPassSerAndNum());
        entity.setPassIssuedByWhom(dto.getPassIssuedByWhom());
        entity.setPassIssuedWhen(dto.getPassIssuedWhen());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setPlaceOfBirth(dto.getPlaceOfBirth());
        entity.setDrivLicSerAndNum(dto.getDrivLicSerAndNum());
        entity.setDrivLicIssuedByWhom(dto.getDrivLicIssuedByWhom());
        entity.setDrivLicIssuedWhen(dto.getDrivLicIssuedWhen());
        entity.setDrivLicValidUntil(dto.getDrivLicValidUntil());
        entity.setDrivLicCategory(dto.getDrivLicCategory());
        entity.setPhoto(dto.getPhoto());
        entity.setPassword(BCrypt.hashpw(dto.getPassword(), userService.getSalt()));
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setRole(dto.getRole());

        return entity;
    }
}
