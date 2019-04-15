package dotest.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DongYunxiang
 * @create 2018-08-22
 **/
public class RegexTest {

    public final static Map<String, Object> NAV_ITEM_ADPTER = new HashMap<String, Object>() {
       {
            put("拍录传", new Object());
            put("集群对讲", new Object());
            put("视通", new Object());
            put("位置", new Object());
            put("浏览", new Object());
            put("消息", new Object());
            put("群组", new Object());
            put("设置", null);
            put("退出", null);
        }
    };

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

        System.out.println(Arrays.asList("1",2,"56",4));


        Arrays.asList(new String[]{"", ""}, new String[]{"", ""});
    }
}
