public class Main {
    public static int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = (high + low) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void lowerBound(int []nums, int target) {
        // The lower bound algorithm finds the first or the smallest index in a sorted array
        // where the value at that index is greater than or equal to a given key i.e. x.

        int low = 0, high = nums.length - 1;
        int res = nums.length;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                res = mid;
                high = mid - 1;
            }
            else if(nums[mid] > target) {
                res = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        System.out.println(res);
    }

    public static void upperBound(int []nums, int target) {
        // The upper bound algorithm finds the first or the smallest index in a sorted
        // array where the value at that index is greater than the given key i.e. x.

        int low = 0, high = nums.length - 1;
        int res = nums.length;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] <= target) {
                low = mid + 1;
            }
            else {
                res = mid;
                high = mid - 1;
            }
        }
        System.out.println(res);
    }

    public static int searchInsertPosition(int []nums, int target) {
        int low = 0, high = nums.length - 1;
        int res = nums.length;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }

    public static int floor(int []nums, int target) {
        // The floor of x is the largest element in the array which is smaller than or
        // equal to x. The ceiling of x is the smallest element in the array greater
        // than or equal to x

        int res = -1;
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                return nums[mid];
            }
            else if(nums[mid] < target) {
                res = nums[mid];
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return res;
    }

    public static int ceiling(int []nums, int target) {
        int res = -1;
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                return nums[mid];
            }
            else if(nums[mid] > target) {
                res = nums[mid];
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static void floorAndCeiling(int []nums, int target) {
        int floor = floor(nums, target);
        int ceiling = ceiling(nums, target);

        System.out.println("Floor - " + floor + ", Ceiling - " + ceiling);
    }

    public static void lastOccurrence(int []nums, int target) {
        int low = 0, high = nums.length - 1;
        int res = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                res = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        System.out.println(res);
    }

    public static int first(int []nums, int target, int low, int high) {
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static int last(int []nums, int target, int low, int high) {
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int[] findFirstAndLastPositionOfElement(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        int first = first(nums, target, low, high);
        int last = last(nums, target, low, high);

        return new int[]{first, last};
    }

    public static void countOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        int first = first(nums, target, low, high);
        int last = last(nums, target, low, high);

        System.out.println(last - first + 1);
    }

    public static int searchInRotatedArrayType01(int []nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if(nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int searchInRotatedArrayType02(int []nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if(nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int findMinInRotatedArray(int []nums) {
        int low = 0, high = nums.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[high]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return nums[low];
    }

    public static int singleElementInSortedArray(int []nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        if(nums[0] != nums[1]) {
            return nums[0];
        }

        if(nums[nums.length - 2] != nums[nums.length - 1]) {
            return nums[nums.length - 1];
        }

        int low = 1, high = nums.length - 2;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int findPeakElement(int []nums) {
        if(nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }

        if(nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        int low = 1, high = nums.length - 2;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            else if(nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            }
            else if(nums[mid] > nums[mid + 1]) {
                high = mid - 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []nums = {1, 1, 2, 2, 2, 2, 2, 3};

//        lowerBound(nums, 9);

//        upperBound(nums, 2);

//        int ans = searchInsertPosition(nums, 6);
//        System.out.println(ans);

//        floorAndCeiling(nums, 5);

//        lastOccurrence(nums, 60);

//        int []ans = findFirstAndLastPositionOfElement(nums, 13);

//        countOccurrence(nums, 2);
    }
}