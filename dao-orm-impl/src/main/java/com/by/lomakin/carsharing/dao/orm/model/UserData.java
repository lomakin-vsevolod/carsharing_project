package com.by.lomakin.carsharing.dao.orm.model;

import com.by.lomakin.carsharing.dao.api.model.IUserData;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="USER_DATA")
public class UserData extends BaseEntity implements IUserData {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ")
    @SequenceGenerator(sequenceName = "USER_DATA_SEQ", allocationSize = 1, name = "USER_SEQ")
    private Integer id;

    @Column
    private String surname;

    @Column
    private String name;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="pass_ser_and_num")
    private String passSerAndNum;

    @Column(name="pass_issued_by_whom")
    private String passIssuedByWhom;

    @Column(name="pass_issued_when")
    private Date passIssuedWhen;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="place_of_birth")
    private String placeOfBirth;

    @Column(name="driv_lic_ser_and_num")
    private String drivLicSerAndNum;

    @Column(name="driv_lic_issued_by_whom")
    private String drivLicIssuedByWhom;

    @Column(name="driv_lic_issued_when")
    private Date drivLicIssuedWhen;

    @Column(name="driv_lic_valid_until")
    private Date drivLicValidUntil;

    @Column(name="driv_lic_category")
    private String  drivLicCategory;

    @Column
    private String photo;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private Integer phone;

    @Column
    private String role;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(final Integer id) {
        this.id = id;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname=surname;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String getMiddleName() {
        return middleName;
    }

    @Override
    public void setMiddleName(String middleName) {
        this.middleName=middleName;
    }

    @Override
    public String getPassSerAndNum(){return passSerAndNum;};

    @Override
    public void setPassSerAndNum(String passSerAndNum){this.passSerAndNum=passSerAndNum;}

    @Override
    public String getPassIssuedByWhom(){return passIssuedByWhom;}

    @Override
    public void setPassIssuedByWhom(String passIssuedByWhom){this.passIssuedByWhom=passIssuedByWhom;}

    @Override
    public Date getPassIssuedWhen(){return passIssuedWhen;}

    @Override
    public void setPassIssuedWhen(Date passIssuedWhen){this.passIssuedWhen=passIssuedWhen;}

    @Override
    public Date getDateOfBirth(){return dateOfBirth;}

    @Override
    public void setDateOfBirth(Date dateOfBirth){this.dateOfBirth=dateOfBirth;}

    @Override
    public String getPlaceOfBirth(){return placeOfBirth;}

    @Override
    public void setPlaceOfBirth(String placeOfBirth){this.placeOfBirth=placeOfBirth;}

    @Override
    public String getDrivLicSerAndNum(){return drivLicSerAndNum;}

    @Override
    public void setDrivLicSerAndNum(String drivLicSerAndNum){this.drivLicSerAndNum=drivLicSerAndNum;}

    @Override
    public String getDrivLicIssuedByWhom(){return drivLicIssuedByWhom;}

    @Override
    public void setDrivLicIssuedByWhom(String drivLicIssuedByWhom){this.drivLicIssuedByWhom=drivLicIssuedByWhom;}

    @Override
    public Date getDrivLicIssuedWhen(){return drivLicIssuedWhen;}

    @Override
    public void setDrivLicIssuedWhen(Date drivLicIssuedWhen){this.drivLicIssuedWhen=drivLicIssuedWhen;}

    @Override
    public Date getDrivLicValidUntil(){return drivLicValidUntil;}

    @Override
    public void setDrivLicValidUntil(Date drivLicValidUntil){this.drivLicValidUntil=drivLicValidUntil;}

    @Override
    public String getDrivLicCategory(){return drivLicCategory;}

    @Override
    public void setDrivLicCategory(String drivLicCategory){this.drivLicCategory=drivLicCategory;}

    @Override
    public String getPhoto() {
        return photo;
    }

    @Override
    public void setPhoto(String photo) {
        this.photo=photo;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password=password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email=email;
    }

    @Override
    public Integer getPhone() {
        return phone;
    }

    @Override
    public void setPhone(Integer phone) {
        this.phone=phone;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role=role;
    }
}
