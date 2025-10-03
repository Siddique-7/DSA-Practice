import java.util.ArrayList;

public class SubArr {
  
  public static void findSubArr(int[] arr){
    ArrayList<ArrayList<Integer>> allSubArr = new ArrayList<>();

    for(int i=0; i<arr.length; i++){
      ArrayList<Integer> subArr = new ArrayList<>();

        for(int j=i; j<arr.length; j++){
          subArr.add(arr[j]);
          System.out.println(subArr);
          allSubArr.add(new ArrayList<>(subArr));
        }
    }
      System.out.println(allSubArr);
  }

  public static void main(String[] args) {
    int arr[] = {4, 3, 1, 5, 6};
    findSubArr(arr);
  }
}