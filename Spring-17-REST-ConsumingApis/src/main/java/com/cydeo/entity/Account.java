package com.cydeo.entity;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account_details")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"},ignoreUnknown = true)
public class Account extends BaseEntity{
    private String name;

    @JsonIgnore
    private String address;

    private String country;
    private String city;
    private String state;
    private Integer age;
    @Column(name = "postal_code")
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @OneToOne(mappedBy = "account")
    @JsonBackReference //is the back part of reference - it will be omitted from serialization
    private User user;

//    @Override
//    public String toString() {
//        return "Account{" +
//                "name='" + name + '\'' +
//                ", address='" + address + '\'' +
//                ", country='" + country + '\'' +
//                ", city='" + city + '\'' +
//                ", state='" + state + '\'' +
//                ", age=" + age +
//                ", postalCode='" + postalCode + '\'' +
//                ", role=" + role +
//                //we didn't add user here, because it will cause infinite loop
//                //since Account has user, and User has account (circular dependency)
//                '}';
//    }
}
