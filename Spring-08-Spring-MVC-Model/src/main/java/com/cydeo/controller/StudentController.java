package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){

        model.addAttribute("name","Cydeo");
        model.addAttribute("course","MVC");

        String subject = "Collections";
        model.addAttribute("subject",subject);

        //create random student ID (0-1000) and display in UI
//        int studentID = (int) (Math.random()*1000);
        int studentID = new Random().nextInt(1000);
        model.addAttribute("studentID",studentID);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(4,6,7,11));
        model.addAttribute("numbers",numbers);

        Student student = new Student(1,"Mike","Smith");
        model.addAttribute("student",student);

        return "/student/welcome";
    }
}
