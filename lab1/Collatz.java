/** Class that prints the Collatz sequence starting from a given number.
 *  @author YOUR NAME HERE
 */
public class Collatz {

    /** Buggy implementation of nextNumber! */
    public static int nextNumber(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer.");
        }
        return (n % 2 == 0) ? (n / 2) : (3 * n + 1);
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter a positive integer: ");

        if (scanner.hasNextInt()) {  // 确保输入的是整数
            int number = scanner.nextInt();
            scanner.close();

            if (number <= 0) {
                System.out.println("Error: Please enter a positive integer.");
                return;
            }

            System.out.println("Collatz sequence:");
            while (number != 1) {
                System.out.print(number + " -> ");
                number = nextNumber(number);
            }
            System.out.println(number);
        } else {
            System.out.println("Error: Invalid input. Please enter a positive integer.");
        }
    }

}
