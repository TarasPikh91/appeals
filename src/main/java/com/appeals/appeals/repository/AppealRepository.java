package com.appeals.appeals.repository;

import com.appeals.appeals.domain.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppealRepository extends JpaRepository<Appeal, Long> {
}
