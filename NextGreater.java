import java.util.Arrays;

public class NextGreater {

  public static void findNextGreater(int[] nums){
    int start = nums[0];
    int[] nextGreaterArr = new int[nums.length];
    int index = 0;
    for(int i=1; i<nums.length; i++){
      if(start < nums[i]) {
       nextGreaterArr[index] = nums[i];
       continue;
      } else {
       nextGreaterArr[index] = -1;
      }
    }
    System.out.println(Arrays.toString(nextGreaterArr));
  }
 public static void main(String[] args) {
  int[] nums = {6, 0, 8, 1, 3};
  findNextGreater(nums);
 } 
}
