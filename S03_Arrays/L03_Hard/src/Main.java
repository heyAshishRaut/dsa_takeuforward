import java.util.*;

public class Main {
    // Print Element
    // nCr = n! / (n - r)! * r!
    public static void pascalTriangleType01(int row, int col) {
        row = row - 1;
        col = col - 1;

        int start = 1, ans = 1;
        while(start <= col) {
            ans = ans * row;
            ans = ans / start;

            row--;
            start++;
        }

        System.out.println(ans);
    }

    // Print Particular Row
    public static void pascalTriangleType02(int row) {
        row = row - 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        if(row == 0) {
            System.out.println(list);
            return;
        }

        for(int i = 1; i < row; i++) {
            int start = 1, ans = 1, val = row;
            while(start <= i) {
                ans = ans * val;
                ans = ans / start;

                val--;
                start++;
            }
            list.add(ans);
        }
        list.add(1);

        System.out.println(list);
    }

    public static void pascalTriangleType03(int row) {
        row = row - 1;
        int col = row;

        ArrayList<ArrayList<Integer>> parent = new ArrayList<>();

        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        parent.add(first);

        if(row == 0) {
            System.out.println(parent);
            return;
        }

        // Row
        for(int i = 1; i <= row; i++) {
            // Col
            ArrayList<Integer> child = new ArrayList<>();
            child.add(1);

            for(int j = 1; j < i; j++) {
                int start = 1, ans = 1, val = i;
                while(start <= j) {
                    ans = ans * val;
                    ans = ans / start;

                    start++;
                    val--;
                }
                child.add(ans);
            }

            child.add(1);
            parent.add(child);
        }

        System.out.println(parent);
    }

    // Find the elements that appears more than N/3 times in the array
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int count1 = 0, maj1 = Integer.MIN_VALUE, count2 = 0, maj2 = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(count1 == 0 && nums[i] != maj2) {
                maj1 = nums[i];
                count1++;
            }
            else if(count2 == 0 && nums[i] != maj1) {
                maj2 = nums[i];
                count2++;
            }
            else if(nums[i] == maj1) {
                count1++;
            }
            else if(nums[i] == maj2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        // Why we are running below for loop
        for(int i = 0; i < nums.length; i++) {
            if(maj1 == nums[i]) {
                count1++;
            }
            if(maj2 == nums[i]) {
                count2++;
            }
        }

        int min = (int)(nums.length / 3) + 1;

        if(count1 >= min) {
            ans.add(maj1);
        }
        if(count2 >= min) {
            ans.add(maj2);
        }

        return ans;
    }

