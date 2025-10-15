import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        System.out.println("--- 1. 데이터 추가 ---");
        hashMap.put("test1", 1);
        hashMap.put("test2", 2);
        hashMap.put("test3", null);
        System.out.println("현재 HashMap: " + hashMap);

        /*
        --- 1. 데이터 추가 ---
        현재 HashMap: {test1=1, test2=2, test3=null}
        */

        System.out.println("\n--- 2. 특정 키 값 조회 ---");
        Integer value1 = hashMap.get("test1");
        Integer value2 = hashMap.get("test2");
        Integer value3 = hashMap.get("test3");
        System.out.println("test1 : " + value1 + "  test2 : " + value2 + " test3 : " + value3);

        /*
        --- 2. 특정 키 값 조회 ---
        est1 : 1  test2 : 2 test3 : null
        */

        System.out.println("\n--- 3. 요소 개수 조회 ---");
        System.out.println("size :: " + hashMap.size());

        /*
        --- 3. 요소 개수 조회 ---
        size :: 3
        */

        System.out.println("\n--- 4. 전체 요소 순회 조회 ---");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        /*
        --- 4. 전체 요소 순회 조회 ---
        Key: test1, Value: 1
        Key: test2, Value: 2
        Key: test3, Value: null
        */

        System.out.println("\n--- 5. Key 존재 여부 조회 ---");
        if (hashMap.containsKey("test1")) {
            System.out.println("test1 exists.");
        }

        /*
        --- 5. Key 존재 여부 조회 ---
        test1 exists.
        */

        System.out.println("\n--- 6. Value 존재 여부 조회 ---");
        if (hashMap.containsValue(100)) {
            System.out.println("Value 100 exists.");
        } else {
            System.out.println("Value 100 not found.");
        }

        /*
        --- 6. Value 존재 여부 조회 ---
        Value 100 not found.
        */

        System.out.println("\n--- 7. 값 수정 (Put) ---");
        hashMap.put("test1", 100);
        hashMap.put("test2", 101);
        hashMap.put("test3", 102);
        System.out.println("test1 : " + hashMap.get("test1") + "  test2 : " + hashMap.get("test2") + " test3 : " + hashMap.get("test3"));
        System.out.println("수정 후 HashMap: " + hashMap);

        /*
        --- 7. 값 수정 (Put) ---
        test1 : 100  test2 : 101 test3 : 102
        수정 후 HashMap: {test1=100, test2=101, test3=102}

        */

        System.out.println("\n--- 8. 특정 요소 삭제 (Remove) ---");
        hashMap.remove("test1");
        hashMap.remove("test2");
        hashMap.remove("test3");
        System.out.println("test1 : " + hashMap.get("test1") + "  test2 : " + hashMap.get("test2") + " test3 : " + hashMap.get("test3"));
        System.out.println("삭제 후 size :: " + hashMap.size());

        /*
        --- 8. 특정 요소 삭제 (Remove) ---
        test1 : null  test2 : null test3 : null
        삭제 후 size :: 0
        */

        System.out.println("\n--- 9. 전체 요소 삭제 (Clear) ---");
        hashMap.clear();
        System.out.println("test1 : " + hashMap.get("test1") + "  test2 : " + hashMap.get("test2") + " test3 : " + hashMap.get("test3"));
        System.out.println("Clear 후 size :: " + hashMap.size());

        /*
        --- 9. 전체 요소 삭제 (Clear) ---
        test1 : null  test2 : null test3 : null
        Clear 후 size :: 0
        */
    }
}