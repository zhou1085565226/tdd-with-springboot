package com.essContext.controller.request;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class LegalPersonRequest {
    @NonNull
    private String type;
    @NotNull
    private String companyName;
    @NonNull
    private String companyCode;
    @NonNull
    private String name;
    @NonNull
    private String idType;
    @NonNull
    private String idCode;

}

