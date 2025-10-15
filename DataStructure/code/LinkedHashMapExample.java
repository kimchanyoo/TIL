import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        System.out.println("--- 1) 기본: 삽입 순서 유지 ---");
        LinkedHashMap<String, Integer> scores = new LinkedHashMap<>();
        scores.put("David", 85);
        scores.put("Jane", 95);
        scores.put("Susan", 84);
        scores.put("Brenda", 92);

        for (Map.Entry<String, Integer> e : scores.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
        // 출력: 삽입한 순서대로
        // David : 85
        // Jane : 95
        // Susan : 84
        // Brenda : 92

        System.out.println("\n--- 2) 접근 순서 유지(accessOrder=true) ---");
        // accessOrder=true 이면 get/put으로 접근한 항목이 '가장 최근'으로 뒤로 밀림
        LinkedHashMap<String, Integer> accessOrdered =
                new LinkedHashMap<>(16, 0.75f, true);
        accessOrdered.put("A", 1);
        accessOrdered.put("B", 2);
        accessOrdered.put("C", 3);
        accessOrdered.put("D", 4);

        // 접근: B → A (접근된 키가 뒤로 이동)
        accessOrdered.get("B");
        accessOrdered.get("A");

        System.out.println(accessOrdered);
        // 출력 예: {C=3, D=4, B=2, A=1}

        System.out.println("\n--- 3) LRU 캐시처럼 사용: 용량 초과 시 가장 오래된 항목 제거 ---");
        // 사이즈가 3을 초과하면 가장 오래된(가장 오래 접근 안 한) 엔트리 제거
        LinkedHashMap<String, Integer> lru =
            new LinkedHashMap<>(16, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                    return size() > 3;
                }
            };

        lru.put("K1", 10); // [K1]
        lru.put("K2", 20); // [K1, K2]
        lru.put("K3", 30); // [K1, K2, K3]
        lru.get("K1");     // 접근: K1이 가장 최근으로 이동 → [K2, K3, K1]
        lru.put("K4", 40); // 용량 3 초과 → 가장 오래된 K2 제거 → [K3, K1, K4]

        System.out.println(lru); // 출력 예: {K3=30, K1=10, K4=40}
    }
}
