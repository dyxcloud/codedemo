package dotest.print;

public class MySubWayPrice {

	double sum=0;
	int count=0;
	double price=5;
	
	public double getEndPrice() {
		if(sum>=400)
			return price;
		if(sum>=150)
			return price/2;
		if(sum>=100)
			return price*0.8;
		return price;
	}
	
	public double getSum(int day) {
		count=day*2;
		for(int i=0;i<count;i++) {
			sum+=getEndPrice();
		}
		return sum;
	}
	
	public static void main(String[] args) {
		MySubWayPrice price2 = new MySubWayPrice();
		System.out.println(price2.getSum(25));
	}
}
