package learn.题目.剑指offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2019-12-09
 **/
@SuppressWarnings("NonAsciiCharacters")
public class Offer05替换空格 {

    public String replaceSpace(String s) {
        if (s == null) return null;
        StringBuilder str = new StringBuilder(s);
        int len = str.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                count++;
                str.append("  ");
            }
        }
        for (int i = len - 1; i >= 0 && count > 0; i--) {
            char tmp = str.charAt(i);
            int newp = i + 2 * count;
            if (tmp == ' ') {
                str.setCharAt(newp, '0');
                str.setCharAt(newp-1, '2');
                str.setCharAt(newp-2, '%');
                count--;
            } else {
                str.setCharAt(newp, tmp);
            }
        }
        return str.toString();
    }

    @Test
    public void testreplace(){
        Assert.assertEquals("We%20are%20happy.", replaceSpace("We are happy."));
        Assert.assertEquals("We%20%20are%20%20happy.", replaceSpace("We  are  happy."));
        Assert.assertEquals("Wearehappy.", replaceSpace("Wearehappy."));
        Assert.assertEquals(null, replaceSpace(null));
        Assert.assertEquals("", replaceSpace(""));
        Assert.assertEquals("%20", replaceSpace(" "));
        Assert.assertEquals("%20%20%20", replaceSpace("   "));
    }
}
