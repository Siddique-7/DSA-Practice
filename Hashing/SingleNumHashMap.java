import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class SingleNumHashMap {
	
  public static int getSingle(int[] arr){

   int n = arr.length;
   HashMap<Integer, Integer> map = new HashMap<>(); 

   // hashing
   for(int i=0; i<n; i++){
    int value = map.getOrDefault(arr[i] , 0);
    map.put(arr[i] , value+1);
   }

    System.out.println("Hash Map is: "+map);

  // retrieval
  for(Map.Entry<Integer, Integer> entry : map.entrySet()){
    if(entry.getValue() == 1){
      return entry.getKey();
    }
  }
    return -1 ;
  }

  public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

 System.out.println("Input size of Array ");
  int n = sc.nextInt();

  int[] arr = new int [n] ;
  
  System.out.println("Input Array element ");
  for(int i=0; i<n; i++){
    arr[i] = sc.nextInt();
  }
 System.out.println("Original Array "+Arrays.toString(arr));

 int ans = getSingle(arr);
 System.out.println("The Single element is: "+ans);

 sc.close();
}
  }