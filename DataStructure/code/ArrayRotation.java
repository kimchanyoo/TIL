import java.util.Arrays;

public class ArrayRotation {

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }


    private static void leftRotate(int[] arr, int d, int n) {
        d = d % n; 
        
        for (int i = 0; i < gcd(d, n); i++) {
            int temp = arr[i];
            int j = i;

            while (true) {
                int k = j + d;

                if (k >= n) {
                    k = k - n; 
                }

                if (k == i) {
                    break;
                }

                arr[j] = arr[k];
                
                j = k;
            }
            arr[j] = temp;
        }
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int n = arr.length;
        int d = 2;

        leftRotate(arr, d, n);


        System.out.print("배열을 왼쪽으로 " + d + "칸 회전한 결과: ");
        printArray(arr); 
    }
}