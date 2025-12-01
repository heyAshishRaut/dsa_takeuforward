import java.util.*;

public class Main {
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

    public static void main(String[] args) {
        int []nums = {4, 2, 2, 6, 4};

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
    }
}