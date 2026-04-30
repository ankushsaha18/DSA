package Array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 3, 2, 2, 3};
        System.out.println(majorityElementTwo(nums));
    }
    public static List<Integer> majorityElementTwo(int[] nums) {
        int n = nums.length;

        // Counts for elements el1 and el2
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        // this loop find the max 2 occurring elements but not their exact count
        for (int num : nums) {
            if (cnt1 == 0 && el2 != num) {
                cnt1 = 1;
                el1 = num;
            } else if (cnt2 == 0 && el1 != num) {
                cnt2 = 1;
                el2 = num;
            } else if (num == el1) {
                cnt1++;
            } else if (num == el2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // get exact counts
        cnt1 = 0; cnt2 = 0;
        for (int num : nums) {
            if (num == el1) {
                cnt1++;
            }
            if (num == el2) {
                cnt2++;
            }
        }
        int mini = n / 3 + 1;
        List<Integer> result = new ArrayList<>();
        if (cnt1 >= mini) {
            result.add(el1);
        }
        if (cnt2 >= mini && el1 != el2) {
            result.add(el2);
        }
        return result;
    }
}
