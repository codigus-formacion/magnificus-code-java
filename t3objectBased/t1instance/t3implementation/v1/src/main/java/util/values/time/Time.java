package util.values.time;

import util.values.interval.IntegerInterval;

public class Time {

    public static final int HOURS_MODULE = 24;
    public static final int MINUTES_MODULE = 60;
    public static final int SECONDS_MODULE = 60;

    public static boolean isValidHour(int hour) {
        return new IntegerInterval(0, HOURS_MODULE - 1).includes(hour);
    }

    public static boolean isValidMinute(int minute) {
        return new IntegerInterval(0, MINUTES_MODULE - 1).includes(minute);
    }

    public static boolean isValidSeconds(int seconds) {
        return new IntegerInterval(0, SECONDS_MODULE - 1).includes(seconds);
    }

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        assert isValidHour(hours);
        assert isValidMinute(minutes);
        assert isValidSeconds(seconds);

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public boolean equals(Object object) {
        assert object instanceof Time;

        Time time = (Time) object;
        return this.hours == time.hours
                && this.minutes == time.minutes
                && this.seconds == time.seconds;
    }

    public boolean before(Time time) {
        if (this.hours < time.hours) {
            return true;
        }
        if (this.hours == time.hours) {
            if (this.minutes < time.minutes) {
                return true;
            }
            if (this.minutes == time.minutes) {
                if (this.seconds < time.seconds) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean after(Time time) {
        return !this.before(time) && !this.equals(time);
    }

    public int compareTo(Time time) {
        if (this.before(time)) {
            return -1;
        }
        if (this.equals(time)) {
            return 0;
        }
        return 1;
    }

    public Time next() {
        int hours = this.hours;
        int minutes = this.minutes;
        int seconds = this.seconds + 1;
        if (!isValidSeconds(seconds)) {
            seconds = 0;
            minutes++;
            if (!isValidMinute(minutes)) {
                minutes = 0;
                hours++;
                if (!isValidHour(hours)) {
                    hours = 0;
                }
            }
        }
        return new Time(hours, minutes, seconds);
    }

    public String toString() {
        return "Time [" + this.hours + ":" + this.minutes + ":" + this.seconds + "]";
    }

}
