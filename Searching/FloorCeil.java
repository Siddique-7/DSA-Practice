public class FloorCeil {

public static int ceil(int[] arr, int k){
  if(k > arr[arr.length-1]) return -1;
  int s = 0;
  int e = arr.length-1;
  while (s<=e) {
    int mid = s + (e-s)/2;
    if(arr[mid] > k){
      e = mid - 1;
    } else if(arr[mid] < k){
      s = mid+1;
    } else {
      return mid ;
    }
  }
  return s;
}


public static int floor(int[] arr, int t){
  if(t < arr[0]) return -1;
  int s = 0;
  int e = arr.length-1;
  while (s<=e) {
    int mid = s + (e-s)/2;
    if(arr[mid] > t){
      e = mid - 1;
    } else if(arr[mid] < t){
      s = mid+1;
    } else {
      return mid ;
    }
  }
  return e;
}


  public static void main(String[] args) {
    int[] arr = {5, 6, 8, 10, 12, 15};
    int k = 11;
    int t = 4;
    int ceil = ceil(arr,k);
    System.out.println(ceil);
    int floor = floor(arr,t);
    System.out.println(floor);
  }
}
