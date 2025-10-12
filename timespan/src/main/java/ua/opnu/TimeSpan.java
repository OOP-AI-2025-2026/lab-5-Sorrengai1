package ua.opnu;

/**
 * Клас для представлення проміжку часу у годинах та хвилинах.
 */
public class TimeSpan {

    /** Кількість хвилин в одній годині. */
    private static final int MINS_HOUR = 60;

    /** Максимально допустима кількість хвилин (0–59). */
    private static final int MAX_MINUTES = 59;

    /** Кількість хвилин у годині у вигляді double. */
    private static final double MINS = 60.0;

    /** Кількість повних годин у проміжку часу. */
    private int hours;

    /** Кількість хвилин (0–59) у проміжку часу. */
    private int minutes;

    /** Конструктор без аргументів (0 годин 0 хвилин). */
    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    /** Конструктор з одним аргументом (хвилини). */
    public TimeSpan(final int totalMinutes) {
        if (totalMinutes < 0) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = totalMinutes / MINS_HOUR;
            this.minutes = totalMinutes % MINS_HOUR;
        }
    }

    /** Конструктор з двома аргументами (години та хвилини). */
    public TimeSpan(final int initHours, final int initMinutes) {
        if (initHours < 0 || initMinutes < 0 || initMinutes > MAX_MINUTES) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = initHours;
            this.minutes = initMinutes;
        }
    }

    /** Конструктор (з вхідного TimeSpan). */
    public TimeSpan(final TimeSpan other) {
        this(other.hours, other.minutes);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getTotalMinutes() {
        return hours * MINS_HOUR + minutes;
    }

    public double getTotalHours() {
        return hours + (minutes / MINS);
    }

    /** Додає години та хвилини. */
    public void add(final int addHours, final int addMinutes) {
        if (addHours < 0 || addMinutes < 0 || addMinutes > MAX_MINUTES) {
            return;
        }
        int total = getTotalMinutes() + (addHours * MINS_HOUR + addMinutes);
        hours = total / MINS_HOUR;
        minutes = total % MINS_HOUR;
    }

    /** Додає хвилини. */
    public void add(final int addMinutes) {
        if (addMinutes < 0) {
            return;
        }
        int total = getTotalMinutes() + addMinutes;
        hours = total / MINS_HOUR;
        minutes = total % MINS_HOUR;
    }

    /** Додає інший об’єкт TimeSpan. */
    public void add(final TimeSpan other) {
        add(other.hours, other.minutes);
    }

    /** Віднімає години та хвилини. */
    public void subtract(final int subHours, final int subMinutes) {
        int totalThis = getTotalMinutes();
        int totalOther = subHours * MINS_HOUR + subMinutes;
        if (subHours < 0 || subMinutes < 0 || subMinutes > MAX_MINUTES || totalOther > totalThis) {
            return;
        }
        int diff = totalThis - totalOther;
        hours = diff / MINS_HOUR;
        minutes = diff % MINS_HOUR;
    }

    /** Віднімає хвилини. */
    public void subtract(final int subMinutes) {
        if (subMinutes < 0 || subMinutes > getTotalMinutes()) {
            return;
        }
        int diff = getTotalMinutes() - subMinutes;
        hours = diff / MINS_HOUR;
        minutes = diff % MINS_HOUR;
    }

    /** Віднімає інший об’єкт TimeSpan. */
    public void subtract(final TimeSpan other) {
        subtract(other.hours, other.minutes);
    }
    /** Масштабує інтервал на заданий множник. */
    public void scale(final int factor) {
        if (factor <= 0) {
            return;
        }
        int total = getTotalMinutes() * factor;
        hours = total / MINS_HOUR;
        minutes = total % MINS_HOUR;
    }

    @Override
    public String toString() {
        return String.format("%d год. %d хв.", hours, minutes);
    }
}
