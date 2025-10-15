import java.util.PriorityQueue;

public class Kth_Smallest_Element_In_Sorted_Matrix_378 {

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }

        int number = 0;
        for (int i = 0; i < k; i++) {
            int[] cur = minHeap.poll();
            number = cur[0];
            int row = cur[1], col = cur[2];

            if (col + 1 < n) {
                minHeap.offer(new int[]{matrix[row][col+1], row, col+1});
            }
        }

        return number;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,5,9},
            {10,11,13},
            {12,13,15}
        };
        int k = 8;
        System.out.println("Kth smallest element: " + kthSmallest(matrix, k)); // Output: 13
    }
}
