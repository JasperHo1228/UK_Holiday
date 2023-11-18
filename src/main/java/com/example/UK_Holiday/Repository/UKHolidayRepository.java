package com.example.UK_Holiday.Repository;

import com.example.UK_Holiday.Entity.HolidayData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UKHolidayRepository extends JpaRepository<HolidayData,Long>{
    List<HolidayData> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
