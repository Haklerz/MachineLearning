package com.haklerz.ml;

public class Layer implements Model {
    private Neuron[] neurons;

    public Layer(int size, Neuron neuron) {
        this.neurons = new Neuron[size];
        for (int i = 0; i < neurons.length; i++)
            neurons[i] = new Neuron(neuron);
    }

    @Override
    public Data predict(Data input) {
        double[] output = new double[neurons.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = neurons[i].predict(input).get();
        }
        return new Data(output);
    }
}
