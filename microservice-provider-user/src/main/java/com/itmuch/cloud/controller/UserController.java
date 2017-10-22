package com.itmuch.cloud.controller;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by William on 2017/10/22.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EurekaClient discoveryClient ;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id ){
        return this.userRepository.findOne(id);
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl(){
        InstanceInfo instanceInfo = this.discoveryClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER",false);
        return instanceInfo.getHomePageUrl();
    }
}
