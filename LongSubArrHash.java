import java.util.*;

class LongSubArrHash{

  public static int getLongestSubarray(int[] arr, long k){
    int maxLen = 0;
    int n = arr.length;
    int sum = 0;
    HashMap<Long, Integer> preSumMap = new HashMap<>();

    for(int i=0; i<n; i++){
      sum += arr[i];
      
      if(sum == k){
        maxLen = Math.max(maxLen, i+1);
      }
     long rem = sum - k;

     if(preSumMap.containsKey(rem) == k){
         int len = i - preSumMap.get(rem);
         maxLen = Math.max(maxLen, len);
     }

      preSumMap.get(sum) = i ;

                  //  OR 

  //    if(!preSumMap.containsKey(sum)){
  //        preSumMap.put(sum, i);
  //    }
    }
     return maxLen;
   }

  public static void main(String[] args){

        int[] a = {2, 3, 5, 1, 9};
        // int[] a = {2, 0, 0, 3};
        long k = 10;
        // long k = 3;

        int len = getLongestSubarray(a, k);
        System.out.println("The length of the longest subarray is: " + len);
  }
}