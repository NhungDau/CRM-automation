package model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Reminder {
    private String description;
    private String date;
    private String time;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Reminder(String description, String date, String time) {
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public Reminder() {
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reminder reminder = (Reminder) o;
        return Objects.equals(description, reminder.description) && Objects.equals(date, reminder.date) && Objects.equals(time, reminder.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, date, time);
    }
}
