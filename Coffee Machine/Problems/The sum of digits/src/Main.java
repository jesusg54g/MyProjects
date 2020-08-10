import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int number = 1;
        while ((int) Math.pow(number, 2) < n) {
            System.out.println((int) Math.pow(number, 2));
            number++;
        }
    }
}
