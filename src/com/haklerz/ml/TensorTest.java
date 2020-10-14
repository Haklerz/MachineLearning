package com.haklerz.ml;

public class TensorTest {
    public static void main(String[] args) {
        Tensor X = Tensor.normal(3, 3);

        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++)
                System.out.print(String.format("%10.6f ", X.get(col, row)));
            System.out.println();
        }

        Model model = new Model(64 * 64)
            .addDense(1000, Activation.RELU)
            .addDense(400, Activation.RELU)
            .addDense(1000, Activation.RELU)
            .addDense(64 * 64, Activation.SIGMOID);

    }
}
