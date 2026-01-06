import java.util.*;

public class Main {
    public static void largestElementInArray(int []A) {
        int ans = -1;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > ans) {
                ans = A[i];
            }
        }
        System.out.println(ans);
    }

    public static void secondLargestElementInArray(int []A) {
        for(int i = 0; i < A.length; i++) {
            for(int j = i + 1; j < A.length; j++) {
                if(A[i] > A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }

        for(int i = A.length - 1 - 1; i >= 0; i--) {
            if(A[i] != A[i + 1]) {
                System.out.println(A[i]);
                break;
            }
        }
    }

    public static boolean arrayIsSorted(int []A) {
        if(A.length == 1) {
            return true;
        }
        else{
            for(int i = 1; i < A.length; i++) {
                if(A[i] < A[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void removeDuplicatesFromSortedArray(int []A) {
        int idx = 0;
        for(int i = 1; i < A.length; i++) {
            if(A[i] != A[idx]) {
                A[++idx] = A[i];
            }
        }
        idx++;
        while(idx < A.length) {
            A[idx++] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static void leftShiftByOne(int []A) {
        int firstElement = A[0];
        for(int i = 1; i < A.length; i++) {
            A[i - 1] = A[i];
        }
        A[A.length - 1] = firstElement;

        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println( );
    }

    public static void leftShiftByK(int []A, int k) {
        k = k % A.length;
        int []temp = new int[k];

        for(int i = 0; i < k; i++) {
            temp[i] = A[i];
        }

        for(int i = k; i < A.length; i++) {
            A[i - k] = A[i];
        }

        int idx = 0;
        for(int i = A.length - k; i < A.length; i++) {
            A[i] = temp[idx++];
        }

        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println( );
    }

    public static void rotateArrayByK(int []A, int k) {
        k = k % A.length;

        reverse(A, 0, A.length - 1);
        reverse(A, 0, k - 1);
        reverse(A, k, A.length - 1);

        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println( );
    }

    public static void reverse(int []A, int start, int end) {
        while(start < end) {
            int swap = A[start];
            A[start] = A[end];
            A[end] = swap;

            start++;
            end--;
        }
    }

    public static void moveZeroesToEnd(int []A) {
        int idx = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] != 0) {
                A[idx++] = A[i];
            }
        }

        for(int i = idx; i < A.length; i++) {
            A[i] = 0;
        }

        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static int linearSearch(int []A, int val) {
        for(int i = 0; i < A.length; i++) {
            if(A[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void unionOfSortedArray01(int []A, int []B) {
        ArrayList a = new ArrayList<Integer>();

        for(int i = 0; i < A.length; i++) {
            a.add(A[i]);
        }
        for(int i = 0; i < B.length; i++) {
            if(!a.contains(B[i])) {
                a.add(B[i]);
            }
        }

        for(int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.println( );
    }

    public static void unionOfSortedArray02(int []A, int []B) {
        ArrayList<Integer> a = new ArrayList<>();
        int size1 = A.length, size2 = B.length, i = 0, j = 0;

        while(i < size1 && j < size2) {
            if(A[i] <= B[j]) {
                if(a.isEmpty() || a.getLast() != A[i]) {
                    a.add(A[i]);
                }
                i++;
            }
            else {
                if(a.isEmpty() || a.getLast() != B[j]) {
                    a.add(B[j]);
                }
                j++;
            }
        }

        while(i < size1) {
            if(a.isEmpty() || a.getLast() != A[i]) {
                a.add(A[i]);
                i++;
            }
        }

        while(j < size2) {
            if(a.isEmpty() || a.getLast() != B[j]) {
                a.add(B[j]);
                j++;
            }
        }

        for(int k = 0; k < a.size(); k++) {
            System.out.print(a.get(k) + " ");
        }
        System.out.println( );
    }

    public static void intersectionOfSortedArray01(int []A, int []B) {
        boolean []isVisited = new boolean[B.length];
        ArrayList<Integer> ar = new ArrayList<>();

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                if(A[i] == B[j] && !isVisited[j]) {
                    ar.add(A[i]);
                    isVisited[j] = true;
                    break;
                }
            }
        }

        for(int i = 0; i < ar.size(); i++) {
            System.out.print(ar.get(i) + " ");
        }
        System.out.println( );
    }

    public static void intersectionOfSortedArray02(int []A, int []B) {
        int i = 0, j = 0, size1 = A.length, size2 = B.length;

        while(i < size1 && j < size2) {
            if(A[i] < B[j]) {
                i++;
            }
            else if(B[j] < A[i]) {
                j++;
            }
            else {
                System.out.print(A[i] + " ");
                i++;
                j++;
            }
        }
        System.out.println( );
    }

    public static void findMissingNumber01(int []A) {
        int calSum = (A[A.length - 1] * (A[A.length - 1] + 1)) / 2;

        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum = sum + A[i];
        }

        int res = calSum - sum;
        System.out.println("Calculated sum -> " + res);
    }

    public static void findMissingNumber02(int []A) {
        int xor1 = 0, xor2 = 0;

        for(int i = 0; i < A.length; i++) {
            xor1 = xor1 ^ A[i];
        }

        for(int i = 1; i <= A.length + 1; i++) {
            xor2 = xor2 ^ i;
        }

        System.out.println(xor1 ^ xor2);
    }

    public static void consecutiveOnes(int []A) {
        int max = 0,count = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[i] == 1) {
                count++;
            }
            else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        // If array consist of all ones
        max = Math.max(max, count);
        System.out.println("Count - " + max);
    }

    // Other number appear twice
    public static void findUnique01(int []A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            if(map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            }
            else {
                map.put(A[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) {
                System.out.println("Unique element - " + entry.getKey());
                break;
            }
        }
    }

    // Other number appear twice
    public static void findUnique02(int []A) {
        int xor = 0;
        for(int i = 0; i < A.length; i++) {
            xor = xor ^ A[i];
        }
        System.out.println("Unique Number - " + xor);
    }

    public static void longestSubArrayPositive(int []A, int val) {
        int max = 0;
        for(int i = 0; i < A.length; i++) {
            int count = 0, sum = 0;
            for(int j = i; j < A.length; j++) {
                sum = sum + A[j];
                count++;

                if(sum == val) {
                    max = Math.max(max, count);
                    break;
                }
                else if(sum > val) {
                    break;
                }
            }
        }
        System.out.println(max);
    }

    public static int longestSubArray(int[] arr, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        int prefSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefSum += arr[i];

            if (prefSum == k) {
                res = i + 1;
            }

            else if (mp.containsKey(prefSum - k)) {
                res = Math.max(res, i - mp.get(prefSum - k));
            }

            if (!mp.containsKey(prefSum)) {
                mp.put(prefSum, i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int []A = {-3, 2, 1}; // vary by problems.
        int []B = {2, 3, 4, 4, 5, 11, 12};

//        largestElementInArray(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        secondLargestElementInArray(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        arrayIsSorted(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        removeDuplicatesFromSortedArray(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        leftShiftByOne(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        leftShiftByK(A, 2);
//        T.C. - O(N + d)
//        S.C. - O(d)

//        rotateArrayByK(A, 3);
//        T.C. - O(N) + O(k) + O(N - k)
//        S.C. - O(1)

//        moveZeroesToEnd(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        unionOfSortedArray01(A, B);
//        T.C. - O(N^2)
//        S.C. - O(N + M)

//        unionOfSortedArray02(A, B);
//        T.C. - O(N + M)
//        S.C. - O(N + M)

//        intersectionOfSortedArray01(A, B);
//        T.C. - O(N * M)
//        S.C. - O(2*N)

//        intersectionOfSortedArray02(A, B);
//        T.C. - O(N + M)
//        S.C. - O(1)

//        findMissingNumber01(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        findMissingNumber02(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        consecutiveOnes(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        findUnique01(A);
//        T.C. - O(N)
//        S.C. - O(N)

//        findUnique02(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        longestSubArrayPositive(A, 6);
//        int ans = longestSubArray(A, 15);
//        System.out.println(ans);
    }
}