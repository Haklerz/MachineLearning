package com.haklerz.ml;

public class Test {
    public static void main(String[] args) {
        Tensor X = Tensor.normal(3, 3);

        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++)
                System.out.print(String.format("%10.6f ", X.get(col, row)));
            System.out.println();
        }


        /*
         * Model model = new Input(24 * 24)
         *      .add(new Dense(16, Activation.RELU))
         *      .add(new Dense(16, Activation.RELU))
         *      .add(new Dense(10, Activation.ARGMAX));
         */

    }
}
