// NOTE - Striver solved this questions using loops, and I solved (some) using recursion.

public class Main {
    public static void printDigits(int num) {
        if(num <= 0) {
            return;
        }
        printDigits(num / 10);
        System.out.print((num % 10) + " ");
    }

    public static int countDigits(int num, int val) {
        if( num <= 0) {
            return val;
        }
        else {
            return countDigits(num / 10, val + 1);
        }
    }

    public static void countDigitsOptimised(int num) {
        if(num == 0){
            System.out.println(1);
        }
        else {
            int ans = (int)(Math.log10(num) + 1);
            System.out.println(ans);
        }
    }

    public static int reverseNumber(int num, int rev) {
        if(num <= 0) {
            return rev;
        }
        else{
            return reverseNumber(num / 10, rev * 10 + num % 10);
        }
    }

    public static boolean checkPalindrome(int num) {
        int original = num;
        int rev = 0;

        while(num > 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }

        return original == rev;
    }

    public static boolean isArmstrong(int num) {
        int original = num;
        int digits = (int)(Math.log10(num)) + 1;
        int cal = 0;
        while(num > 0) {
            cal = cal + (int)Math.pow(num % 10, digits);
            num = num / 10;
        }

        return original == cal;
    }

    public static void printDivisors(int num) {
        for(int i = 1; i <= num; i++) {
            if(num % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void printDivisorOptimised(int num) {
        /*
        1 * 36
        2 * 18
        3 * 12
        4 * 9
        6 * 6 --
        9 * 4
        12 * 3
        18 * 2
        36 * 1
        */

        for(int i = 1; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                System.out.print(i + " ");

                if((num / i) != i) {
                    System.out.print((num / i) + " ");
                }
            }
        }
    }

    public static boolean isPrime(int num) {
        if(num == 1) {
            return true;
        }

        int count = 0;
        for(int i = 1; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                count++;

                if((num / i) != i) {
                    count++;
                }
            }
        }
        if(count == 2) {
            return true;
        }
        return false;
    }

    public static int HCForGCD(int num1, int num2) {
        // num1 - 1, 3, 9
        // num2 - 1, 2, 6, 12, 3, 4
        // Common factors - 1, 3 HCF - 3

        for(int i = Math.min(num1, num2); i >= 1; i--) {
            if(num1 % i == 0 && num2 % i == 0) {
                return i;
            }
        }
        return -1;
    }

    // Euclidean Algorithm
    public static int HCForGCDOptimised(int num1, int num2) {
        if(num2 <= 0) {
            return num1;
        }
        return HCForGCDOptimised(num2, num1 % num2);
    }

    public static void main(String[] args) {
//      01.  Print Digits
//        printDigits(7789);
//        System.out.println( );

//        T.C. O(log(N)) - N is number of digits
//        S.C. O(log(N)) - N is number of digits
//        if we do using loops then S.C. - O(1)


//      02. Count Digits
//        int ans = countDigits(7789, 0);
//        System.out.println(ans);

//        T.C. O(log(N)) - N is number of digits
//        S.C. O(log(N)) - N is number of digits
//        if we do using loops then S.C. - O(1)

//      03. Count Digits --Optimised
//        countDigitsOptimised(7789);

//        T.C. O(1) - N is number of digits
//        S.C. O(1) - N is number of digits

//      04. Reverse a number
//        int ans = reverseNumber(1234, 0);
//        System.out.println(ans);

//        T.C. O(log(N)) - N is number of digits
//        S.C. O(log(N)) - N is number of digits
//        if we do using loops then S.C. - O(1)

//      05. Palindrome
//        boolean ans = checkPalindrome(12321);
//        System.out.println(ans);

//        T.C. O(log(N)) - n is number of digits
//        S.C. O(1)

//      06. Armstrong Number
//      A number is called an Armstrong number if the sum of its digits, each raised to the power of the total number of digits, is equal to the number itself.

//        boolean ans = isArmstrong(407);
//        System.out.println(ans);

//        T.C. O(log(N))
//        S.C. O(1)

//      07. Print Divisors
//        printDivisors(36);

//      08. Print Divisors --Optimised
//        printDivisorOptimised(36);

//        T.C. O(sqrt(N))
//        S.C. O(1)

//      09. Check Prime Number
//        boolean ans = isPrime(12);
//        System.out.println(ans);

//        T.C. O(sqrt(N))
//        S.C. O(1)

//      10. GCD or HCF
//        int ans = HCForGCD(9, 12);
//        System.out.println(ans);

//        T.C. O(Math.min(num1, num2))
//        S.C. O(1)

//      11. HCF or GCD Optimised
        int ans = HCForGCDOptimised(10, 30);
        System.out.println(ans);
    }
}