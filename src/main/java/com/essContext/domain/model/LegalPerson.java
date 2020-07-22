package com.essContext.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LegalPerson {
    private String name;
    private String email;
}
