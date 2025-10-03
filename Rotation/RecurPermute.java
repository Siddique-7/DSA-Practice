import java.util.ArrayList;
import java.util.List;

public class RecurPermute {

  // Actual recursion logic
  private static void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq){
    if(ds.size() == nums.length){
      ans.add(new ArrayList<>(ds));
      return;
    }

    // calculating each ds
    for(int i=0; i<nums.length; i++){
     if(!freq[i]){
       freq[i] = true;  // mark it as used
       ds.add(nums[i]);  // add to current permutation
       recurPermute(nums, ds, ans, freq);  // go deeper
       ds.remove(ds.size()-1);  // backtrack
       freq[i] = false;         // unmark it
     }
    }
    
  }

  // setup logic
  public static List<List<Integer>> recur (int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> ds = new ArrayList<>();        // to make indivizual sets
    boolean[] freq = new boolean[nums.length]; //  For visited tracking
    recurPermute(nums, ds, ans, freq);
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    List<List<Integer>> recursion = recur(nums);
    System.out.println(recursion);
  }
}
