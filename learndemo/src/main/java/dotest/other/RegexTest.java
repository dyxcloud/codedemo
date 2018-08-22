package dotest.other;

/**
 * @author DongYunxiang
 * @create 2018-08-22
 **/
public class RegexTest {

    public static void main(String[] args) {
        String s0="21";
        String s1="1,";
        String s2="1,2";
        String s3="0,1,";

        String regex = ".*\\D*1\\D*.*";

        System.out.println(s0.matches(regex));
        System.out.println(s1.matches(regex));
        System.out.println(s2.matches(regex));
        System.out.println(s3.matches(regex));

        System.out.println(Integer.parseInt("01"));

        int[] arr = {1};
        for(int i=2;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
