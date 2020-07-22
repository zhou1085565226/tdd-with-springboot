package com.xiangyun.controller;

import com.xiangyun.domain.model.LegalPerson;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/legalPerson")
public class LegalPersonController {

    @PostMapping("/register")
    public LegalPerson register(@Validated @RequestBody LegalPersonRequest request) {
        LegalPerson legalPerson = new LegalPerson();
        legalPerson.setEmail("test@163.com");
        legalPerson.setName("企业法人");
        return legalPerson;
    }
}
