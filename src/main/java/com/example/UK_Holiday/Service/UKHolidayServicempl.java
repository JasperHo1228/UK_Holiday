package com.example.UK_Holiday.Service;

import com.example.UK_Holiday.Entity.EnglandWalesHoliday;
import com.example.UK_Holiday.Entity.HolidayData;
import com.example.UK_Holiday.Repository.UKHolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class UKHolidayServicempl implements UKHolidayService {
    @Autowired
    private ReadJson readFile;
    @Autowired
    private UKHolidayRepository ukHolidayRepository;
    public UKHolidayServicempl(ReadJson readFile,UKHolidayRepository ukHolidayRepository) {
        this.readFile = readFile;
        this.ukHolidayRepository = ukHolidayRepository;
    }

    @Override
    public void saveHolidayData(String path)  {
        try{
          EnglandWalesHoliday readJson = readFile.readHolidayFile("/JSON/uk_holiday");
          ukHolidayRepository.saveAll(readJson.getEvents());
          System.out.println("Data Saved Successfully!");
        }

        catch (IOException e){
          e.printStackTrace();
          System.out.println("Data Cannot Be Saved!");
        }
    }

    @Override
    public List<HolidayData> getAllData() {
        return ukHolidayRepository.findAll();
    }

    @Override
    public List<HolidayData> filterData(LocalDate start, LocalDate end) {
        return ukHolidayRepository.findByDateBetween(start,end);
    }

    @Override
    public Page<HolidayData> findByPage(int PageNo, int totalPage) {
        Pageable page = PageRequest.of(PageNo-1, totalPage);
        return ukHolidayRepository.findAll(page);
    }
}

