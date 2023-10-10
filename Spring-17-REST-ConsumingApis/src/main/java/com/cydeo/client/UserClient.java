package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//this part is where we are consuming a third party API
@FeignClient(url = "https://jsonplaceholder.typicode.com/", name = "USER-CLIENT")
public interface UserClient {

    //when this method is called, GET method will be executed to url+end-point (consume),
    //and the response will be assigned to List<User>
    @GetMapping("/users")
    List<User> getUsers();
}
