package com.by.lomakin.carsharing.web.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class UserDTO {

    private Integer id;

    private String surname;

    private String name;

    private String middleName;

    private String passSerAndNum;

    private String passIssuedByWhom;

    private Date passIssuedWhen;

    private Date dateOfBirth;

    private String placeOfBirth;

    private String drivLicSerAndNum;

    private String drivLicIssuedByWhom;

    private Date drivLicIssuedWhen;

    private Date drivLicValidUntil;

    private String  drivLicCategory;

    private String photo;

    private String password;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "it should be an email address")
    private String email;

    @NotNull
    @DecimalMax(value = "999999999", message = "it should proper phone number with operator code, for example 291234567")
    private Integer phone;

    private String role;

    private Date dateCreate;

    private Date dateUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname=surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName=middleName;
    }

    public String getPassSerAndNum(){return passSerAndNum;};

    public void setPassSerAndNum(String passSerAndNum){this.passSerAndNum=passSerAndNum;}

    public String getPassIssuedByWhom(){return passIssuedByWhom;}

    public void setPassIssuedByWhom(String passIssuedByWhom){this.passIssuedByWhom=passIssuedByWhom;}

    public Date getPassIssuedWhen(){return passIssuedWhen;}

    public void setPassIssuedWhen(Date passIssuedWhen){this.passIssuedWhen=passIssuedWhen;}

    public Date getDateOfBirth(){return dateOfBirth;}

    public void setDateOfBirth(Date dateOfBirth){this.dateOfBirth=dateOfBirth;}

    public String getPlaceOfBirth(){return placeOfBirth;}

    public void setPlaceOfBirth(String placeOfBirth){this.placeOfBirth=placeOfBirth;}

    public String getDrivLicSerAndNum(){return drivLicSerAndNum;}

    public void setDrivLicSerAndNum(String drivLicSerAndNum){this.drivLicSerAndNum=drivLicSerAndNum;}

    public String getDrivLicIssuedByWhom(){return drivLicIssuedByWhom;}

    public void setDrivLicIssuedByWhom(String drivLicIssuedByWhom){this.drivLicIssuedByWhom=drivLicIssuedByWhom;}

    public Date getDrivLicIssuedWhen(){return drivLicIssuedWhen;}

    public void setDrivLicIssuedWhen(Date drivLicIssuedWhen){this.drivLicIssuedWhen=drivLicIssuedWhen;}

    public Date getDrivLicValidUntil(){return drivLicValidUntil;}

    public void setDrivLicValidUntil(Date drivLicValidUntil){this.drivLicValidUntil=drivLicValidUntil;}

    public String getDrivLicCategory(){return drivLicCategory;}

    public void setDrivLicCategory(String drivLicCategory){this.drivLicCategory=drivLicCategory;}

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo=photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone=phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role=role;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(final Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(final Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
