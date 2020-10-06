package com.haklerz.ml;

public class Neuron implements Model {
    private double[] weights;
    private final Activation activation;

    public Neuron(int inputSize, Activation activation) {
        this.weights = new double[inputSize + 1];
        this.activation = activation;
    }

    @Override
    public Data predict(Data input) {
        if (input.size() != weights.length - 1)
            throw new IllegalArgumentException();

        double sum = weights[weights.length - 1];
        for (int i = 0; i < input.size(); i++)
            sum += input.get(i) * weights[i];

        return new Data(activation.evaluate(sum));
    }
}
