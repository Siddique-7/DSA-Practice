public class AllDivisor {

  public static int findDivisorSum(int n){
    int sum = 0;
    for(int i = 1; i<=n; i++){
    int count = 0;
    int j = 1;
      while (j<=i) {
        if(i%j == 0){
          count += j;
        }
        j++;
      }
      sum += count ;
    }
    return sum;
  }
  public static void main(String[] args) {
    int n = 5;
    int ans = findDivisorSum(n);
    System.out.println(ans);
  }
}
