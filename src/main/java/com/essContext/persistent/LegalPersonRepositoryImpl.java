package com.essContext.persistent;

import com.essContext.domain.model.LegalPerson;
import com.essContext.domain.repository.LegalPersonRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LegalPersonRepositoryImpl implements LegalPersonRepository{
    private List<LegalPerson> legalPersonList = new ArrayList<>();

    @Override
    public LegalPerson save(LegalPerson legalPerson) {
        legalPersonList.add(legalPerson);
        return legalPerson;
    }
}
