package week06;

/**
 * @program: test
 * @description: 回文子串
 * @author: ChenWeiJun
 * @create: 2020-11-08 19:27
 **/
public class CountSubstrings {

    public int countSubstrings(String s) {
        int count = 0;
        for (int i=0;i<s.length();i++) {
            count += find(s,i,i);
            count += find(s,i,i+1);
        }
        return count;
    }
    private int find(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;right++;count++;
        }
        return count;
    }
}
