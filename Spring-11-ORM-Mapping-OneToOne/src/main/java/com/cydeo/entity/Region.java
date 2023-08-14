package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "regions")
public class Region extends BaseEntity{

    private String region;  //region name
    private String country;

    @OneToOne(mappedBy = "region")
    private Employee employee;

    public Region(String region, String country) {
        this.region = region;
        this.country = country;
    }
}
