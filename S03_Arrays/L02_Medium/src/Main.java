import java.util.*;

public class Main {
    public static void twoSum01(int []A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            if(map.containsKey(target - A[i])) {
                System.out.println("Indexes are - " + i + " " + map.get(target - A[i]));
                break;
            }
            else {
                map.put(A[i], i);
            }
        }
    }

    public static void twoSum02(int []A, int target) {
        int start = 0, end = A.length - 1;
        boolean found = false;

        Arrays.sort(A);

        while(start < end) {
            if(A[start] + A[end] > target) {
                end--;
            }
            else if(A[start] + A[end] < target) {
                start++;
            }
            else {
                found = true;
                System.out.println("Found");
                break;
            }
        }

        if(!found) {
            System.out.println("Not found");
        }
    }

    public static void sortArrayOf0s1sAnd2s(int []A) {
        int index = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                int temp = A[i];
                A[i] = A[index];
                A[index] = temp;
                index++;
            }
        }
        for(int i = index; i < A.length; i++) {
            if(A[i] == 1) {
                int temp = A[i];
                A[i] = A[index];
                A[index] = temp;
                index++;
            }
        }

        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static void dutchNationalFlag(int[] A) {
        int low = 0, mid = 0, high = A.length - 1;

        while (mid <= high) {
            switch (A[mid]) {
                case 0:
                    int temp0 = A[low];
                    A[low] = A[mid];
                    A[mid] = temp0;
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    int temp2 = A[high];
                    A[high] = A[mid];
                    A[mid] = temp2;
                    high--;
                    break;
            }
        }

        for (int x : A) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        int []A = {1, 1, 0, 2, 1, 0, 0, 0, 2, 2};

//        twoSum01(A, 14);
//        T.C. - O(N)
//        S.C. - O(N)

//        twoSum02(A, 14);
//        T.C. - O(NlogN)
//        S.C. - O(logN)

//        sortArrayOf0s1sAnd2s(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        dutchNationalFlag(A);
//        T.C. - O(N)
//        S.C. - O(1)

    }
}