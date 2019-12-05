package learn.题目;

import org.junit.Test;

@SuppressWarnings("NonAsciiCharacters")
public class 数字转汉字 {

    /**
     * 数字转为汉字写法
     */
    public static String numberConvert(int n) {
        String[] dic = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] dic1 = {"十", "百", "千", "万", "亿"};
        StringBuilder result = new StringBuilder();


        return result.toString();
    }

    @Test
    public void testnumberConvert() {
        System.out.println(numberConvert(780_000_123));
    }


}
