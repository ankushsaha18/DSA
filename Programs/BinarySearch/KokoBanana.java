package BinarySearch;

public class KokoBanana {
    public static void main(String[] args) {
        int[] nums = {7, 15, 6, 3};
        System.out.println(minimumRateToEatBananas(nums,8));
    }
    public static int minimumRateToEatBananas(int[] nums, int h) {
        int low = 1;
        int high = findMax(nums);
        while (low <= high){
            int mid = low + (high - low)/2;
            int sum = calculateSum(nums,mid);
            if(sum <= h){
                // reverse signing as we are dividing
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    private static int findMax(int[] nums){
        int max = nums[0];
        for(int num: nums){
            max = Math.max(num,max);
        }
        return max;
    }
    private static int calculateSum(int[] nums,int hourly){
        int sum = 0;
        for(int num : nums){
            sum += (num + hourly - 1)/hourly;
        }
        return sum;
    }
}
