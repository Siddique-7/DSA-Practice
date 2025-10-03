import java.util.HashMap;
public class DuplicateNum {

  public static int findDuplicateNum(int[] nums){
     HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
     for(int num : nums){
       int count = map.getOrDefault(num, 0)+1;
       if(count > 1){
        return num;
       }
       map.put(num, count);
     }
     return -1;
  }

  public static void main(String[] args){
    int[] nums = {1, 2, 3, 4, 5, 4};
    System.out.println(findDuplicateNum(nums));
  }
}
