package com.example.driver;

public class Lesson {
    String booking_id, start_date_time, end_date_time, pickup_location, hours, started_at, is_started, is_canceled, canceled_at;
    int minutes;

    public Lesson(String booking_id, String start_date_time, String end_date_time, String pickup_location, int minutes) {
        this.booking_id = booking_id;
        this.start_date_time = start_date_time;
        this.end_date_time = end_date_time;
        this.pickup_location = pickup_location;
        this.minutes = minutes;
    }

    public Lesson(String booking_id, String start_date_time, String end_date_time, String pickup_location, String hours, String started_at,
                  String is_started, String is_canceled, String canceled_at) {
        this.booking_id = booking_id;
        this.start_date_time = start_date_time;
        this.end_date_time = end_date_time;
        this.pickup_location = pickup_location;
        this.hours = hours;
        this.started_at = started_at;
        this.is_started = is_started;
        this.is_canceled = is_canceled;
        this.canceled_at = canceled_at;
    }
}
