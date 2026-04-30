package Array;

public class MajorityElement1 {
    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,-1};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int threshold = n/2;

        int cnt = 0;
        int el = Integer.MIN_VALUE;

        for(int i : nums){
            if(cnt == 0){
                el = i;
                cnt = 1;
            }else if(i == el){
                cnt++;
            }else{
                cnt--;
            }
        }
        return el;
    }
}
