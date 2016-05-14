import java.util.*;

public class MG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int str = sc.nextInt();
        int sto = sc.nextInt();
        double matrix[][] = new double[str][sto];

        for (int i = 0; i < str; i++) {
            for (int j = 0; j < sto; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < str - 1; i++) {
            for (int k = i + 1; k < str; k++) {
                double x = matrix[k][i] / matrix[i][i];
                for (int j = 0; j < sto; j++) {
                    matrix[k][j] = matrix[i][j] * x - matrix[k][j];
                }
            }
        }

        for (int i = 0; i < str; i++) {
            for (int j = 0; j < sto; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        if(check(matrix, str, sto)){
            System.out.print("Единственное решение есть");
        }
        else
            System.out.println("Единственного решения нет");
    }

    public static boolean check(double [][]array, int str, int sto){
        boolean b = true;
        for (int i = 0; i < sto - 2; i++) {
            if(array[str - 1][i] != 0)
                b = false;
        }
        return b;
    }
}