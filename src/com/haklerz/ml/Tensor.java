package com.haklerz.ml;

/**
 * A tensor
 */
public class Tensor {
    private int[] shape;
    private double[] values;

    /**
     * Creates a tensor of a given shape and with given values.
     * 
     * @param shape The shape
     */
    public Tensor(int[] shape, double[] values) {
        this.shape = shape;
        this.values = values;
    }

    /**
     * Creates a tensor of a given shape.
     * 
     * @param shape
     */
    public Tensor(int... shape) {
        this(shape, new double[size(shape)]);
    }

    public static Tensor rand(int... shape) {
        return new Tensor(shape);
    }

    /**
     * Returns the shape of the tensor.
     * 
     * @return The shape of the tensor
     */
    public int[] shape() {
        return shape;
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
        int index = 0;
        int stride = 1;
        for (int i = 0; i < indices.length; i++) {
            index += indices[i] * stride;
            stride *= shape[i];
        }
        return index;
    }

    /**
     * Reshapes the tensor to a new shape.
     * 
     * @param shape The new shape
     */
    public void reshape(int... shape) {
        if (values.length != size(shape)) {
            throw new IllegalArgumentException();
        }
        this.shape = shape;
    }
}
