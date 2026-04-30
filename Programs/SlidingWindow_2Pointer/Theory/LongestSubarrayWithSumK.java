package SlidingWindow_2Pointer.Theory;

public class LongestSubarrayWithSumK {
    // Find the longest length with sum <= k
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 7, 10};
        System.out.println(longestSubarrayWithSum(arr,4));
    }
    public static int longestSubarrayWithSum(int[] arr, int k) {
        int sum = 0;
        int left = 0;
        int max = 0;
        for(int right = 0 ; right < arr.length ; right++){
            sum += arr[right];
            while(sum > k){
                sum -= arr[left];
                left++;
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
