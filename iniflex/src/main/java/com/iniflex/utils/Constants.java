package com.iniflex.utils;

import java.math.BigDecimal;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }
    public static final BigDecimal MINIMUM_SALARY = new BigDecimal("1212.00");
    public static final BigDecimal PERCENTAGE = new BigDecimal("100");
    public static final String NAME = "Nome: ";
    public static final String BIRTH_DATE = "Data de Nascimento: ";
    public static final String SALARY = "Salário: ";
    public static final String ROLE = "Cargo: ";
    public static final String AGE = "Idade: ";
    public static final String MINIMUM_WAGE = "Salário Mínimo: ";
    public static final String TOTAL_SALARYS = "Total de Salários: ";
    public static final int ROUNDING_SCALE = 0;
}
