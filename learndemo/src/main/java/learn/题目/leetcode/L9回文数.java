package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class L9回文数 {

    public boolean isPalindrome(int x) {
        char[] str = String.valueOf(x).toCharArray();
        int l=0,r=str.length-1;
        while(l<=r){
            if(str[l]!=str[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    @Test
    public void ttt(){
        Assertions.assertTrue(isPalindrome(121));
        Assertions.assertFalse(isPalindrome(-121));
        Assertions.assertFalse(isPalindrome(10));
        Assertions.assertFalse(isPalindrome(-101));
    }

}
