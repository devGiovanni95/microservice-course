package com.giovanni.hroauth.services;

import com.giovanni.hroauth.entities.User;
import com.giovanni.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    //Estamos implementando o logger para que possamos ja conferir na hora de fazer o teste para
    // ver se esta mandando o email correto printando no console
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if (user==null){
            logger.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }

        //Para testar pra ver se está passando o email correto
        logger.info("Email found: "+ email);

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(username).getBody();
        if (user==null){
            logger.error("Email not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }

        //Para testar pra ver se está passando o email correto
        logger.info("Email found: "+ username);

        return user;
    }
}

