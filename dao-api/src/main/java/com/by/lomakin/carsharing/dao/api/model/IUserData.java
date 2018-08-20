package com.by.lomakin.carsharing.dao.api.model;

import java.util.Date;

public interface IUserData extends IBaseEntity {
    Integer getId();

    void setId(Integer id);

    String getSurname();

    void setSurname(String surname);

    String getName();

    void setName(String name);

    String getMiddleName();

    void setMiddleName(String middleName);

    String getPassSerAndNum();

    void setPassSerAndNum(String passSerAndNum);

    String getPassIssuedByWhom();

    void setPassIssuedByWhom(String passIssuedByWhom);

    Date getPassIssuedWhen();

    void setPassIssuedWhen(Date passIssuedWhen);

    Date getDateOfBirth();

    void setDateOfBirth(Date dateOfBirth);

    String getPlaceOfBirth();

    void setPlaceOfBirth(String placeOfBirth);

    String getDrivLicSerAndNum();

    void setDrivLicSerAndNum(String drivLicSerAndNum);

    String getDrivLicIssuedByWhom();

    void setDrivLicIssuedByWhom(String drivLicIssuedByWhom);

    Date getDrivLicIssuedWhen();

    void setDrivLicIssuedWhen(Date drivLicIssuedWhen);

    Date getDrivLicValidUntil();

    void setDrivLicValidUntil(Date drivLicValidUntil);

    String getDrivLicCategory();

    void setDrivLicCategory(String drivLicCategory);

    String getPhoto();

    void setPhoto(String photo);

    String getPassword();

    void setPassword(String password);

    String getEmail();

    void setEmail(String email);

    Integer getPhone();

    void setPhone(Integer phone);

    String getRole();

    void setRole(String role);

}
