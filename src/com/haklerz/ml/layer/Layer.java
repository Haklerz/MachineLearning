package com.haklerz.ml.layer;

import com.haklerz.ml.Tensor;

public interface Layer {

    public Tensor forward(Tensor input);

}
