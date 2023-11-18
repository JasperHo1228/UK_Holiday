package com.example.UK_Holiday.Entity;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ReadFile {
    @JsonProperty("england-and-wales")
    private EnglandWalesHoliday england_and_wales;
    public ReadFile(){

    }
    public ReadFile(EnglandWalesHoliday england_and_wales) {
        this.england_and_wales = england_and_wales;
    }

    public void setEngland_and_wales(EnglandWalesHoliday england_and_wales) {
        this.england_and_wales = england_and_wales;
    }
    public EnglandWalesHoliday getEngland_and_wales() {
        return england_and_wales;
    }

    @Override
    public String toString() {
        return "ReadFile{" +
                "england_and_wales=" + england_and_wales +
                '}';
    }
}
