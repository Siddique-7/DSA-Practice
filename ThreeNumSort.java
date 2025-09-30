// Dutch National Flag Algorithm (DNF Algorithm)

import java.util.Arrays;

class ThreeNumSort{

    public static int[] sortArr(int[] arr){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;

        while (mid <= high) {
          if(arr[mid] == 1){
            mid++;
          } else if(arr[mid] == 0){
             int temp = arr[mid];
             arr[mid] = arr[low];
             arr[low] = temp ;
             low++;
             mid++;
          } else {
             int temp = arr[mid];
             arr[mid] = arr[high];
             arr[high] = temp ;
             high--;
          }
        }
       return arr; 
    }

   public static void main(String[] args){
    int[] arr = {0, 1, 0, 2, 0, 1, 2};
    int[] ans= sortArr(arr);
    System.out.println(Arrays.toString(ans)); 
   }
}