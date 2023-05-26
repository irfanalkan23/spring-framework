package com.cydeo.stereotype_annotations.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@Data
public class DataStructure {

    @NonNull
    ExtraHours extraHours;

//    public DataStructure(ExtraHours extraHours) {
//        this.extraHours = extraHours;
//    }

    public void getTotalHours(){
        System.out.println("Total hours : " + (35+ extraHours.getHours()));
    }
}
