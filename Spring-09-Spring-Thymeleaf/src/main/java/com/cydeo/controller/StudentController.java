package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("student")
public class StudentController {

//    @RequestMapping("/register")      // GET is default
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public String register(Model model){       // iot bind data, we add "Model model" parameter

        model.addAttribute("students", DataGenerator.studentGenerator());
        //now (above), "students" attrubute holds all the generated students
        //and I want to use this attribute in view (register.html)
        //and I will need Thymeleaf in .html to be able to use it

        return "student/register";  // return view
    }

//    @RequestMapping("welcome")
    @GetMapping("welcome")
    public String info(){
        return "student/welcome";
    }
}
