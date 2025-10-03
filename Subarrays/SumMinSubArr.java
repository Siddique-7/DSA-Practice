import java.util.ArrayList;

public class SumMinSubArr {

public static void findMinSum(int[] nums){
  ArrayList<ArrayList<Integer>> listTwoD = new ArrayList<>();
  int minSum = 0;
  for(int i=0; i<nums.length; i++){
    ArrayList<Integer> listOneD = new ArrayList<>();
    int min = nums[i];
    for(int j=i; j<nums.length; j++){
        listOneD.add(nums[j]);
        min = Math.min(min, nums[j]);
        System.out.println(listOneD);
        minSum += min ;
        listTwoD.add(new ArrayList<>(listOneD));
    }
  }
  System.out.println(listTwoD);
  System.out.println(minSum);
}

  public static void main(String[] args) {
    int[] arr = {2, 5, 1, 6};
    findMinSum(arr);
  }
}
