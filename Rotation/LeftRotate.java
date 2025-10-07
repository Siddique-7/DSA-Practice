import java.util.Arrays;
import java.util.Scanner;

public class LeftRotate {

  public static int[] leftRotate(int[] arr, int target){
    leftHalfRotate(arr, target);
    rightHalfRotate(arr, target);
    allRotate(arr);
    return arr;
  }

  public static void leftHalfRotate(int[] arr, int target){
    int start = 0;
    int end = target;
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  public static void rightHalfRotate(int[] arr, int target){
    int start = target+1;
    int end = arr.length-1;
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  public static void allRotate(int[] arr){
    int start = 0;
    int end = arr.length-1;
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
  
  public static void main(String[] args) {
    int[] arr = {5, 7, 8, 2, 4, 3, 1};
    Scanner sc = new Scanner(System.in);
    System.out.println("Input position to left array rotation.");
    int target = sc.nextInt();
    int[] result = leftRotate(arr, target);
    System.out.println(Arrays.toString(result));
    sc.close();
  }
}
