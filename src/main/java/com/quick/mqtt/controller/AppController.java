package com.quick.mqtt.controller;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mqtt")
@Slf4j
public class AppController {

    /**
     * ##  - %u: username
     * ##  - %c: clientid
     * ##  - %a: ipaddress
     * ##  - %r: protocol
     * ##  - %P: password
     * ##  - %p: sockport of server accepted
     * ##  - %C: common name of client TLS cert
     * ##  - %d: subject of client TLS cert
     * ##
     * @return
     */
    @PostMapping("/auth")
    public ResponseEntity auth(@RequestParam(value = "username",required = false)String username,
                               @RequestParam(value = "clientid",required = false)String clientid,
                               @RequestParam(value = "password",required = false)String password) {
        log.info("auth");


        return ResponseEntity.ok("call success");
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }

    @PostMapping("/acl")
    public ResponseEntity acl(@RequestParam(value = "username",required = false)String username,
                               @RequestParam(value = "clientid",required = false)String clientid,
                               @RequestParam(value = "password",required = false)String password,
                              @RequestParam(value = "topic",required = false)String topic,
                              @RequestParam(value = "access",required = false)int access) {
        log.info("acl auth");
        /**
         * access (1 - subscribe, 2 - publish)
         */
        if (topic.equals("testtopic") ) {
            return ResponseEntity.ok().build();
        }

//        return ResponseEntity.ok("call success");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }
}
