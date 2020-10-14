package com.haklerz.ml.layer;

import com.haklerz.ml.Activation;
import com.haklerz.ml.Tensor;

public class Dense extends Layer {
    private final Tensor weights;
    private final Activation activation;

    public Dense(int layerSize, int inputSize, Activation activation) {
        super(layerSize);
        this.weights = Tensor.normal(layerSize, inputSize);
        this.activation = activation;
    }

    @Override
    public Tensor forward(Tensor input) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
