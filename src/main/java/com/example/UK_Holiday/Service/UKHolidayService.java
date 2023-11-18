package com.example.UK_Holiday.Service;

import com.example.UK_Holiday.Entity.HolidayData;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface UKHolidayService {
    void saveHolidayData(String path) throws IOException;
    List<HolidayData> getAllData();
    List<HolidayData> filterData(LocalDate start, LocalDate end);

    Page<HolidayData> findByPage(int PageNo, int totalPage);
}
