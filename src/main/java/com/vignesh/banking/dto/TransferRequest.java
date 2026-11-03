package com.vignesh.banking.dto;
import java.math.BigDecimal;
public record TransferRequest(String fromAccount,String toAccount,BigDecimal amount){}