    public static void sumOfThreeBrute(int []nums, int target) {
        ArrayList<ArrayList<Integer>> parent = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == target) {
                        ArrayList<Integer> child = new ArrayList<>();
                        child.add(nums[i]);
                        child.add(nums[j]);
                        child.add(nums[k]);

                        parent.add(child);
                    }
                }
            }
        }

        System.out.println(parent);
    }

    public static void sumOfThreeBetter(int []nums, int target) {
        ArrayList<ArrayList<Integer>> parent = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = i + 1; j < nums.length; j++) {
                if(map.containsKey(target - (nums[i] + nums[j]))) {
                    int nums3 = target - (nums[i] + nums[j]);

                    ArrayList<Integer> child = new ArrayList<>();
                    child.add(nums[i]);
                    child.add(nums[j]);
                    child.add(nums3);

                    Collections.sort(child);
                    if(!parent.contains(child)) {
                        parent.add(child);
                    }
                }
                else {
                    map.put(nums[j], 1);
                }
             }
        }
        System.out.println(parent);
    }

    // *****
    public static void sumOfThreeOptimised(int []nums, int target) {
        List<List<Integer>> parent = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum < 0) {
                    j++;
                }
                else if(sum > 0) {
                    k--;
                }
                else {
                    ArrayList<Integer> child = new ArrayList<>();
                    child.add(nums[i]);
                    child.add(nums[j]);
                    child.add(nums[k]);

                    parent.add(child);
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    while(j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        System.out.println(parent);
    }


    public static void sumOfFourOptimised(int []nums, int target) {
        List<List<Integer>> parent = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i + 1; j < nums.length; j++) {
                if(j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = nums.length - 1;

                while(k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if(sum == target) {
                        ArrayList<Integer> child = new ArrayList<>();
                        child.add(nums[i]); child.add(nums[j]); child.add(nums[k]); child.add(nums[l]);
                        parent.add(child);
                        k++;
                        l--;

                        while(k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while(k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                    else if(sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        System.out.println(parent);
    }

    public static void maxSubArrayWithSumZero(int []nums) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if(sum == 0) {
                max = Math.max(max, i + 1);
            }
            else {
                if(map.containsKey(sum)) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(nums[i], i);
                }
            }
        }

        System.out.println(max);
    }

    public static void countSubArrayWithXORasK01(int []nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int xor = 0;
            for(int j = i; j < nums.length; j++) {
                xor = xor ^ nums[j];

                if(xor == k) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void countSubArrayWithXORasK02(int []nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0, count = 0;
        for(int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
            if(xor == k) {
                count++;
            }
            if(map.containsKey(k ^ nums[i])) {
                count = count + map.get(k ^ nums[i]);
            }

            if(map.containsKey(xor)) {
                map.put(xor, map.get(xor) + 1);
            }
            else {
                map.put(xor, 1);
            }
        }
        System.out.println(count);
    }

    public static void mergeTwoSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0) {
            return;
        }

        int idx = nums1.length - 1;
        int i = m - 1, j = n - 1;

        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }

        while(j >= 0) {
            nums1[idx--] = nums2[j--];
        }
    }

    public static void mergeIntervals01(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;
            while(j < intervals.length && intervals[j][0] <= end) {
                end = Math.max(intervals[j][1], end);
                j++;
            }
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(start);
            temp.add(end);

            list.add(temp);
            i = j - 1;
        }

        System.out.println(list);
    }

    public static void mergeIntervals02(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            if(list.isEmpty() || list.getLast().get(1) < intervals[i][0]) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);

                list.add(temp);
            }
            else {
                ArrayList<Integer> lastList = list.getLast();
                int maxVal = Math.max(lastList.get(1), intervals[i][1]);
                list.getLast().set(1, maxVal);
            }
        }

        System.out.println(list);
    }

    public static void missingAndRepeatingNumber(int []A) {
//        [1, 2, 3, 6, 7, 5, 7]

        boolean missing = false, repeating = false;
        int []res = new int[A.length + 1];

        for(int i = 0; i < A.length; i++) {
            res[A[i]]++;
        }

        for(int i = 1; i < res.length; i++) {
            if(missing && repeating) {
                break;
            }

            if(res[i] == 0) {
                System.out.println("Missing number is " + i);
                missing = true;
            }

            if(res[i] > 1) {
                System.out.println("Repeating number is " + i);
                repeating = true;
            }
        }
    }

    public static void maxProductSubArray(int []A) {
        int prefix = 1, suffix = 1;
        int res = 0;

        for(int i = 0; i < A.length; i++) {
            prefix = prefix * A[i];
            suffix = suffix * A[A.length - 1 - i];

            int tempMax = Math.max(prefix, suffix);

            res = Math.max(res, tempMax);
        }

        System.out.println(res);
    }

    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,0};

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

//        pascalTriangleType01(1, 1);
//        pascalTriangleType02(6);
//        pascalTriangleType03(6);

//        List<Integer> ans = majorityElement(A);
//        T.C. O(2N)
//        S.C. O(N)

//        sumOfThreeBrute(nums, 0);
//        sumOfThreeBetter(nums, 0);
//        sumOfThreeOptimised(nums, 0);

//        sumOfFourOptimised(nums, 0);

//        maxSubArrayWithSumZero(nums);

//        countSubArrayWithXORasK02(nums, 6);

//        mergeTwoSortedArrays(nums, nums.length, nums, nums.length);

//        mergeIntervals02(intervals);

//        missingAndRepeatingNumber(nums);

        maxProductSubArray(nums);
    }
}