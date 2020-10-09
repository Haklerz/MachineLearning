package com.haklerz.ml;

public class Tensor {
    private int[] shape;
    private double[] components;

    public Tensor(int... shape) {
        this.shape = shape;
        this.components = new double[size(shape)];
    }

    private int size(int... shape) {
        int size = 1;
        for (int i : shape)
            size *= i;
        return size;
    }

    public int[] shape() {
        return shape;
    }

    public double get(int...indices) {
        return components[raw(indices)];
    }

    private int raw(int... indices) {
        int index = 0;
        int stride = 1;
        for (int i = 0; i < indices.length; i++) {
            index += indices[i] * stride;
            stride *= shape[i];
        }
        return index;
    }

    public void reshape(int... shape) {
        if (components.length != size(shape)) {
            throw new IllegalArgumentException();
        }
        this.shape = shape;
    }

    public void flatten() {
        reshape(size(shape));
    }
}
