package com.haklerz.ml;

import java.util.Random;

/**
 * A tensor
 */
public class Tensor {
    private double[] values;
    private int[] shape;
    private int[] indexMap;

    /**
     * Creates a tensor of a given shape and with given values.
     * 
     * @param shape The shape
     */
    public Tensor(double[] values, int... shape) {
        if (values.length != size(shape))
            throw new IllegalArgumentException();

        this.values = values;
        this.shape = shape;
        this.indexMap = new int[shape.length];
        for (int i = 0; i < indexMap.length; i++)
            indexMap[i] = i;
    }

    /**
     * Creates a tensor of a given shape with normally distributed values.
     * 
     * @param shape
     * @return
     */
    public static Tensor normal(int... shape) {
        Random random = new Random();
        double[] values = new double[size(shape)];
        for (int i = 0; i < values.length; i++)
            values[i] = 0.01 * random.nextGaussian();

        return new Tensor(values, shape);
    }

    /**
     * Returns the value at a given set of indices.
     * 
     * @param indices
     * @return
     */
    public double get(int... indices) {
        return values[rawIndex(indices)];
    }

    /**
     * Set a value of the tensor at a given set of indices.
     * 
     * @param value
     * @param indices
     */
    public void set(double value, int... indices) {
        values[rawIndex(indices)] = value;
    }

    /**
     * Returns the shape of the tensor.
     * 
     * @return The shape of the tensor
     */
    public int[] shape() {
        return shape.clone();
    }

    /**
     * Reshapes the tensor to a new shape.
     * 
     * @param shape The new shape
     */
    public Tensor reshape(int... shape) {
        if (values.length != size(shape))
            throw new IllegalArgumentException();

        this.shape = shape;
        return this;
    }

    /**
     * Flattens the tensor.
     * 
     * @return
     */
    public Tensor flatten() {
        reshape(size(shape));
        return this;
    }

    public Tensor transpose(int axis0, int axis1) {
        int temp = indexMap[axis0];
        indexMap[axis0] = indexMap[axis1];
        indexMap[axis1] = temp;
        return this;
    }

    /**
     * Returns the raw size of a shape.
     * 
     * @param shape The shape
     * @return The size
     */
    private static int size(int... shape) {
        int size = 1;
        for (int i : shape)
            size *= i;
        return size;
    }

    /**
     * Returns the raw index.
     * 
     * @param indices
     * @return
     */
    private int rawIndex(int... indices) {
        if (indices.length != shape.length)
            throw new IllegalArgumentException();

        int rawIndex = 0;
        int stride = 1;
        for (int i = 0; i < indices.length; i++) {
            int index = indices[indexMap[i]];
            int size = shape[indexMap[i]];

            if (index < 0)
                index += size;

            if (index < 0 || index >= size)
                throw new IndexOutOfBoundsException();

            rawIndex += index * stride;
            stride *= size;
        }
        return rawIndex;
    }
}
