package Recursion.Backtracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(permuteUnique(s));
    }
    public static List<String> permuteUnique(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        boolean[] used = new boolean[arr.length];
        backtrack(arr, used, path, result);
        return result;
    }

    private static void backtrack(char[] arr, boolean[] used, StringBuilder path, List<String> result) {
        if (path.length() == arr.length) {
            result.add(path.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue; // leave duplicate

            used[i] = true;
            path.append(arr[i]);
            backtrack(arr, used, path, result);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }
}
