package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Lazy
public class CommentService {

    /*
    Common practice:
    - Creating dependency (has a relationship) in interface ! not class!
    - private final. because this is a dependency. we don't change anything in these classes.
    Because, if the implementation changes, I don't need to change anything here.
     */
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    //Constructor. @Autowire here, but not necessary since there is only one constructor.
    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        // following statement runs in Eager (default), but not in @Lazy
        System.out.println("Hello");
    }

    // This is the whole objective of the application
    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }

    // now, what next?
    // we want Spring framework handle the object. follow the recipe (for stereotype).
    // create config class,
}
