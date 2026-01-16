import java.util.Arrays;

public class Main {
    public static int findSquareRoot(int num) {
        int low = 1, high = num, ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(mid * mid == num) {
                return mid;
            }
            else if(mid * mid < num) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static boolean findNthRoot(int n, int num) {
        int low = 0, high = num;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            long calc = findPower(mid, n);
            if(calc == num) {
                return true;
            }
            if(calc > num) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static long findPower(int num, int power) {
        if(num == 1) {
            return 1;
        }
        else {
            long half = findPower(num, power / 2);
            long ans = half * half;
            if(power % 2 == 1) {
                return num * ans;
            }
            else {
                return ans;
            }
        }
    }

    public static int kokoEatingBanana(int []nums, int h) {
        int max = Integer.MIN_VALUE, ans = 0;

        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }

        int low = 1, high = max;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            int calc = findHours(nums, mid);

            if(calc > h) {
                low = mid + 1;
            }
            else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findHours(int []nums, int k) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = sum + (int)Math.ceil(nums[i] / (double)k);
        }
        return sum;
    }

    public static int bouquets(int []bloom_days, int m, int k) {
        if(m * k > bloom_days.length) {
            return -1;
        }
        // m - no. of bouquets, k - no. of consecutive flowers
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE, ans = 0;

        for(int i = 0; i < bloom_days.length; i++) {
            if(bloom_days[i] < low) {
                low = bloom_days[i];
            }
            if(bloom_days[i] > high) {
                high = bloom_days[i];
            }
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(calc(bloom_days, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean calc(int []bloom_days, int day, int m, int k) {
        int count = 0, bouquet = 0;

        for (int bloomDay : bloom_days) {
            if (bloomDay <= day) {
                count++;
                if (count == k) {
                    bouquet++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return bouquet >= m;
    }

    public static void findSmallestDivisor(int []nums, int threshold) {
        int low = 1, high = Integer.MIN_VALUE, ans = 0;

        for(int num: nums) {
            if(num > high) {
                high = num;
            }
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(divisor(nums, mid, threshold)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }

    public static boolean divisor(int []nums, int mid, int threshold) {
        int val = 0;
        for(int num: nums) {
            val = val + (int)(Math.ceil(num/(double)mid));
        }

        return val <= threshold;
    }

    public static void ship(int []nums, int days) {
        int low = Integer.MIN_VALUE, high = 0, ans = 0;

        for(int num: nums) {
            if(low < num) {
                low = num;
            }
            high = high + num;
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(checkPossible(nums, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }

    public static boolean checkPossible(int []nums, int weight, int threshold) {
        int current = 0, days = 1;

        for(int num: nums) {
            if(current + num > weight) {
                days++;
                current = num;
            } else {
                current = current + num;
            }
        }

        return days <= threshold;
    }

    public static int findKthMissingPositiveNumberBruteForce(int []nums, int k) {
        int missingCount = 0;
        int current = 1;
        int i = 0;

        while(true) {
            if(i < nums.length && nums[i] == current) {
                i++;
            } else {
                missingCount++;
                if(missingCount == k) {
                    return current;
                }
            }
            current++;
        }
    }

    public static int findKthMissingPositiveNumberOptimal(int []nums, int k) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int missing = nums[mid] - (mid + 1);

            if(missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low + k;
    }

    public static void aggresiveCow(int []nums, int cows) {
        Arrays.sort(nums);

        int low = 1, high = nums[nums.length - 1] - nums[0], ans = 0;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossible(nums, mid, cows)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean isPossible(int []nums, int dist, int cows) {
        cows--;
        int prevPos = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - prevPos >= dist && cows > 0) {
                cows--;
                prevPos = nums[i];
            }
        }
        return cows == 0;
    }

    public static void main(String[] args) {
//        01
//        int ans = findSquareRoot(27);
//        System.out.println(ans);

//        02
//        int []nums = {3, 6, 7, 11};
//        int ans = kokoEatingBanana(nums, 8);
//        System.out.println(ans);

//        03
//        int []nums = {7, 7, 7, 7, 13, 11, 12, 7};
//        int ans = bouquets(nums, 2, 3);
//        System.out.println(ans);

//        04
//        int []nums = {1, 2, 5, 9};
//        findSmallestDivisor(nums, 6);

//        05
//        int []nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        ship(nums, 5);

//        06
//        int []nums = {0, 3, 4, 7, 10, 9};
//        aggresiveCow(nums, 4);
    }
}