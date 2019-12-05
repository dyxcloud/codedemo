package test.java.Jmockit;

import junit.framework.TestCase;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.Test;

public class JmockitTest {

    @Mocked
    HelloJMockit helloJmockit;
    
    @Test
    public void doTest() {
        new Expectations() {
            {
                helloJmockit.sayHello();
                result = "hello Jmockit";
            }
        };
        TestCase.assertEquals("hello Jmockit",helloJmockit.sayHello());
    }
}
