package mytool;

import learn.题目.other.中缀表达式求值;
import org.junit.jupiter.api.Test;

/**
 * 全面屏尺寸换算为16:9比例同等宽度屏幕尺寸
 * @author DongYunxiang
 * @create 2018-08-30
 **/
public class ScreenWidth {

    class Rectangle{
        double width;
        double high;
        double l;

        String ratio;
        double r;
        double rl;

        public void setRatio(String ratio) {
            this.ratio = ratio;
            r = 中缀表达式求值.get(ratio);
            //(ratio^2 + 1)^(1/2)
            rl = Math.sqrt(r*r+1);
        }

        public double getWidth() {
            //rl:rw = size:w
            return r*l/rl;
        }

        public double getHigh() {
            //rl:rh = size:h
            return l/rl;
        }

        public double getL() {
            if(width==0) //rl:rh=l:h
                return rl*high;
            if(high==0) //rl:rw=l:w
                return rl*width/r;
            else//ratio==0
                return Math.sqrt(width*width+high*high);
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "width=" + width +
                    ", high=" + high +
                    ", l=" + l +
                    '}';
        }
    }

    /**
     * 获得普通屏幕等效尺寸
     * @param srcRatio 全面屏的比例数字,如: 18:9比例, 输入"18"
     * @param srcSize 全面屏的尺寸
     * @return
     */
    private double get169(String srcRatio, double srcSize){
        Rectangle src = new Rectangle();
        src.l = srcSize;
        src.setRatio(srcRatio);

        Rectangle desc = new Rectangle();
        desc.high = src.getHigh();
        desc.setRatio("16/9");
        return desc.getL();
    }

    @Test
    public void testGetter(){
        System.out.println("小米8: "+ get169("18.7/9",6.21));
        System.out.println("Mix2s: "+ get169("18/9",5.99));
    }

    public void showDetail(String ratio, double size){
        showDetail(ratio,size,true);
    }

    public void showDetail(String ratio, double size0, boolean isInch){
        double size = size0;
        if(isInch){
            size = size0*2.54*10;
        }
        Rectangle rectangle = new Rectangle();
        rectangle.l=size;
        rectangle.setRatio(ratio);
        double w = rectangle.getWidth();
        double h = rectangle.getHigh();
        System.out.printf("ratio[%5s]\t l[%4s]\t width[%s]\t high[%s]\n",ratio,size0,w,h);
    }

    @Test
    public void testShowDetail() {
        showDetail("16/9",5.5);
        showDetail("16/10",8);
        showDetail("16/10",10.1);
        showDetail("16/9",15.6);
    }
}
