/*
    Write a method in java with float as its return type that takes array as input and return average as output.
*/

public class Task4_Average {
    public static float average(int[] arr) {
        if (arr == null || arr.length == 0) return 0.0f;
        int sum = 0;
        for (int v : arr) sum += v;
        return (float) sum / arr.length;
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50};
        System.out.println("Average: " + average(nums)); // 30.0
    }
}