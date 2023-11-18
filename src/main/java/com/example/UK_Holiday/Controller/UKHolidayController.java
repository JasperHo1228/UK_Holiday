package com.example.UK_Holiday.Controller;

import com.example.UK_Holiday.Entity.HolidayData;
import com.example.UK_Holiday.Service.ReadJson;
import com.example.UK_Holiday.Service.UKHolidayService;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/homepage")
public class UKHolidayController {
    private UKHolidayService ukHolidayService;
    private boolean dataSaved = false;

    public UKHolidayController(UKHolidayService ukHolidayService) {
        this.ukHolidayService = ukHolidayService;
    }

    @GetMapping
    public String HomePage(Model model) throws IOException {
        if (!dataSaved) {
            ukHolidayService.saveHolidayData("/JSON/uk_holiday");
            dataSaved = true;
        }
        return Pagination(1, model);
    }

    @GetMapping("/all")
    public String GetAllData(Model model) throws IOException {
        return Pagination(1, model);
    }

    @GetMapping("/filter")
    public String filter(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate")  LocalDate endDate,
            Model model) {
        List<HolidayData> filteredData = ukHolidayService.filterData(startDate, endDate);
        model.addAttribute("allData", filteredData);
        return "home";
    }

    @GetMapping("/{PageNo}")
    public String Pagination(@PathVariable(value="PageNo") int PageNo, Model model) throws IOException {
        int page_num = 10;
        Page<HolidayData> page = ukHolidayService.findByPage(PageNo, page_num);
        List<HolidayData> holidaydata = page.getContent();

        model.addAttribute("curr_Page", PageNo);
        model.addAttribute("total_Page", page.getTotalPages());
        model.addAttribute("total_item", page.getTotalElements());
        model.addAttribute("allData", holidaydata);

        return "home"; // Assuming this is the correct view name
    }
}
