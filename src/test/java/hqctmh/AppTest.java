package hqctmh;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test(){

        Map<String, String> map = new HashMap<>();
        map.put("test", "test");

        System.out.println("test");
        System.out.println(map);
    }

}
