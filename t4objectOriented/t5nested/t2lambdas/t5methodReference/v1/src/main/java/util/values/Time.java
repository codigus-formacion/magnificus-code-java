package util.values;

public class Time implements Comparable<Time> {

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

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + hours;
        result = prime * result + minutes;
        result = prime * result + seconds;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Time))
            return false;
        Time other = (Time) obj;
        if (hours != other.hours)
            return false;
        if (minutes != other.minutes)
            return false;
        if (seconds != other.seconds)
            return false;
        return true;
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

    public boolean isPM() {
        return this.after(new Time(12,0,0));
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

    public Time add(Time time) {
        int seconds = this.seconds + time.seconds;
        int minutes = this.minutes + time.minutes;
        int hours = this.hours + time.hours;
        if (!Time.isValidSeconds(seconds)){
            seconds %= Time.SECONDS_MODULE;
            minutes++;
        }
        if (!Time.isValidMinute(minutes)){
            minutes %= Time.MINUTES_MODULE;
            hours++;
        }
        if (!Time.isValidHour(hours)){
            hours %= Time.HOURS_MODULE;
        }
        return new Time(hours, minutes, seconds);
    }

    public Time subtract(Time time) {
        int seconds = this.seconds - time.seconds;
        int minutes = this.minutes - time.minutes;
        int hours = this.hours - time.hours;
        if (!Time.isValidSeconds(seconds)) {
            seconds += Time.SECONDS_MODULE;
            minutes--;
        }
        if (!Time.isValidMinute(minutes)) {
            minutes += Time.MINUTES_MODULE;
            hours--;
        }
        if (!Time.isValidHour(hours)) {
            hours += Time.HOURS_MODULE;
        }
        return new Time(hours, minutes, seconds);
    }

    public Time opposite() {
        return this.add(new Time(12, 0, 0));
    }

    public Time divide(int times) {
        int totalSeconds = this.totalSeconds() / times;
        int hours = totalSeconds / (Time.SECONDS_MODULE * Time.MINUTES_MODULE);
        totalSeconds %= (Time.SECONDS_MODULE * Time.MINUTES_MODULE);
        int minutes = totalSeconds / Time.SECONDS_MODULE;
        int seconds = totalSeconds % Time.SECONDS_MODULE;
        return new Time(hours, minutes, seconds);
    }

    private int totalSeconds() {
        return (this.hours * Time.SECONDS_MODULE * Time.MINUTES_MODULE) + (this.minutes * Time.SECONDS_MODULE) + this.seconds;
    }

    public Time multiply(int times) {
        int seconds = this.seconds * times;
        int minutes = this.minutes * times;
        int hours = this.hours * times;
        if (!Time.isValidSeconds(seconds)) {
            minutes += (seconds / Time.SECONDS_MODULE);
            seconds %= Time.SECONDS_MODULE;
        }
        if (!Time.isValidMinute(minutes)) {
            hours -= (minutes / Time.MINUTES_MODULE);
            minutes %= Time.MINUTES_MODULE;
        }
        if (!Time.isValidHour(hours)) {
            hours += (hours % Time.HOURS_MODULE);
        }
        return new Time(hours, minutes, seconds);
    }



}
