package mytool;

/**
 * 全面屏尺寸换算为16:9比例同等宽度屏幕尺寸
 * @author DongYunxiang
 * @create 2018-08-30
 **/
public class ScreenWidth {

    /**
     * 获得普通屏幕等效尺寸
     * @param srcRatio 全面屏的比例数字,如: 18:9比例, 输入"18"
     * @param srcWidth 全面屏的尺寸
     * @return
     */
    private static double getter(double srcRatio, double srcWidth){
        System.out.print(srcRatio+":9");
        return (srcWidth*Math.sqrt(9*9+16*16))/(Math.sqrt(9*9+srcRatio*srcRatio));
    }

    public static void main(String[] args) {
        System.out.println("小米8: "+getter(18.7,6.21));
        System.out.println("Mix2s: "+getter(18,5.99));
    }
}
