package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,ans);
        return ans;
    }
    public static void helper(int[] arr,int index,List<List<Integer>> ans){
        if(arr.length == index){
            List<Integer> temp = new ArrayList<>();
            for (int num : arr) {
                temp.add(num);
            }

            ans.add(temp);
            return;
        }
        for(int i = index ; i < arr.length ; i++){
            swap(arr,i,index);
            helper(arr,index+1,ans);
            swap(arr,i,index);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] =arr[j];
        arr[j] = temp;
    }
}
