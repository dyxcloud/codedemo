package tooltest.apitest;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.jupiter.api.Test;

public class CaffeineDemo {


    @Test
    public void testfunc(){
        Cache<String, Object> cache1 = Caffeine.newBuilder().build();
        cache1.put("name","caffine");
        Cache<String, Object> cache2 = Caffeine.newBuilder().build();
        System.out.println(cache1.getIfPresent("name"));
        System.out.println(cache2.getIfPresent("name"));
    }

}
