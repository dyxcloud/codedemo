package dotest.dataDeal;

/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class 最大子串 {

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

        for (int i = 0; i < min.length(); i++) {
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
