// For Positive Values with no 0
// Time complexity- O(n^3)

public class LongSubArr {
	
  public static int longSubArr(int[] arr, int k){
      int n = arr.length;
      int len = 0;
      for(int i=0; i<n; i++){
        for(int j=i; j<n; j++){

          int s = 0;
          for(int m=i; m<=j; m++){
            s += arr[m] ;
          }
          
          if(s == k){
             len = Math.max(len, j-i+1);
          }
        }
        
      }
      return len; // Moved outside the loop
  }

  public static void main(String[] args){
    int[] arr = {10, 5, 2, 7, 1, 10};
    int k = 3;
    int ans = longSubArr(arr,k);
    System.out.println(ans);
  }
}
