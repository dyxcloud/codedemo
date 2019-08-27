package dotest.dataDeal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author DongYunxiang
 * @create 2019-06-21
 **/
public class 状态机 {
    //解析字符串, 最后导出:
    //I, have, a, good, news, :, ", hello, world, "

    int state=0;//0原始 1字符
    String result = "";
    List<String> resultList = new ArrayList<>();
    Pattern pw = Pattern.compile("\\S");
    Pattern ps = Pattern.compile("\\s");
    Pattern pquote = Pattern.compile("\"");


    public void parse(char c){
        //完成状态机逻辑
        String s = String.valueOf(c);
            if(pw.matcher(s).matches()){
                result+=s;
                state = 1;
            }else if(ps.matcher(s).matches()){
                resultList.add(result);
                result = "";
            }
    }

    final String LINE = "I have a good news :\"hello world\"";

    @Test
    public void testrun(){
        for(char c:LINE.toCharArray()){
            parse(c);
        }
        System.out.println(resultList);
    }
}
