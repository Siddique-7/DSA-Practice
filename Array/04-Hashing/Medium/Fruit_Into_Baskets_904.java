import java.util.*;

public class Fruit_Into_Baskets_904 {

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, maxFruits = 0;

        // Expand the right boundary of the window
        for (int right = 0; right < fruits.length; right++) {
            int fruit = fruits[right];
            basket.put(fruit, basket.getOrDefault(fruit, 0) + 1);

            // If more than 2 fruit types, shrink from left
            while (basket.size() > 2) {
                int leftFruit = fruits[left];
                basket.put(leftFruit, basket.get(leftFruit) - 1);
                if (basket.get(leftFruit) == 0) {
                    basket.remove(leftFruit);
                }
                left++;
            }

            // Update max fruits collected
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        int[] fruits = {1, 2, 1};
        System.out.println("Max fruits: " + totalFruit(fruits));
        // Output: 3

        int[] fruits2 = {0, 1, 2, 2};
        System.out.println("Max fruits: " + totalFruit(fruits2));
        // Output: 3 → from subarray [1,2,2]

        int[] fruits3 = {1, 2, 3, 2, 2};
        System.out.println("Max fruits: " + totalFruit(fruits3));
        // Output: 4 → from subarray [2,3,2,2]
    }
}
