import java.util.Scanner;
import java.util.Arrays;

class HashingArray{

public static int[] getSingle(int[] arr){

int n = arr.length;
// int max=Math.max(arr);
int max = 0;

for(int i:arr){
  if(i > max){
    max=i;
  }
}


int hashArr[] = new int[max+1];

System.out.println("Maximum valued element is : "+max);

for(int i=0; i<n; i++){
hashArr[arr[i]] += 1;
}
return hashArr;
} 

public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

 System.out.println("Input size of Array ");
  int n = sc.nextInt();

  int[] arr = new int [n] ;
  
  System.out.println("Input Array element ");
  for(int i=0; i<n; i++){
    arr[i] = sc.nextInt();
  }

  System.out.println("Original Array "+Arrays.toString(arr));


  int[] hashingArr = getSingle(arr);
  System.out.println("Hashed Array "+Arrays.toString(hashingArr));
  
  System.out.println("Input number of query ");
  int q = sc.nextInt();
  
  System.out.println("Input element to get frequency ");

  while(q-- != 0){
     int num = sc.nextInt();
     System.out.println(hashingArr[num]);
  }
}

}