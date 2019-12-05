package learn.进制;

import java.util.Arrays;  

/** 
 * 二进制和数字之间相互转换类 
 * <pre> 
 * email: yangzhengzheng1985@163.com 
 * time: 2011/8/18 8:30 
 * </pre> 
 * @author 杨争争 
 * 
 */  
public class BinaryCharArrayNumberTransfer {  
    /** 
     * 转换整型为二进制char数组 
     * @param number    给定整数 
     * @param dimensionOfCharArray  二进制数组的位数 
     * @return  number的二进制组成的char数组 
     */  
    public static char[] transferNumber2CharArray(int number,  
            int dimensionOfCharArray) {  
        char[] src = Integer.toBinaryString(number).toCharArray();  
        char[] dest = new char[dimensionOfCharArray];  
        System.arraycopy(src, 0, dest, dimensionOfCharArray - src.length,  
                src.length);  
        for (int i = 0; i < 32 - src.length; i++)  
            dest[i] = '0';  
        return dest;  
    }  
  
    /** 
     * 二进制char数组转换为整数 
     * @param ch    二进制数组 
     * @return  二进制表示的整数 
     */  
    public static int transferCharArray2Number(char[] ch) {  
        if (ch.length != 32)  
            throw new RuntimeException("数组大小必须为32位");  
  
        String s = null;  
        // 正数  
        if (ch[0] == '0') {  
            s = new String(ch);  
            return Integer.valueOf(s, 2);  
        } else {  
            for (int i = 0; i < 32; i++) {  
                if (ch[i] == '0')  
                    ch[i] = '1';  
                else  
                    ch[i] = '0';  
            }  
            s = "-" + new String(ch);  
            // 结果修正  
            return Integer.valueOf(s, 2) - 1;  
        }  
          
    }  
  
    // for test  
    public static void main(String[] args) {  
        for (int i = -10; i <= 10; i++) {  
            char[] ch = BinaryCharArrayNumberTransfer.transferNumber2CharArray(  
                    i, 32);  
            System.out.println("十进制转换二进制: " + i + "-->" + Arrays.toString(ch));  
            int num = BinaryCharArrayNumberTransfer  
                    .transferCharArray2Number(ch);  
            System.out.println("二进制转换十进制: " + num);  
            System.out.println("-----------");  
        }  
    }  
}  