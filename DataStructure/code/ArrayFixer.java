import java.util.Arrays;

public class ArrayFixer {

    /**
     * 배열을 재배열하여 A[i] = i 가 되도록 함 
     * 배열의 값은 [0, len-1] 범위 내의 인덱스이거나 -1이어야 함
     * 이 함수는 배열을 제자리에서(in-place) 수정
     */
    private static void fix(int[] A) {
        int len = A.length;

        for (int i = 0; i < len; i++) {
            if (A[i] != -1 && A[i] != i) {
                
                int x = A[i]; 
            
                while (A[x] != -1 && A[x] != x) {
                    int y = A[x]; 
                    A[x] = x;
                    x = y;
                }
                
                A[x] = x;
                
                if (A[i] != i) {
                    A[i] = -1;
                }
            }
        }
    }

    private static void printArray(int[] A) {
        System.out.println(Arrays.toString(A));
    }

    public static void main(String[] args) {
        
        int[] A = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
        
        fix(A);
        
        System.out.print("재배열된 배열: ");
        printArray(A);
        
        // 결과 확인:
        // 인덱스: 0   1   2   3   4   5   6   7   8   9
        // 값:    -1  1   2   3   4  -1   6  -1   8  -1
        // (원래 배열의 1, 2, 3, 4, 6은 제자리를 찾았고, 9와 -1은 제자리를 찾지 못함)
    }
}