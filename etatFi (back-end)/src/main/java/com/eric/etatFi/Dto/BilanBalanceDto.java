package com.eric.etatFi.Dto;

public record BilanBalanceDto(
        double montantActif,
        double montantPassif,
        boolean balance
) {}
