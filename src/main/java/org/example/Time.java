package org.example;

import lombok.Getter;

@Getter
public class Time {
    private int hour;
    private int min;
    public Time() {
        hour = min = 0;
    }
    public Time(int h, int m) {
        hour = h;
        min = m;
    }
    public void set(String time) {
        String[] times = time.split(Headers.TIME_DELIMITER);
        hour = Integer.parseInt(times[0]);
        min = Integer.parseInt(times[1]);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (hour < 10) {
            builder.append("0");
        }
        builder.append(hour);
        if (min < 10) {
            builder.append("0");
        }
        builder.append(min);
        return builder.toString();
    }

    public boolean lessThanEqual(Time that) {
        return 60 * hour + min <= 60 * that.getHour() + that.getMin();
    }
}
