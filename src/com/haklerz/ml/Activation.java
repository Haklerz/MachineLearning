package com.haklerz.ml;

/**
 * Activation
 */
public interface Activation {
    public static final Activation LINEAR = x -> x;
    public static final Activation HEAVISIDE = x -> (x < 0) ? 0 : 1;
    public static final Activation RELU = x -> Math.max(0, x);
    public static final Activation SIGMOID = x -> 1 / (1 + Math.exp(-x));
    public static final Activation TANH = x -> Math.tanh(x);
    public static final Activation SWISH = x -> x / (1 + Math.exp(-x));

    public double evaluate(double x);
}