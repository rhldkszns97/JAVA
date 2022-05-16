import java.util.*;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getUserInput(scanner.nextInt());
    }
    static void getUserInput(int n) {
        getFibonacci(n);
    }

    static void getFibonacci(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i=2; i<n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        printNumbers(arr);
    }

    static void printNumbers(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
