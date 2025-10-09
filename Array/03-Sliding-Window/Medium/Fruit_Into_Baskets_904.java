import java.util.*;

public class Fruit_Into_Baskets_904 {

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            countMap.put(fruits[right], countMap.getOrDefault(fruits[right], 0) + 1);

            // Shrink window if more than 2 distinct fruits
            while (countMap.size() > 2) {
                int leftFruit = fruits[left];
                countMap.put(leftFruit, countMap.get(leftFruit) - 1);
                if (countMap.get(leftFruit) == 0) countMap.remove(leftFruit);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of trees: ");
        int n = sc.nextInt();

        int[] fruits = new int[n];
        System.out.println("Enter the fruits on trees (as integers):");
        for (int i = 0; i < n; i++) {
            fruits[i] = sc.nextInt();
        }

        int result = totalFruit(fruits);
        System.out.println("Maximum fruits collected: " + result);

        sc.close();
    }
}
