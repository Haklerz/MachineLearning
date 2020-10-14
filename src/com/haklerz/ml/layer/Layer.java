package com.haklerz.ml.layer;

import com.haklerz.ml.Tensor;

public abstract class Layer {

    private final int layerSize;

    public Layer(int layerSize) {
        this.layerSize = layerSize;
	}

	public abstract Tensor forward(Tensor input);

    public int size() {
        return layerSize;
    }
}
