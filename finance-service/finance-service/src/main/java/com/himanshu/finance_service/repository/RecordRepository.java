package com.himanshu.finance_service.repository;

import com.himanshu.finance_service.model.Records;
import com.himanshu.finance_service.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Records, Long> {
    List<Records> findByType(Type type);

    List<Records> findByCategory(String category);

    List<Records> findByDateBetween(LocalDate start, LocalDate end);
}
