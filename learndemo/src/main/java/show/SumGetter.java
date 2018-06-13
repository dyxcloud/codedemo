package show;

public class SumGetter {
    
    final int count = 24*2;
    final int price = 5;

    public double getSum1() { 
        int sum=0;
        for(int i=0 ; i<count;i++) {
            if(sum<100|| sum>=200) {
                sum+=price;
            }else if(sum<150) {
                sum+=(0.75*price);
            }else {
                sum+=(0.5*price);
            }
        }
        return sum;
    }
    
    public double getSum2() {
        return 0.8*price*count;
    }
    
    public double getSum0() {
        return price*count;
    }
    
    
    public static void main(String[] args) {
        SumGetter g = new SumGetter();
        System.out.println(g.getSum1());
        System.out.println(g.getSum2());
        System.out.println(g.getSum0());
    }
}
