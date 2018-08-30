package show;

/**
 * @author DongYunxiang
 * @create 2018-08-30
 **/
public class ScreenWidth {

    public static double getter(double srcRatio, double srcWidth){
        return (srcWidth*Math.sqrt(9*9+16*16))/(Math.sqrt(9*9+srcRatio*srcRatio));
    }

    public static void main(String[] args) {
        System.out.println(getter(18,6));
    }
}
