package com.appeals.appeals.domain;

import com.appeals.appeals.dto.AppealDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "appeal_data")
public class  Appeal {

    @Id
    @Column(
            name = "id",
            updatable = false
    )
    @SequenceGenerator(
            name = "appeal_sequence",
            sequenceName = "appeal_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appeal_sequence")
    private Long id;

    @Column(
            name = "appeal_date",
            nullable = false,
            columnDefinition = "DATE"
            )
    private Date appealDate;

    @Column(name = "appeal_text",
            nullable = false,
            columnDefinition = "TEXT")
    private String appealText;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    public Appeal() {

    }

    public Appeal(Date appealDate, String appealText, User user) {
        this.appealDate = appealDate;
        this.appealText = appealText;
        this.user = user;
    }

    public Appeal(final AppealDto appealDto) {
        this.id = appealDto.getId();
        this.appealDate = appealDto.getAppealDate();
        this.appealText = appealDto.getAppealText();
        this.user = appealDto.getUser();
    }

    public AppealDto toAppealDto() {
        return new AppealDto(this.id, this.appealDate, this.appealText, this.user);
    }
}
