package com.example.UK_Holiday.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="HolidayData")
public class HolidayData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private LocalDate date;
    private String notes;
    @Transient
    private boolean bunting;

    public HolidayData(){

    }

    public HolidayData(Long id, String title, LocalDate date, String notes, boolean bunting) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.notes = notes;
        this.bunting = bunting;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isBunting() {
        return bunting;
    }

    public void setBunting(boolean bunting) {
        this.bunting = bunting;
    }

    @Override
    public String toString() {
        return "HolidayData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", notes='" + notes + '\'' +
                ", bunting=" + bunting +
                '}';
    }
}
