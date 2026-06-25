package com.sravanthi.dto;

import lombok.Data;

@Data
public class LoanResponse {

    private String customerName;
    private Double eligibleLoanAmount;
    private String status;

}
