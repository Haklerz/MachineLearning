package com.haklerz.ml;

import com.haklerz.ml.layer.Dense;
import com.haklerz.ml.layer.Input;
import com.haklerz.ml.layer.Layer;

public class Model {
    private Layer lastLayer;

	public Model(int inputSize) {
        addLayer(new Input(inputSize));
    }
    
    private void addLayer(Layer layer) {
        this.lastLayer = layer;
    }

	public Model addDense(int size, Activation activation) {
        addLayer(new Dense(size, lastLayer.size(), activation));
		return this;
    }
    
    public Model addActivation(Activation activation) {
        return this;
    }

    public Model addConvolution() {
        return this;
    }

    public Model addPooling() {
        return this;
    }

    public Model addDropout(double rate) {
        return this;
    }

    public Model addReshape(int... shape) {
        return this;
    }
}
