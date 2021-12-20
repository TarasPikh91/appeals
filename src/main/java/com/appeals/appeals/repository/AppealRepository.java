package com.appeals.appeals.repository;

import com.appeals.appeals.domain.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppealRepository extends JpaRepository<Appeal, Long> {


    @Transactional
    @Modifying
    @Query(value = "SELECT * from Appeal", nativeQuery = true)
    List<Appeal> getAllAppeals();
    Optional<Appeal> getAppealById(Long id);
    void deleteAppealById(Long id);
}
