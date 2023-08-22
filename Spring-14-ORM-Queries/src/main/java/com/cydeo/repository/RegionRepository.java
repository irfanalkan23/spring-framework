package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {

    //select * from region where ....... --> building from here, because we're in RegionRepository

    //Display all regions in Canada
    List<Region> findByCountry(String country);
    //select * from region where country is ....

    //Display all regions in Canada, without duplicates
    List<Region> findDistinctByCountry(String country);

    //Display all regions with country name includes 'United'
    List<Region> findByCountryContainsIgnoreCase(String country);

    //Display all regions with country name includes 'Asia' in order
    List<Region> findByCountryContainsOrderByCountry(String country);

    //Display top 2 regions in Canada
    List<Region> findTop2ByCountry(String country);
}
