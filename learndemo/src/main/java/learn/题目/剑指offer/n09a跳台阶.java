package learn.题目.剑指offer;

/**
 * @author DongYunxiang
 * @create 2019-12-11
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n09a跳台阶 {

    public int JumpFloor(int target) {
        if(target<=2) return target;
        int a=1,b=2;
        for(int i=3;i<=target;i++){
            int tmp = a+b;
            a = b;
            b = tmp;
        }
        return b;
    }


}
