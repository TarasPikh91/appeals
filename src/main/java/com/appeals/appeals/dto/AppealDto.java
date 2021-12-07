package com.appeals.appeals.dto;

import com.appeals.appeals.domain.User;

import java.util.Date;

public class AppealDto {

    private Long id;
    private Date appealDate;
    private String appealText;
    private User user;

    public AppealDto(final Long id, final Date appealDate, final String appealText, final User user) {
        this.id = id;
        this.appealDate = appealDate;
        this.appealText = appealText;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
