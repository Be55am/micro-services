package com.bessam.googleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


/**
 * this is an authentication with google authentication service it uses @EnableAuth2SSo annotation which is a dipricated
 * this service returns the user principal as Rest object
 */

@SpringBootApplication
@RestController
public class GoogleService {

    public static void main(String[] args) {
        SpringApplication.run(GoogleService.class, args);
    }

    @RequestMapping(value = "/user")
    public Principal user(Principal principal){
        return principal;
    }

}
