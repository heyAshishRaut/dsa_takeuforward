import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void removeDuplicatesFromSortedArray(int []A) {
        int idx = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[idx] != A[i]) {
                A[++idx] = A[i];
            }
        }
        for(int i = idx + 1; i < A.length; i++) {
            A[i] = Integer.MAX_VALUE;
        }
    }

    public static void leftRotateByK(int []A, int k) {
        int []temp = new int[k];

        for(int i = 0; i < temp.length; i++) {
            temp[i] = A[i];
        }

        for(int i = 0; i < A.length - k; i++) {
            A[i] = A[i + k];
        }

        for(int i = 0; i < temp.length; i++) {
            A[A.length - k + i] = temp[i];
        }

        System.out.println(Arrays.toString(A));
    }

    public static void longestSubArrayPositive(int []A, int val) {
        int max = 0;

        for(int i = 0; i < A.length; i++) {
            int count = 0, sum = 0;
            for(int j = i; j < A.length; j++) {
                sum = sum + A[j];
                count++;

                if(sum == val) {
                    max = Math.max(count, max);
                    break;
                }
                if(sum > val) {
                    break;
                }
            }
        }

        System.out.println(max);
    }

    public static void longestSubArray(int []A, int val) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int sum = 0, res = -1;
        
        for(int i = 0; i < A.length; i++) {
            sum = sum + A[i];

            if(sum == val) {
                res = i + 1;
            }

            else if(h.containsKey(sum - val)) {
                res = Math.max(res, i - h.get(sum - val));
            }

            if(!h.containsKey(sum)) {
                h.put(sum, i);
            }
        }
        System.out.println(res);
    }

    public static void nextPermutation(int []A) {
        int pivot = -1;
        for(int i = A.length - 1; i >= 0; i--) {
            if(A[i - 1] < A[i]) {
                pivot = i - 1;
                break;
            }
        }

        if(pivot == -1) {
            reverse(A);
            return;
        }

        for(int i = A.length - 1; i > pivot; i--) {
            if(A[i] > A[pivot]) {
                int swap = A[i];
                A[i] = A[pivot];
                A[pivot] = swap;
                break;
            }
        }

        int i = pivot + 1, j = A.length - 1;
        while(i <= j) {
            int swap = A[i];
            A[i] = A[j];
            A[j] = swap;
            i++; j--;
        }

        System.out.println(Arrays.toString(A));
    }

    public static void reverse(int []A) {
        for(int i = 0; i < A.length / 2 ; i++) {
            int swap = A[i];
            A[i] = A[A.length - 1 - i];
            A[A.length - 1 - i] = swap;
        }
    }

    public static void makeMatrixZero(int [][]A) {
        boolean []row = new boolean[A.length];
        boolean []col = new boolean[A[0].length];

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Marking Row Zero
        for(int i = 0; i < A.length; i++) {
            if(row[i]) {
                for(int j = 0; j < A[0].length; j++) {
                    A[i][j] = 0;
                }
            }
        }

        // Marking Column Zero
        for(int i = 0; i < A[0].length; i++) {
            if(col[i]) {
                for(int j = 0; j <A.length; j++) {
                    A[j][i] = 0;
                }
            }
        }

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println( );
        }
    }

    public static void longestConsecutiveSubsequence(int []nums) {
        ArrayList<Integer> a = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            a.add(nums[i]);
        }
        int count = 0, max = 0;

        for(int i = 0; i < a.size(); i++) {
            if(max > nums.length / 2) {
                break;
            }
            int val = a.get(i);

            while(true) {
                if(!a.contains(val)) {
                    max = Math.max(max, count);
                    count = 0;
                    break;
                }
                count++;
                val++;
            }
        }
        System.out.println(max);
    }

    public static void countSubArrayWithSumK(int []A, int k) {
        for(int i = 1; i < A.length; i++) {
            A[i] = A[i] + A[i - 1];
        }
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(0, 1);
        int count = 0;

        for(int i = 0; i < A.length; i++) {
            if(h.containsKey(A[i] - k)) {
                count = count + h.get(A[i] - k);
            }

            if(h.containsKey(A[i])) {
                h.put(A[i], h.get(A[i]) + 1);
            }
            else {
                h.put(A[i], 1);
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int []A = {100, 200, 1, 3, 2};
        int [][]B = {
                {1, 2, 0},
                {4, 5, 6},
                {7, 8, 9}
        };

//        removeDuplicatesFromSortedArray(A);
//        leftRotateByK(A, 2);
//        longestSubArrayPositive(A, 6);

        longestConsecutiveSubsequence(A);

//        makeMatrixZero(B);
    }
}