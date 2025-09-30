public class SecLarge {

  public static void findSecLarge(int[] arr){
    int n = arr.length;
    if (n == 0) {
      System.out.println("null array");
    }
    int large = 0;
    int secLarge = 0;

    for(int i=0; i<n; i++){
      if(arr[i] > large) {
      large = arr[i];
  }
}

for(int i=0; i<n; i++){
  if(arr[i] < large && arr[i] > secLarge){
    secLarge = arr[i];
  }
}

System.out.println(secLarge);
 }

  public static void main(String[] args) {
    int arr[] = {5, 90, 80, 2, 4, 3};
    findSecLarge(arr);
    }
}