package util.values;

public class Date implements Comparable<Date> {

    public static final int MONTHS_MODULE = 12;
    public static final int DYAS_MODULE = 30;

    public static boolean isValidMonth(int month) {
        return new IntegerInterval(1, Date.MONTHS_MODULE).includes(month);
    }

    public static boolean isValidDay(int day) {
        return new IntegerInterval(1, Date.DYAS_MODULE).includes(day);
    }

    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        assert Date.isValidMonth(month) : "with month: " + month;
        assert Date.isValidDay(day) : "with day: " + day;

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean before(Date date) {
        if (this.year < date.year) {
            return true;
        }
        if (this.year == date.year) {
            if (this.month < date.month) {
                return true;
            }
            if (this.month == date.month) {
                if (this.day < date.day) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean after(Date date) {
        return !this.before(date) && !this.equals(date);
    }

    public int compareTo(Date date) {
        if (this.before(date)) {
            return -1;
        }
        if (this.equals(date)) {
            return 0;
        }
        return 1;
    }

    public Date next() {
        int year = this.year;
        int month = this.month;
        int day = this.day + 1;
        if (!isValidDay(day)) {
            day = 1;
            month++;
            if (!isValidMonth(month)) {
                month = 1;
                year++;
            }
        }
        return new Date(year, month, day);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + year;
        result = prime * result + month;
        result = prime * result + day;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Date))
            return false;
        Date other = (Date) obj;
        if (year != other.year)
            return false;
        if (month != other.month)
            return false;
        if (day != other.day)
            return false;
        return true;
    }

    public String toString() {
        return "Date [" + this.year + "/" + this.month + "/" + this.day + "]";
    }

}
