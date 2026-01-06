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

    public static void majorityElement(int []A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < A.length; i++) {
            if(map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            }
            else {
                map.put(A[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            if(e.getValue() > A.length / 2) {
                System.out.println(e.getKey());
            }
        }
    }

    public static void kadaneAlgo(int []A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < A.length; i++) {
            sum = sum + A[i];

            if(sum > max) {
                max = sum;
            }

            if(sum < 0) {
                sum = 0;
            }
        }

        System.out.println(max);
    }

    public static void buyAndSellStock(int []A) {
        int buy = A[0], maxProfit = 0;

        for(int i = 1; i < A.length; i++) {
            if(A[i] > buy) {
                maxProfit = Math.max(maxProfit, A[i] - buy);
            }
            buy = Math.min(buy, A[i]);
        }

        System.out.println(maxProfit);
    }

    public static void rearrangeElements(int []A) {
        int []B = new int[A.length];
        int pos = 0, neg = 1;

        for(int i = 0; i < A.length; i++) {
            if(A[i] > 0) {
                B[pos] = A[i];
                pos = pos + 2;
            }
            else {
                B[neg] = A[i];
                neg = neg + 2;
            }
        }

        for(int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
        System.out.println( );
    }

    public static void nextPermutation(int []A) {
        int pivot = -1;
        for(int i = A.length - 2; i >= 0; i--) {
            if(A[i] < A[i + 1]) {
                pivot = i;
                break;
            }
        }

        if(pivot == -1) {
            reverse(A);
            return;
        }

        for(int i = A.length - 1; i > pivot; i--) {
            if(A[i] > A[pivot]) {
                int swap = A[pivot];
                A[pivot] = A[i];
                A[i] = swap;
                break;
            }
        }

        int i = pivot + 1, j = A.length - 1;

        while(i <= j) {
            int swap = A[i];
            A[i] = A[j];
            A[j] = swap;
            i++;
            j--;
        }

        for(int k = 0; k < A.length; k++) {
            System.out.print(A[k] + " ");
        }
        System.out.println( );
    }

    public static void reverse(int []A) {
        for(int i = 0; i < A.length / 2; i++) {
            int swap = A[i];
            A[i] = A[A.length - 1 - i];
            A[A.length - 1 - i] = swap;
        }
    }

    public static void leadersInArray(int []A) {
        int max = A[A.length - 1];
        System.out.print(max + " ");

        for(int i = A.length - 2; i >= 0; i--) {
            if(A[i] > max) {
                System.out.print(A[i] + " ");
                max = A[i];
            }
        }
        System.out.println( );
    }

    public static void longestConsecutiveSequence(int []A) {
        ArrayList<Integer> a = new ArrayList<>();

        for(int i = 0; i < A.length; i++) {
            a.add(A[i]);
        }

        int count = 0, max = 0;

        for(int i = 0; i < a.size(); i++) {
            if(max > A.length / 2) {
                break;
            }

            int val = a.get(i);
            while(true) {
                if(!a.contains(val)) {
                    max = Math.max(max, count);
                    count = 0;
                    break;
                }
                val++;
                count++;
            }
        }

        System.out.println(max);
    }

    public static void longestConsecutiveSequenceOptimised(int []A) {
        Arrays.sort(A);
        int count = 1, max = 1, lastElement = A[0];

        for(int i = 1; i < A.length; i++) {
            if(A[i] == lastElement + 1) {
                count++;
                lastElement = A[i];
            }
            else if(A[i] == lastElement) {
                continue;
            }
            else {
                max = Math.max(max, count);
                count = 1;

                lastElement = A[i];
            }
        }
        max = Math.max(max, count);
        System.out.println(max);
    }

    public static void longestConsecutiveSequenceOptimised2(int []A) {
        HashSet<Integer> h = new HashSet<>();
        int longest = 1;

        for(int i = 0; i < A.length; i++) {
            h.add(A[i]);
        }

        for(int tr: h) {
            if(!h.contains(tr - 1)) {
                int count = 1;
                int val = tr;
                while(h.contains(val + 1)) {
                    count++;
                    val++;
                }
                longest = Math.max(longest, count);
            }
        }
        System.out.println(longest);
    }

    public static void setMatrixToZero(int [][]A) {
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

        for(int i = 0; i < row.length; i++) {
            if(row[i]) {
                for(int j = 0; j < A[0].length; j++) {
                    A[j][i] = 0;
                }
            }
        }

        for(int i = 0; i < col.length; i++) {
            if(col[i]) {
                for(int j = 0; j < A.length; j++) {
                    A[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + "  ");
            }
            System.out.println( );
        }
    }

    public static void rotateBy90(int [][]A) {
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(i < j) {
                    int swap = A[i][j];
                    A[i][j] = A[j][i];
                    A[j][i] = swap;
                }
            }
        }

        for(int i = 0; i < A.length; i++) {
            int left = 0, right = A[0].length - 1;

            while(left < right) {
                int swap = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = swap;

                left++;
                right--;
            }
        }

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + "  ");
            }
            System.out.println( );
        }
    }

    public static void printInSpiralOrder(int [][]A) {
        int top = 0, left = 0, bottom = A.length - 1, right = A.length - 1;

        while(top <= bottom && left <= right) {
            // Top
            for(int i = left; i <= right; i++) {
                System.out.print(A[top][i] + "  ");
            }
            top++;

            // Right
            for(int i = top; i <= bottom; i++) {
                System.out.print(A[i][right] + "  ");
            }
            right--;

            // Bottom
            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    System.out.print(A[bottom][i] + "  ");
                }
                bottom--;
            }

            // Left
            if(left <= right) {
                for(int i = bottom; i >= top; i-- ) {
                    System.out.print(A[i][left] + "  ");
                }
                left++;
            }
        }
    }

    public static int subArraySum(int[] nums, int k) {
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum = sum + nums[i];
            nums[i] = sum;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i] - k)) {
                count = count + map.get(nums[i] - k);
            }
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int []A = {102, 1, 2, 100, 101, 3, 4};
        int [][]C = {
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 0, 0}
        };
        System.out.println(C[0].length);
        System.out.println(C.length);

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

//        majorityElement(A);
//        T.C. - O(2N)
//        S.C. - O(N)

//        kadaneAlgo(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        buyAndSellStock(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        rearrangeElements(A);
//        T.C. - O(N + N)
//        S.C. - O(N)

//        nextPermutation(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        leadersInArray(A);
//        T.C. - O(N)
//        S.C. - O(1)

//        longestConsecutiveSequenceOptimised(A);
//        T.C. - O(NlogN + N)
//        S.C. - O(1)

//        rotateBy90(C);

//        printInSpiralOrder(C);

//        setMatrixToZero(C);
    }
}