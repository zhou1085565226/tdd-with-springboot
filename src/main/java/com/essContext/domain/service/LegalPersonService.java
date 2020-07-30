package com.essContext.domain.service;

import com.essContext.controller.request.LegalPersonRequest;
import com.essContext.domain.model.LegalPerson;
import com.essContext.domain.repository.LegalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class LegalPersonService {
    @Autowired
    LegalPersonRepository legalPersonRepository;

    public LegalPerson register(LegalPersonRequest request) throws Exception {
        String code = "ji";
        LegalPerson legalPerson = getLegalPerson(request);
        if (legalPerson.getCompanyName().length()>50){
            legalPerson.setCode("100001");
            legalPerson.setMessage("公司名称过长");
        }
        if (legalPerson.getCompanyCode().length()!=18){
            legalPerson.setCode("100002");
            legalPerson.setMessage("企业统一社会信用代码不等于18位");
        }
        if (code.equals(legalPerson.getCompanyCode())){
            legalPerson.setCode("100003");
            legalPerson.setMessage("企业统一社会信用代码不能冲突");
        }
        if (validatedFalse(legalPerson)){
            legalPerson.setCode("100004");
            legalPerson.setMessage("企业统一社会信用代码不能冲突");
        }
        return legalPersonRepository.save(legalPerson);
    }

    private boolean validatedFalse( LegalPerson legalPerson) {
        return false;
    }


    private LegalPerson getLegalPerson(LegalPersonRequest request) {
        return LegalPerson.builder()
                    .type(request.getType())
                    .companyName(request.getCompanyName())
                    .companyCode(request.getCompanyCode())
                    .name(request.getName())
                    .idType(request.getIdType())
                    .idCode(request.getIdCode())
                    .build();
    }
}
