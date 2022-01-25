package com.appeals.appeals.dto;

import com.appeals.appeals.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
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
}
