import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableExample {

    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        System.out.println("--- 1. 데이터 추가 ---");
        hashtable.put("test1", 1);
        hashtable.put("test2", 2);
        hashtable.put("test3", 3);

        // Hashtable 은 null 키/값을 허용하지 않음 → 예외 발생 시 잡아서 보여줌
        try {
            hashtable.put("test4", null); // Value 가 null → NullPointerException
        } catch (NullPointerException e) {
            System.out.println("예외: Hashtable 은 null 값(value)을 허용하지 않습니다.");
        }
        try {
            hashtable.put(null, 4);       // Key 가 null → NullPointerException
        } catch (NullPointerException e) {
            System.out.println("예외: Hashtable 은 null 키(key)를 허용하지 않습니다.");
        }
        System.out.println("현재 Hashtable: " + hashtable + " (순서는 보장되지 않음)");

        /*
        --- 1. 데이터 추가 ---
        예외: Hashtable 은 null 값(value)을 허용하지 않습니다.
        예외: Hashtable 은 null 키(key)를 허용하지 않습니다.
        현재 Hashtable: {test3=3, test2=2, test1=1} (순서는 보장되지 않음)
        */

        System.out.println("\n--- 2. 특정 키 값 조회 ---");
        Integer value1 = hashtable.get("test1");
        Integer value2 = hashtable.get("test2");
        Integer value3 = hashtable.get("test3");
        System.out.println("test1 : " + value1 + "  test2 : " + value2 + "  test3 : " + value3);

        /*
        --- 2. 특정 키 값 조회 ---
        test1 : 1  test2 : 2  test3 : 3
        */

        System.out.println("\n--- 3. 요소 개수 조회 ---");
        System.out.println("size :: " + hashtable.size());

        /*
        --- 3. 요소 개수 조회 ---
        size :: 3
        */

        System.out.println("\n--- 4. 전체 요소 순회 조회 (Enumeration) ---");
        Enumeration<String> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println("Key: " + key + ", Value: " + hashtable.get(key));
        }

        /*
        --- 4. 전체 요소 순회 조회 (Enumeration) ---
        Key: test3, Value: 3
        Key: test2, Value: 2
        Key: test1, Value: 1
        (순서는 보장되지 않음)
        */

        System.out.println("\n--- 5. Key 존재 여부 조회 ---");
        if (hashtable.containsKey("test1")) {
            System.out.println("test1 exists.");
        }

        /*
        --- 5. Key 존재 여부 조회 ---
        test1 exists.
        */

        System.out.println("\n--- 6. Value 존재 여부 조회 ---");
        if (hashtable.containsValue(100)) {
            System.out.println("Value 100 exists.");
        } else {
            System.out.println("Value 100 not found.");
        }

        /*
        --- 6. Value 존재 여부 조회 ---
        Value 100 not found.
        */

        System.out.println("\n--- 7. 값 수정 (Put) ---");
        hashtable.put("test1", 100);
        hashtable.put("test2", 101);
        hashtable.put("test3", 102);
        System.out.println("test1 : " + hashtable.get("test1")
                + "  test2 : " + hashtable.get("test2")
                + "  test3 : " + hashtable.get("test3"));
        System.out.println("수정 후 Hashtable: " + hashtable);

        /*
        --- 7. 값 수정 (Put) ---
        test1 : 100  test2 : 101  test3 : 102
        수정 후 Hashtable: {test3=102, test2=101, test1=100}
        */

        System.out.println("\n--- 8. 특정 요소 삭제 (Remove) ---");
        hashtable.remove("test1");
        hashtable.remove("test2");
        hashtable.remove("test3");
        
        System.out.println("test1 : " + hashtable.get("test1")
                + "  test2 : " + hashtable.get("test2")
                + "  test3 : " + hashtable.get("test3"));
        System.out.println("삭제 후 size :: " + hashtable.size());

        /*
        --- 8. 특정 요소 삭제 (Remove) ---
        test1 : null  test2 : null  test3 : null
        삭제 후 size :: 0
        */

        System.out.println("\n--- 9. 전체 요소 삭제 (Clear) ---");
        hashtable.clear();
        System.out.println("test1 : " + hashtable.get("test1")
                + "  test2 : " + hashtable.get("test2")
                + "  test3 : " + hashtable.get("test3"));
        System.out.println("Clear 후 size :: " + hashtable.size());

        /*
        --- 9. 전체 요소 삭제 (Clear) ---
        test1 : null  test2 : null  test3 : null
        Clear 후 size :: 0
        */
    }
}
