package Jmockit;

import org.junit.jupiter.api.Assertions;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals("hello Jmockit",helloJmockit.sayHello());
    }
}
