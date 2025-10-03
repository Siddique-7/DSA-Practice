import java.util.Arrays;

public class FirstLastBrute {

  public static int[] findFirstLast(int[] arr, int k){
      int first = -1;
      int last = -1;
      for(int i=0; i<arr.length; i++){
        if(arr[i] == k ){
         if(first == -1) first = i;
          last = i;
        }
      }
      return new int[]{first, last}; 
  }


 public static void main(String[] args) {
  int[] arr = {5, 7, 7, 8, 8, 10};
  int k = 4;
  int[] ans = findFirstLast(arr,k);
  System.out.println(Arrays.toString(ans));
 } 
}
