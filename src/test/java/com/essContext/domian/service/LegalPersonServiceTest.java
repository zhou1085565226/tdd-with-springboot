package com.essContext.domian.service;

import com.essContext.BaseTest;
import com.essContext.controller.request.LegalPersonRequest;
import com.essContext.domain.model.LegalPerson;
import com.essContext.domain.service.LegalPersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zhoujianjun
 * @version V1.0
 * @ClassName: LegalPersonServiceTest
 * @Description:
 * @date
 */
public class LegalPersonServiceTest extends BaseTest {

    @Autowired
    LegalPersonService legalPersonService;

    @Test
    @DisplayName("成功")
    void should_return_sucess() throws Exception {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("111");
        legalPersonRequest.setCompanyCode("11");
        legalPersonRequest.setCompanyName("11");
        legalPersonRequest.setIdType("1");
        legalPersonRequest.setName("1");
        legalPersonRequest.setType("1");
        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);
        assertTrue(legalPerson.getId().length()>0);
    }

    @Test
    @DisplayName("公司名称超出长度")
    void should_return_fail_companyName_greater_than_50() throws Exception {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("111");
        legalPersonRequest.setCompanyCode("111111111122222111");
        legalPersonRequest.setCompanyName("11");
        legalPersonRequest.setIdType("1");
        legalPersonRequest.setName("1");
        legalPersonRequest.setType("1");
        legalPersonRequest.setCompanyName("dsaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaadadffeefafefefefefefefefefefaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaasdasdaaaaaaadadadada121aaaaaaa1");
        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);
        assertTrue(legalPerson.getCode().equals("100001"));
    }

    @Test
    @DisplayName("企业统一社会信用代码不等于18位")
    void isnot18() throws Exception {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("111");
        legalPersonRequest.setCompanyCode("11");
        legalPersonRequest.setCompanyName("11");
        legalPersonRequest.setIdType("1");
        legalPersonRequest.setName("1");
        legalPersonRequest.setType("1");
        legalPersonRequest.setCompanyCode("dsaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaadadffeefafefefefefefefefefefaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaasdasdaaaaaaadadadada121aaaaaaa1");
        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);
        assertTrue(legalPerson.getCode().equals("100002"));
    }

    @Test
    @Tag("如果社会信用代码已注册")
    void registered() throws Exception {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("111");
        legalPersonRequest.setCompanyCode("11");
        legalPersonRequest.setCompanyName("11");
        legalPersonRequest.setIdType("1");
        legalPersonRequest.setName("1");
        legalPersonRequest.setType("1");
        legalPersonRequest.setCompanyCode("ji");
        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);
        assertTrue(legalPerson.getCode().equals("100003"));
    }
}
