
import java.util.Scanner;

public class Hashing {
	
	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	
	// input
	int n = sc.nextInt();

	int[] arr = new int[n];
	
	// input- storing orig array element
    for(int i=0; i<n; i++) {
    	arr[i] = sc.nextInt() ;
    }
    
    // hashing
    int[] hashArray = new int[13];
    for (int i =0; i<n; i++) {
    	hashArray[arr[i]] += 1;
    }
    
    // input - query  
    int q = sc.nextInt();
    while(q-- != 0) {
    	int number ;
    	number = sc.nextInt();
    	System.out.println(hashArray[number]);
    }
    sc.close();
    }
}
