import java.util.Scanner;

class Master {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int number = 1;
        while (number * number <= n) {
            System.out.println(number * number);
            number++;
        }
    }
}
