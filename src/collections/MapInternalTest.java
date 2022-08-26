package collections;

import java.util.HashMap;
import java.util.Map;

public class MapInternalTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.put("Rohit", "XXXXXXXX"));
        System.out.println(map.put("Gupta", "Gupta"));
        System.out.println(map.put("Rohit", "RohitValueNew"));
    }
}
