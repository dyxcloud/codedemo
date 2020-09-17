import org.junit.Test;

import java.io.Serializable;
import java.util.*;

public class ApiTest implements Serializable {


    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void test1() {
        int start = 1990;
        int end = 2020;
        String keyname = "year";
        List<Map<String, Object>> datas = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put(keyname, "2000");
        datas.add(map);
        map = new HashMap<>();
        map.put(keyname, "2018");
        datas.add(map);

        Map[] maps = new Map[end - start + 1];
        for (Map<String, Object> m : datas) {
            int year = Integer.parseInt(m.get(keyname).toString());
            maps[year - start] = m;
        }

        for (int year = start; year <= end; year++) {
            if (maps[year - start] == null) {
                Map<String, Object> mm = new HashMap<>();
                mm.put(keyname, String.valueOf(year));
                maps[year - start] = mm;
            }
        }

        List<Map<String, Object>> maps2 = Arrays.asList(maps);
        System.out.println(maps2.size());
        maps2.forEach(System.out::println);
    }


}