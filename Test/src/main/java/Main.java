import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("x^2: ");
        int a11 = sc.nextInt();
        System.out.println("y^2: ");
        int a22 = sc.nextInt();
        System.out.println("z^2: ");
        int a33 = sc.nextInt();
        System.out.println("xy: ");
        int a12 = sc.nextInt() / 2;
        System.out.println("xz: ");
        int a13 = sc.nextInt() / 2;
        System.out.println("yz: ");
        int a23 = sc.nextInt() / 2;
        System.out.println("x: ");
        int a14 = sc.nextInt() / 2;
        System.out.println("y: ");
        int a24 = sc.nextInt() / 2;
        System.out.println("z: ");
        int a34 = sc.nextInt() / 2;
        System.out.println("a44: ");
        int a44 = sc.nextInt();

        int I1 = a11 + a22 + a33;
        int I2 = a22*a33 - a23*a23 + a11*a33 - a13*a13 + a11*a22 - a12*a12;
        int I3 = a11*a22*a33 + a12*a23*a13 + a13*a12*a23 - a13*a22*a13 - a23*a23*a11 - a33*a12*a12;
        int I4 = a11*a22*a33*a44 + a12*a23*a34*a14 + a13*a24*a13*a24 + a14*a12*a23*a34 - a14*a23*a23*a14 - a24*a33*a24*a11 - a34*a34*a12*a12 - a44*a13*a22*a13;
        int K2 = a33*a44 - a34*a34 + a22*a44 - a24*a24 + a11*a44 - a14*a14;
        int K3 = a22*a33*a44 + a23*a34*a24 + a24*a23*a34 - a24*a33*a24 - a34*a34*a22 - a44*a23*a23 + a11*a33*a44 + a13*a34*a14 + a14*a13*a34 - a14*a33*a14 - a34*a34*a11 - a44*a13*a13 + a11*a22*a44 + a12*a24*a14 + a14*a12*a24 - a14*a22*a14 - a24*a24*a11 - a44*a12*a12;

        if(I3 != 0){
            System.out.println("Центральная кривая");
        }
        else{
            if(I4 != 0){
                System.out.println("Парабалоиды");
            }
            else{
                if(I2 != 0){
                    System.out.println("Цилиндры");
                }
                else{
                    if(K3 != 0){
                        System.out.println("4");
                    }
                    else{
                        System.out.println("5");
                    }
                }
            }
        }
    }
}
