// For Positive Values with no 0
// Time complexity- O(n^2)

public class LongSubArr2{

  public static int getLargeArr(int[] arr, int k){
    int n = arr.length;
    int len = 0;
    for(int i=0; i<n; i++){
      int s = 0;
      for(int j=i; j<n; j++){
         s += arr[j];
         if(s == k){
          len = Math.max(len, j-i+1);
         }
      }
    }
    return len;
  }

  public static void main(String[] args){
    int[] arr = {10, 5, 2, 7, 1, 10,1,4};
    int k = 15;
    int ans = getLargeArr(arr,k);
    System.out.println(ans);
  }
}