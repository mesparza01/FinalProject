import java.util.Scanner;

public class recursiveAndIterative {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
			//nth element input
			System.out.print("Enter the Value for Fibonacci Sequence: ");
			int n = sc.nextInt();

			//Print out iteration method
			System.out.println("Fibonacci iteration:");
			long startTime = System.nanoTime(); 
			System.out.printf("Fibonacci sequence(element at index %d) = %d \n", n, fibIteration(n));
			System.out.printf("Time: %d ns\n", System.nanoTime() - startTime);

			//Print out recursive method
			System.out.println("Fibonacci recursion:");
			long start= System.nanoTime(); 
			System.out.printf("Fibonacci sequence(element at index %d) = %d \n", n, fibRecursion(n));
			System.out.printf("Time: %d ns\n", System.nanoTime() - start);
		}
    }

    //Iteration function
    static int fibIteration(int n) {
        int x = 0, y = 1, z = 1;
        for (int i = 0; i < n; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return x;
    }

    //Recursive function
    static int fibRecursion(int  n) {
        if (n == 0) 
            return 0;
        if (n == 1)
        	return 1;
        
        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }
}