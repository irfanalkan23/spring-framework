package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class Consume_RestTemplate {

    private String URI = "https://jsonplaceholder.typicode.com/users";

    //RestTemplate is old. I'm learning because old designs may need to be converted (to FeinClient/WebClient).
    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //creating own API. reading from third party API. consuming.
    //when consuming, we mostly @GetMapping
    @GetMapping
    public User[] readAllUsers(){

        //consume through RestTemplate
        //RestTemplate works with Array, old system. not List.
        //getForEntity() : gets json and converts to dto. mapping.
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI, User[].class);

        return responseEntity.getBody();
    }

    @GetMapping("/{id}")
    public Object readUser(@PathVariable("id") Integer id){

        String URL = URI + "/{id}";
        //getForObject() : no mapping. return the object directly.
        return restTemplate.getForObject(URL, Object.class,id);
    }

    //dummyapi.io requires app-id for the access (https://dummyapi.io/docs). this method is example for how to do it.
    @GetMapping("/test")
    public ResponseEntity<Object> consumeFromDummyApı(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //header key and value for api authorization:
        headers.set("app-id","6298ebfecd0551211fce37a6");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        //exchange() : for passing a header item
        ResponseEntity<Object> response = restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);

        return response;
    }
}
















