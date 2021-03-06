package model;

import lombok.Getter;

@Getter
public class Health<T extends Comparable<T>> {

    private T current;
    private final T min;
    private final T max;

    public Health(T current, T min, T max) {
        this.current = current;
        this.min = min;
        this.max = max;
    }

    public Health(T min, T max) {
        this(max, min, max);
    }

    public void setCurrent(T current) {
        if (min.compareTo(current) > 0) {
            current = min;
        } else if (max.compareTo(current) < 0) {
            current = max;
        }
        this.current = current;
    }
}
