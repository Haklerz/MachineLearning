package com.haklerz.ml;

public class Model {
    private final int INPUT_SIZE;
    private Model child;

    public Model(int inputSize) {
        this.INPUT_SIZE = inputSize;
    }

    public Data predict(Data input) {
        if (input.size() != INPUT_SIZE)
            throw new IllegalArgumentException();

        return (child == null) ? input : child.predict(input);
    }

    public Model add(Model child) {
        return this.child = child;
    }
}
