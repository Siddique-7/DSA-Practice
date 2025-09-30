import java.util.HashMap;

public class TotalFrequency {

  public static int maxFrequencyElements(int[] nums){
    HashMap<Integer, Integer> map = new HashMap<>();

    int maxFreq = 0;
    int total = 0;

    for(int num : nums){
      int count = map.getOrDefault(num, 0)+1;
      map.put(num, count);
      
      if(count > maxFreq){
        maxFreq = count;
        total = count;
      } else if(count == maxFreq){
        total += count;
      }
    }
    return total;
  }

public static void main(String[] args){
  int[] nums = {1, 2, 2, 3, 1, 4};
  System.out.println(maxFrequencyElements(nums));
}
}