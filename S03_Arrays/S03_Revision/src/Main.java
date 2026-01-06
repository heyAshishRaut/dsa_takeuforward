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

    public static void main(String[] args) {
        int []A = {1, 2, 3, 4, 5, 6, 7};

//        removeDuplicatesFromSortedArray(A);
//        leftRotateByK(A, 2);
        longestSubArrayPositive(A, 6);
    }
}