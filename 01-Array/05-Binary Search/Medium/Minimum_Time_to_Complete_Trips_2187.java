import java.util.*;

public class Minimum_Time_to_Complete_Trips_2187 {

    public static long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long right = (long) Arrays.stream(time).min().getAsInt() * (long) totalTrips;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canComplete(time, totalTrips, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canComplete(int[] time, int totalTrips, long t) {
        long trips = 0;
        for (int tt : time) {
            trips += t / tt;
            if (trips >= totalTrips) return true;
        }
        return trips >= totalTrips;
    }

    public static void main(String[] args) {
        int[] time = {1, 2, 3};
        int totalTrips = 5;
        System.out.println("Minimum time to complete trips: " + minimumTime(time, totalTrips)); // Output: 3
    }
}
