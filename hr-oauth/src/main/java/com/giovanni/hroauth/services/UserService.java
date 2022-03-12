package com.giovanni.hroauth.services;

import com.giovanni.hroauth.entities.User;
import com.giovanni.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //Estamos implementando o logger para que possamos ja conferir na hora de fazer o teste para
    // ver se esta mandando o email correto printando no console
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if (user==null){
            throw new IllegalArgumentException("Email not found");
        }

        //Para testar pra ver se está passando o email correto
        logger.info("Email found: "+ email);

        return user;
    }
}
