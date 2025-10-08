import java.util.Arrays;

public class MaxRotationSum {

    /**
     * 배열을 한 칸씩 회전했을 때, 각 인덱스(i)와 요소(arr[i])를 곱한 값의 합이 가장 큰 값을 찾음
     * 이 문제는 O(n^2)로 풀 수 있지만, 회전 간의 수학적 관계를 이용해 O(n)으로 해결
     *
     */
    private static int maxVal(int[] arr, int n) {
        int arrSum = 0;
        int curSum = 0;

        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
            curSum += (i * arr[i]);
        }

        int maxSum = curSum;

        // 2. 회전을 이용한 최대 합 탐색 (O(n) 시간 복잡도)
        for (int j = 1; j < n; j++) {
            // 수학적 관계를 이용한 다음 회전 합 (R_j) 계산
            // R_j = R_(j-1) + S_arr - n * arr[n-j]
            // 여기서 arr[n-j]는 이전 회전(j-1)에서 인덱스 0으로 이동했던 값

            // arr[n-j]는 원래 배열 기준, '현재 회전(j)'에서 맨 앞으로 이동하는 요소
            // 예를 들어, n=4, j=1 일 때 arr[3] (원래 배열의 마지막 요소)이 다음 회전에서 0번 인덱스가 됨
            curSum = curSum + arrSum - n * arr[n - j];

            // 최대 합 갱신
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 20, 2, 10};
        int n = arr.length;

        int result = maxVal(arr, n);
        System.out.println("i * arr[i]의 최대 합: " + result); 
        // 예상 출력: 52