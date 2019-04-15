package dotest.dataDeal.sort;

/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class 选择排序 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] ars={2,3,5,6,8,5,3,2,5,7,9,5,3,7,6,3,2,1};
        for (int i = 0; i < ars.length-1; i++) {
            int index=i;
            int num=ars[i];
            for (int j = i+1; j < ars.length; j++) {
                if(num>ars[j]){
                    index=j;
                    num=ars[j];
                }
            }
            if(index!=i){
                int temp=ars[i];
                ars[i]=ars[index];
                ars[index]=temp;
            }
        }
        for (int i : ars) {
            System.out.print(i+"\t");
        }
    }
}
