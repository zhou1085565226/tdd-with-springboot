package com.essContext.domain.service;

import com.essContext.controller.LegalPersonRequest;
import com.essContext.domain.model.LegalPerson;
import com.essContext.domain.repository.LegalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LegalPersonService {
    @Autowired
    LegalPersonRepository legalPersonRepository;

    public LegalPerson register(LegalPersonRequest request) {
        LegalPerson legalPerson = LegalPerson.builder()
                .email(request.getCompanyName())
                .name(request.getCompanyName())
                .build();
        return legalPersonRepository.save(legalPerson);
    }
}
