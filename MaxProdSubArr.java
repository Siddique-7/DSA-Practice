class MaxProdSubArr{

  private static int findMaxProd(int[] nums){
    int n = nums.length;
    int maxProd = nums[0];
    int minProd = nums[0];
    int ans = nums[0];
    for(int i=1; i<n; i++){
      if(nums[i]<0){
        int temp = maxProd;
        maxProd = minProd;
        minProd = temp;
      }
        maxProd = Math.max(nums[i], maxProd*nums[i]);
        minProd = Math.min(nums[i], minProd*nums[i]);
        ans = Math.max(ans, maxProd);
      
    }
    return ans;
  }
  public static void main(String[] args) {
    int[] nums = {2, 3, -2, 4};
    int result = findMaxProd(nums);
    System.out.println(result);
  }
}