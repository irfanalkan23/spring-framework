package com.cydeo.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class DebitAccount extends Account{

    private BigDecimal overDraftFee;
}
