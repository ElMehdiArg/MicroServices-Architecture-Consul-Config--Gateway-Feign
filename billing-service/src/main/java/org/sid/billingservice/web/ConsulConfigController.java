package org.sid.billingservice.web;


import org.sid.billingservice.config.MyConsulConfig;
import org.sid.billingservice.config.MyVaultConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@RefreshScope
public class ConsulConfigController {

    @Autowired
    private MyConsulConfig myConsulConfig;
    @Autowired
    private MyVaultConfig myVaultConfig;

//     @Value("${token.accessTokenTimeOut}")
//     private long accessTokenTimeout;
//     @Value("${token.refreshTokenTimeOut}")
//     private long refreshTokenTimeout;

    @GetMapping("/myConfig")
    public Map<String,Object> myConfig(){
        return Map.of("consulConfig",myConsulConfig,"vaultConfig",myVaultConfig);
    }

}
