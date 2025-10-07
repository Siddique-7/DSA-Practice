import java.util.Arrays;

public class BubbleSort {
   public BubbleSort() {
   }

   public static void findBubbleSort(int[] var0) {
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1 - 1; ++var2) {
         for(int var3 = 0; var3 < var1 - var2 - 1; ++var3) {
            if (var0[var2] > var0[var2 + 1]) {
               int var4 = var0[var2];
               var0[var2] = var0[var2 + 1];
               var0[var2 + 1] = var4;
            }
         }
      }

      System.out.println(Arrays.toString(var0));
   }

   public static void main(String[] var0) {
      int[] var1 = new int[]{4, 1, 3, 9, 7};
      findBubbleSort(var1);
   }
}
