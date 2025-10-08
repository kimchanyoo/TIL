import java.util.Arrays;

public class ReversalRotation {

    // 배열의 특정 구간을 뒤집는 함수 (Swap을 통한 Reverse)
    private static void reverseArr(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // 2. 배열 역전 알고리즘을 이용한 좌측 회전 함수
    private static void rotateLeft(int[] arr, int d, int n) {
        d = d % n; 
        
        if (d == 0) return; 

        reverseArr(arr, 0, d - 1);
        
        reverseArr(arr, d, n - 1);
        
        reverseArr(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int n = arr.length;
        int d = 2;

        rotateLeft(arr, d, n);

        System.out.print("배열을 왼쪽으로 " + d + "칸 회전한 결과: ");
        System.out.println(Arrays.toString(arr));
        // 출력: [3, 4, 5, 6, 7, 1, 2]
    }
}