package com.essContext.domain.service;

import com.essContext.controller.LegalPersonRequest;
import com.essContext.domain.model.LegalPerson;
import org.springframework.stereotype.Service;

@Service
public class LegalPersonService {
    public LegalPerson register(LegalPersonRequest request) {
        LegalPerson legalPerson = new LegalPerson();
        legalPerson.setEmail("test@163.com");
        legalPerson.setName("企业法人");
        return legalPerson;
    }
}
