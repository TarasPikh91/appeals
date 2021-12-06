package com.appeals.appeals.application;

import com.appeals.appeals.domain.Appeal;
import com.appeals.appeals.dto.AppealDto;
import com.appeals.appeals.repository.AppealRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppealApp {

    private final AppealRepository appealRepository;

    public AppealApp(AppealRepository appealRepository) {
        this.appealRepository = appealRepository;
    }

    public void saveAppeal(final AppealDto appealDto) {
        appealDto.setAppealDate(new Date());
        appealRepository.save(new Appeal(appealDto));
    }

    public List<AppealDto> getAppeals() {
        return appealRepository.findAll().stream().map((Appeal appeal) -> appeal.toAppealDto()).collect(Collectors.toList());
    }
}
