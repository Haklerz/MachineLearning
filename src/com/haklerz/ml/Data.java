package com.haklerz.ml;

import java.util.Arrays;

public class Data {
    private final double[] values;

    public Data(double... values) {
        this.values = values;
    }

    public double get(int index) {
        return values[index];
    }

    public int size() {
        return values.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
