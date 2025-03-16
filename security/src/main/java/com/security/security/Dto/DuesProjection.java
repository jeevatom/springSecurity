package com.security.security.Dto;

import java.util.Date;

public interface DuesProjection {
    int getId();
    String getDuedesc();
    String getBilledDate();
    double getDueAmount();
    double getAmountPaid();
    String getBilledStatus();

    String getRemarks();
}
