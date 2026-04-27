package SlidingWindow_2Pointer.Questions;

public class LongestPalindromeSubstring {
    public static String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0 ; i < s.length() ; i++){
            String odd = findPalindrome(i-1,i+1,s,String.valueOf(s.charAt(i)));
            String even = findPalindrome(i,i+1,s,"");
            if(odd.length() > ans.length()) ans = odd;
            if(even.length() > ans.length()) ans = even;
        }
        return ans;
    }
    public static String findPalindrome(int l,int r,String s,String cur){
        StringBuilder curBuilder = new StringBuilder(cur);
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            curBuilder = new StringBuilder(s.charAt(l) + curBuilder.toString() + s.charAt(r));
            l--;
            r++;
        }
        cur = curBuilder.toString();
        return cur;
    }

    public static void main(String[] args) {
        String test = "cbbd";
        System.out.println(longestPalindrome(test));
    }
}
