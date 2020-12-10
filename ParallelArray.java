import java.util.Random;

public class ParallelArray {

	public static void main(String[] args){
	    Random rand = new Random();

	    int[] arr = new int[200000000];

	    for (int i = 0; i < arr.length; i++) {
	        arr[i] = rand.nextInt(11) + 1; // 1..10
	    }

	    long start = System.currentTimeMillis();

	    Summation.sum(arr);

	    System.out.println("Single: " + (System.currentTimeMillis() - start)); 

	    start = System.currentTimeMillis();

	    Summation.parallelSum(arr);

	    System.out.println("Multiple : " + (System.currentTimeMillis() - start)); 
	}
}