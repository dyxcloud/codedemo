package tooltest.apitest;

import org.apache.log4j.PropertyConfigurator;

import java.util.Properties;

public class Log4jDemo {

    
    public static void testConfig() {
        Properties pro=new Properties();
        pro.put("log4j.rootLogger", "info,A");
        pro.put("log4j.appender.A", "org.apache.log4j.DailyRollingFileAppender");
        pro.put("log4j.appender.A.File", "D:/logs/sys.log");
        pro.put("log4j.appender.A.DatePattern", "'.'yyyy-MM-dd-HH");
        pro.put("log4j.appender.A.layout", "org.apache.log4j.PatternLayout");
        pro.put("log4j.appender.A.layout.ConversionPattern", "2333   %-d{yyyy-MM-dd HH:mm:ss} [%c]-[%p] %m -(:%L)%n");
        
        PropertyConfigurator.configure(pro);
      }
    
    public static void main(String[] args) {
        
    }
}
