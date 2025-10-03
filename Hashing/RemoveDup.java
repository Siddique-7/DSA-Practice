import java.util.ArrayList;

public class RemoveDup {

  public static ArrayList<Integer> removeDup(int[] arr){
    int n = arr.length;
    ArrayList<Integer> list = new ArrayList<>();
    list.add(arr[0]);

    for(int i = 1; i < n; i++){
      if(arr[i] == arr[i-1]){
      continue;
      } else {
        list.add(arr[i]);
      }
    }
    return list;
  }
  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 2, 2, 4, 4, 5, 6, 6};
    ArrayList<Integer> result = removeDup(arr);
    System.out.println(result);
  }
}
