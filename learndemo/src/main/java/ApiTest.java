import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ApiTest  implements Serializable{


    public static ApiTest instance = new ApiTest();

    public static void main(String[] args) {

        // instance.receiveManual("queuename",instance::doCrawler);

        Random random = new Random();
        IntStream.rangeClosed(0,20).forEach(i-> System.out.println(Math.round(random.nextGaussian())));


    }
    public static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if(hex.length() < 2){
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    public void receiveManual(String queueName, Consumer<Object> crawlerConsumer){
        //获取消息
        System.out.println(queueName);
        String text = null;
        if(isConuinue(text,queueName)){
            crawlerConsumer.accept(text);
        }
        //ack
        //关闭连接
    }

    public boolean isConuinue(Object o, String queueName){
        //如果不需要拦截,直接true
        List<String> targetQueues = Arrays.asList("crawler");
        boolean needCheck = targetQueues.contains(queueName);
        if(!needCheck){
            return true;
        }
        //判断o任务状态
        System.out.println(o);
        if(true){
            return true;
        }else {
            //存档消息
            System.out.println(queueName);
            return false;
        }
    }

    public void doCrawler(Object o){
        System.out.println(o);
    }


}