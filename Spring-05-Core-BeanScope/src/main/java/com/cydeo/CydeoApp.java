package com.cydeo;

import com.cydeo.config.ProjectConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setOwner("Johnson");
        comment.setText("Spring Framework");

        // next, crete the container
        // for the container we use ApplicationContext interface
        // what kind of implementation I need? based on your configuration.
        // what kind of configuration are we using? we are using configuration class.
        // we need to implement AnnotationConfigApplicationContext() implementation class
        // add configuration class name in it
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // what next? my goal is publish the comment
        // and when I publish the comment, it should be sent to database and email should be sent
        // I need to run publishComment() method. How? We need a CommentService object
        // how? we tell Spring "give me that object"
//        CommentService cs1 = context.getBean(CommentService.class);
//        CommentService cs2 = context.getBean(CommentService.class);
//
//        System.out.println(cs1);
//        System.out.println(cs2);
//        System.out.println(cs1==cs2);

    }
}
