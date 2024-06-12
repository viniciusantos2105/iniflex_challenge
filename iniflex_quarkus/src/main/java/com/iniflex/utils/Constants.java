package com.iniflex.utils;

import java.math.BigDecimal;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final BigDecimal PERCENTAGE = new BigDecimal("100");
    public static final BigDecimal MINIMUM_SALARY = new BigDecimal("1212.00");

    public static final Integer MOUNTH_TEN = 10;
    public static final Integer MOUNTH_TWELVE = 12;
}
