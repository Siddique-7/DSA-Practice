import java.util.Arrays;

public class BubbleSort {

  public static void findBubbleSort(int[] arr){
    int n = arr.length;
    for(int i=0; i<n-1; i++){
      for(int j=0; j<n-i-1; j++){
        if(arr[i] > arr[i+1]){
          int temp = arr[i];
          arr[i] = arr[i+1];
          arr[i+1] = temp;
      }
    }
  }
  System.out.println(Arrays.toString(arr));
}
  public static void main(String[] args) {
    int[] arr = {4, 1, 3, 9, 7};
    findBubbleSort(arr);
  }
}
