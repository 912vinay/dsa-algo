package com.vinaypal.dsa.array;

public class RotateMatrix {
    public static void main(String[] args) {

        int[][] originalMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printMatrix(originalMatrix);

        System.out.println("After Rotation with temporary storage ");

        printMatrix(rotateMatrixWithSeparateArray(originalMatrix));

        System.out.println("After modifying the original array");

        rotateMatrixWithoutTemporaryStorage(originalMatrix);

        System.out.println();

        printMatrix(originalMatrix);




    }

    private static void rotateMatrixWithoutTemporaryStorage(int[][] originalMatrix) {

        if (originalMatrix.length == 0 || originalMatrix.length != originalMatrix[0].length) {
            System.out.println("Not possible to ratate");
            return;
        }

        for (int layer = 0; layer < originalMatrix.length / 2; layer++) {
            int first = layer;
            int last = originalMatrix.length - 1 - layer;
            for (int i = first; i < last; i++) {

                int offset = i - first;

                int top = originalMatrix[first][i];// top

                originalMatrix[first][i] = originalMatrix[last - offset][first];// left>top

                originalMatrix[last - offset][first] = originalMatrix[last][last - offset];// bottom>left

                originalMatrix[last][last - offset] = originalMatrix[i][last];//right>bottom
                originalMatrix[i][last] = top;//top>right

            }

        }


    }

    private static int[][] rotateMatrixWithSeparateArray(int[][] originalMatrix) {

        int row = originalMatrix.length;
        int col = originalMatrix[0].length;
        int[][] rotatedMatrix = new int[originalMatrix.length][originalMatrix[0].length];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rotatedMatrix[j][row - 1 - i] = originalMatrix[i][j];
            }
        }
        return rotatedMatrix;

    }

    private static void printMatrix(int[][] matrix) {

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }


}
