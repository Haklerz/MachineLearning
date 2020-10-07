package com.haklerz.ml;

public class Tensor {

    private int[] shape;
    private double[] components;

    public Tensor(int... shape) {
        this.shape = shape;
        int size = 1;
        for (int i : shape)
            size *= i;
        this.components = new double[size];
    }

    public double get(int... index) {
        return components[toRaw(index)];
    }

    private int toRaw(int... index) {
        int rawIndex = 0;
        int skip = 1;
        for (int i = 0; i < index.length; i++) {
            rawIndex += index[i] * skip;
            skip *= shape[i];
        }
        return rawIndex;
    }
}
