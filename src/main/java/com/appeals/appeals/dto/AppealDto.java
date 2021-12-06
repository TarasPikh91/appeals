package com.appeals.appeals.dto;

import java.util.Date;

public class AppealDto {

    private Long id;
    private Date appealDate;
    private String appealText;

    public AppealDto(final Long id, final Date appealDate, final String appealText) {
        this.id = id;
        this.appealDate = appealDate;
        this.appealText = appealText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAppealDate() {
        return appealDate;
    }

    public void setAppealDate(Date appealDate) {
        this.appealDate = appealDate;
    }

    public String getAppealText() {
        return appealText;
    }

    public void setAppealText(String appealText) {
        this.appealText = appealText;
    }
}
