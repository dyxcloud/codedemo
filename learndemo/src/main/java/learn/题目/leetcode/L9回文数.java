package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

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
        TestCase.assertTrue(isPalindrome(121));
        TestCase.assertFalse(isPalindrome(-121));
        TestCase.assertFalse(isPalindrome(10));
        TestCase.assertFalse(isPalindrome(-101));
    }

}
