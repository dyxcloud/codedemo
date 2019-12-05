package learn.题目;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PrintTable {

    /*将map以如下格式打印
+---------------------+------------------------------------+
| Variable_name       | Value                              |
+---------------------+------------------------------------+
| slow_launch_time    | 2                                  |
| slow_query_log      | OFF                                |
| slow_query_log_file | /opt/mysql/data/localhost-slow.log |
+---------------------+------------------------------------+
     */
    
    
    public void printTable(Map<String, String> map) {
        int longKey = 0;
        int longValue = 0;
        for (Entry<String, String> entry : map.entrySet()) {
            int length = 0;
            length = entry.getKey().length();
            if (length > longKey) longKey = length;
            length = entry.getValue().length();
            if (length > longValue) longValue = length;
        }

        String len = "+";
        for (int i = 0; i < longKey + 2; i++) len += "-";
        len += "+";
        for (int i = 0; i < longValue + 2; i++) len += "-";
        len += "+";

        System.out.println(len);
        printRow("key", "Value", longKey, longValue);
        System.out.println(len);
        for (Entry<String, String> entry : map.entrySet()) {
            printRow(entry.getKey(), entry.getValue(), longKey, longValue);
        }
        System.out.println(len);
    }
    
    private void printRow(String key, String value, int longKey, int longValue) {
        System.out.print("|");
        printCell(key, longKey);
        System.out.print("|");
        printCell(value, longValue);
        System.out.print("|\r\n");
    }
    
    private void printCell(String str,int length) {
        System.out.print(" " + str);
        int n = length - str.length();
        for (int i = 0; i < n; i++) System.out.print(" ");
        System.out.print(" ");
    }
    
    public static void main(String[] args) {
        PrintTable table = new PrintTable();
        HashMap<String, String> map = new HashMap<String,String>();
        map.put("slow_launch_time", "2");
        map.put("slow_query_log", "OFF");
        map.put("slow_query_log_file", "/opt/mysql/data/localhost-slow.log");
        table.printTable(map);
    }
}
