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

    public static void main(String[] args) {
        int ans = findSquareRoot(27);
        System.out.println(ans);
    }
}