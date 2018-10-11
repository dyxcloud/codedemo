package show;

/**
 * @author DongYunxiang
 * @create 2018-08-30
 **/
public class ScreenWidth {

    public static double getter(double srcRatio, double srcWidth){
        System.out.print(srcRatio+":9");
        return (srcWidth*Math.sqrt(9*9+16*16))/(Math.sqrt(9*9+srcRatio*srcRatio));
    }

    public static void main(String[] args) {
        System.out.println("小米8: "+getter(18.7,6.21));
        System.out.println("Mix2s: "+getter(18,5.99));
    }
}
