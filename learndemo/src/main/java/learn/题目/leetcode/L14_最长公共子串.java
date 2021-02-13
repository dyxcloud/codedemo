package learn.题目.leetcode;

/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class L14_最长公共子串 {

    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "qqqqqqqqqcdefdddddddddddd";
        String s = getMaxSubstring(s1, s2);
        System.out.println("s = " + s);
    }

    private static String getMaxSubstring(String s1, String s2) {
        String max, min;
        max = s1.length() > s2.length() ? s1 : s2;
        min = s1.length() < s2.length() ? s1 : s2;

        //外围控制子串长度, 长>短
        for (int i = 0; i < min.length(); i++) {
            //控制子串在min中的位置, 从左到右
            for (int x = 0,y=min.length()-i; y!=min.length()+1; x++,y++) {
                String sub=min.substring(x, y);
                if(max.contains(sub)){
                    return sub;
                }
            }
        }
        return null;
    }
}
