package learn.题目.other;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 动态获取中位数
 * @author DongYunxiang
 * @create 2019-05-30
 **/
public class MidNumberGetter {

    /**大于中位数*/
    PriorityQueue<Long> highHeap = new PriorityQueue<>();
    /**小于中位数*/
    PriorityQueue<Long> lowHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public void add(Long l){
        if(lowHeap.isEmpty()){
            lowHeap.offer(l);
        }else if (highHeap.isEmpty()){
            highHeap.offer(l);
        }else{
            if (l.compareTo(highHeap.peek())>0){//大于大端
                highHeap.offer(l);
            }else {
                lowHeap.offer(l);
            }
        }
        //reset
        while(highHeap.size()>lowHeap.size()){
            lowHeap.offer(highHeap.poll());
        }
        while(lowHeap.size()-highHeap.size()>1){
            highHeap.offer(lowHeap.poll());
        }
    }

    public Double getMid(){
        if (lowHeap.isEmpty() && highHeap.isEmpty())
            return null;
        if (lowHeap.isEmpty())
            return highHeap.peek().doubleValue();
        if (highHeap.isEmpty())
            return lowHeap.peek().doubleValue();
        if(lowHeap.size()==highHeap.size()){
            return (lowHeap.peek().doubleValue()+highHeap.peek())/2;
        }
        return lowHeap.peek().doubleValue();
    }

    @Test
    public void testGet(){
        MidNumberGetter getter = new MidNumberGetter();
        getter.add(1L);
        System.out.println(getter.getMid());
        getter.add(2L);
        System.out.println(getter.getMid());
        getter.add(3L);
        System.out.println(getter.getMid());
        getter.add(4L);
        System.out.println(getter.getMid());
        getter.add(5L);
        System.out.println(getter.getMid());
        getter.add(6L);
        System.out.println(getter.getMid());
    }

}
