package learn.题目.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

@SuppressWarnings("NonAsciiCharacters")
public class 数字转汉字 {

    /**
     * 数字转为汉字写法
     */
    public static String numberConvert(int n) {
        String[] dic = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] dic1 = {"","十", "百", "千"};//0,1,2,3
        String[] dic2 = {"","万", "亿","万亿","亿亿"};
        StringBuilder result = new StringBuilder();
        char[] chars = ("" + n).toCharArray();

        for(int i=0;i<chars.length;i++){
            int p = chars.length-i-1;//个位为0
            int less = (int)chars[i] - (int)'0';

            if(less==0){
                //当前为万位且千万到万之间有非零数
                if (p % 4 == 0 && IntStream.rangeClosed(i-3,i).anyMatch(z -> z >= 0 && chars[z] != '0'))
                    result.append(dic2[p / 4]);
            }else{
                //前一位非万且为0 加零
                if (i != 0 && (p + 1) % 4 != 0 && chars[i - 1] == '0')
                    result.append(dic[0]);
                result.append(dic[less]);
                result.append(dic1[p%4]);
                if(p%4==0){
                    result.append(dic2[p/4]);
                }
            }
        }
        return result.toString();
    }

    @Test
    public void testnumberConvert() {
        Assert.assertEquals("七",numberConvert(7));
        Assert.assertEquals("七亿",numberConvert(700_000_000));
        Assert.assertEquals("七亿零三",numberConvert(700_000_003));
        Assert.assertEquals("七亿零二十万零三",numberConvert(700_200_003));
        Assert.assertEquals("七亿零二十万九千零八十三",numberConvert(700_209_083));
        Assert.assertEquals("七亿一千二百二十八万七千九百九十三",numberConvert(712_287_993));
    }


}
