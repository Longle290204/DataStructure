package HashTable;

import java.util.Map;
import java.util.HashMap;

public class HashMapJava {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 2};
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i : arr) {
            if (!myMap.containsKey(i)) {
                myMap.put(i, 1);
            } else {
                int updateValue = myMap.get(i);
                updateValue++;
                myMap.put(i, updateValue);
            }
        }

        for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + " xuất hiện " + entry.getValue());
        }
    }
}
