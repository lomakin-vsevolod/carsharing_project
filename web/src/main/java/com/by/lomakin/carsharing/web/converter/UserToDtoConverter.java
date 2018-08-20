package com.by.lomakin.carsharing.web.converter;

import com.by.lomakin.carsharing.dao.api.model.IUserData;
import com.by.lomakin.carsharing.web.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserToDtoConverter implements Function<IUserData, UserDTO> {

	@Override
	public UserDTO apply(final IUserData entity) {
		final UserDTO userDto = new UserDTO();
		userDto.setId(entity.getId());
		userDto.setSurname(entity.getSurname());
		userDto.setName(entity.getName());
		userDto.setMiddleName(entity.getMiddleName());
		userDto.setPassSerAndNum(entity.getPassSerAndNum());
		userDto.setPassIssuedByWhom(entity.getPassIssuedByWhom());
		userDto.setPassIssuedWhen(entity.getPassIssuedWhen());
		userDto.setDateOfBirth(entity.getDateOfBirth());
		userDto.setPlaceOfBirth(entity.getPlaceOfBirth());
		userDto.setDrivLicSerAndNum(entity.getDrivLicSerAndNum());
		userDto.setDrivLicIssuedByWhom(entity.getDrivLicIssuedByWhom());
		userDto.setDrivLicIssuedWhen(entity.getDrivLicIssuedWhen());
		userDto.setDrivLicValidUntil(entity.getDrivLicValidUntil());
		userDto.setDrivLicCategory(entity.getDrivLicCategory());
		userDto.setPhoto(entity.getPhoto());
		userDto.setPassword(entity.getPassword());
		userDto.setEmail(entity.getEmail());
		userDto.setPhone(entity.getPhone());
		userDto.setRole(entity.getRole());
		userDto.setDateCreate(entity.getDateCreate());
		userDto.setDateUpdate(entity.getDateUpdate());
		return userDto;

	}

}
