package com.cydeo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Java {

    //Field injection
//    @Autowired
//    OfficeHours officeHours;

    OfficeHours officeHours;    //field

    //Constructor injection. If there is only one constructor, annotation can be omitted
//    @Autowired
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    public void getTeachingHours(){
        System.out.println("Weekly teaching hours : " + (20 + officeHours.getHours()));
    }
}
