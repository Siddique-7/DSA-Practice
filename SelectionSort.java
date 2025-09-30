import java.util.Arrays;

public class SelectionSort {

  public static void selectionSort(int[] nums){
    int n = nums.length;
    for(int i=0; i<n-1; i++){
       int min = i;
       for(int j=i+1; j<n; j++){ // two pointer min & j
        if(nums[min] > nums[j]){
         min = j;
        }
       }
       if(nums[i] > nums[min]){
          int temp = nums[i];
          nums[i] = nums[min];
          nums[min] = temp ;
    }
  }
    System.out.println(Arrays.toString(nums));
}
  public static void main(String[] args) {
    int[] arr = {4, 1, 3, 9, 7};
    selectionSort(arr);
  }
}
