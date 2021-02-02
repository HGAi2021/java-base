package base;

import org.junit.Test;

public class RunTest {
    @Test
    public void test1(){
        VarietyParameter v = new VarietyParameter();
        v.sayHi();
        v.sayHi("1","2","3");
        v.sayHi(1,"4","5","6");
    }

}
