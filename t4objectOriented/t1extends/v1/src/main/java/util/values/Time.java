package util.values;

public class Time {

    public static final int HOURS_MODULE = 24;
    public static final int MINUTES_MODULE = 60;
    public static final int SECONDS_MODULE = 60;

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        assert Time.isValidHour(hours);
        assert Time.isValidMinute(minutes);
        assert Time.isValidSeconds(seconds);

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public static boolean isValidHour(int hour) {
        return new IntegerInterval(0, Time.HOURS_MODULE - 1).includes(hour);
    }

    public static boolean isValidMinute(int minute) {
        return new IntegerInterval(0, Time.MINUTES_MODULE - 1).includes(minute);
    }

    public static boolean isValidSeconds(int seconds) {
        return new IntegerInterval(0, Time.SECONDS_MODULE - 1).includes(seconds);
    }

    public boolean equals(Time time) {
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
