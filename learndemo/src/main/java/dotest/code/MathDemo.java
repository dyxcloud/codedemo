package dotest.code;

public class MathDemo {


    /**
     *
     * @author DongYunxiang
     * @date 18.7.19
     * @param a
     * @param b
     * @return
     * @throws Exception
     */
    public int[] add(int[] a, int[] b) throws Exception{
        // 没啥用啊, 还是要调用底层加法
        int length;
        int[] result;
        if (a.length > b.length) {
            length = b.length;
            result = new int[a.length + 1];
        }else{
            length = a.length;
            result = new int[b.length + 1];
        }

        int inc = 0;
        for (int i = length; i >= 0; i--) {
            int sum = a[i] + b[i];

        }
        return null;
    }
}
//999+999 = 1998