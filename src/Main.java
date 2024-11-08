import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read dimensions and elements of Matrix A
        System.out.println("Matrix A:");
        String[] dimensionsA = scanner.nextLine().split(",");
        int n = Integer.parseInt(dimensionsA[0].trim());
        int m = Integer.parseInt(dimensionsA[1].trim());

        int[][] matrixA = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }
        scanner.nextLine(); // Consume the newline character

        // Read dimensions and elements of Matrix B
        System.out.println("Matrix B:");
        String[] dimensionsB = scanner.nextLine().split(",");
        int m2 = Integer.parseInt(dimensionsB[0].trim());
        int p = Integer.parseInt(dimensionsB[1].trim());


        int[][] matrixB = new int[m2][p];
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < p; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // Perform matrix multiplication
        int[][] matrixC = multiplyMatrices(matrixA, matrixB, n, m, p);

        // Display the result
        System.out.println("Matrix C:");
        printFormattedMatrix(matrixC);

        scanner.close();
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB, int n, int m, int p) {
        int[][] result = new int[n][p];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < m; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    // Method to print a matrix in the specified format
    public static void printFormattedMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("| ");
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println("|");
        }
    }
}
