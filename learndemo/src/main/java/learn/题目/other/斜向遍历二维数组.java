package learn.题目.other;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class 斜向遍历二维数组 {

    @Test
    public void te(){
        //1 2 4 3 5 7 6 8 10 9 11 12
        int[][] arr = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        int x=0;
        while(true){
            int y=0;
            int tmpX = x;
            while(tmpX>=0){
                if(tmpX<arr[y].length){
                    System.out.println(arr[y][tmpX]);
                }
                tmpX--;
                y++;
            }
            if(y>=arr.length && tmpX>=arr[0].length){
                break;
            }
            x++;
        }
    }
}
