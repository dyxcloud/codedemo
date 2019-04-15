package dotest.dataDeal.进制;

import java.util.Scanner;

//输入负数parseInt方法会报错!
public class RadixMain {

	public static void main(String[] args) {
		
//		String bin = "11111111111111111111111111111101";
//		StringBuffer sb = new StringBuffer(bin);
//		for(int i=0;i<32;i++){
//			if(bin.charAt(i) =='0'){
//				sb.setCharAt(i, '1');
//			}else{
//				sb.setCharAt(i, '0');
//			}
//		}
//		bin = "-" +sb.toString();
//		System.out.println(Integer.parseInt(bin, 2)-1);
		
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入要转换的十进制数:");
		int n=sc.nextInt();
		//十进制转换为其他进制
		String bin=Integer.toBinaryString(n);
		String oct=Integer.toOctalString(n);
		String hex=Integer.toHexString(n);
		System.out.println("二进制:"+bin);
		System.out.println("八进制:"+oct);
		System.out.println("十六进制:"+hex);
		
		//其他进制转换为十进制
		if(n>=0){
			System.out.println("二进制转为十进制:"+Integer.parseInt(bin, 2));
			System.out.println("八进制转为十进制:"+Integer.parseInt(oct, 8));
			System.out.println("十六进制转为十进制:"+Integer.parseInt(hex, 16));
		}else{
			StringBuffer sb = new StringBuffer(bin);
			for(int i=0;i<32;i++){
				if(bin.charAt(i) =='0'){
					sb.setCharAt(i, '1');
				}else{
					sb.setCharAt(i, '0');
				}
			}
			bin = "-" +sb.toString();
			System.out.print("二进制转为十进制:");
			System.out.println(Integer.parseInt(bin, 2)-1);
		}
		
	}

}
