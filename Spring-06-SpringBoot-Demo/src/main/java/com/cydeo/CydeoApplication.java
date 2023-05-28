package com.cydeo;

import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CydeoApplication {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setOwner("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context = SpringApplication.run(CydeoApplication.class, args);
        //in real application, we won't use and need the "ApplicationContext context = " part.

        CommentService cs = context.getBean(CommentService.class);
        cs.publishComment(comment);
    }

}
