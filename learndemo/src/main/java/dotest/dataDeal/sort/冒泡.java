package dotest.dataDeal.sort;

/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class 冒泡 {
    public static void main(String[] args) {
        int a[]={15,7,354,9,52,4,61,2,14,75,4};
        int temp=0;
        for(int i=a.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        for (int i : a) {
            System.out.print(i+" ");
        }
    }

}
