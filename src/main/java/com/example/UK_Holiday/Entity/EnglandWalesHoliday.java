package com.example.UK_Holiday.Entity;

import java.util.List;

public class EnglandWalesHoliday {
    private String division;
    private List<HolidayData> events;

    public EnglandWalesHoliday(){}

    public EnglandWalesHoliday(String division, List<HolidayData> events) {
        this.division = division;
        this.events = events;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public List<HolidayData> getEvents() {
        return events;
    }

    public void setEvents(List<HolidayData> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "EnglandWalesHoliday{" +
                "division='" + division + '\'' +
                ", events=" + events +
                '}';
    }
}
