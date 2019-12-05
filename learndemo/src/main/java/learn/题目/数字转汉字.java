package learn.题目;

import junit.framework.TestCase;
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
            int p = chars.length-i-1;//从0开始
            int less = (int)chars[i] - (int)'0';

            if(less==0){
                if((i==chars.length+1||chars[i+1]=='0')){
                    if(p%4==0){
                        if(IntStream.rangeClosed(p/4*4,p/4*4+3).anyMatch(z->chars[z]!='0')){
                            result.append(dic2[p/4]);
                        }
                    }
                }else {
                    result.append(dic[less]);
                }
            }else{
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
        Assert.assertEquals(numberConvert(700_000_003),"七亿零三");
        Assert.assertEquals(numberConvert(700_200_003),"七亿二十万零三");
        Assert.assertEquals(numberConvert(712_287_993),"七亿一千二百二十八万七千九百九十三");
    }


}
