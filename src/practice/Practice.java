package practice;

public class Practice {

    public static int largestAdgacentSum(int[] arr) {
        int max = 0;
        for (int a = 0; a < arr.length - 1; a++) {
            if (arr[a] + arr[a + 1] > max) {
                max = arr[a] + arr[a + 1];
            }
        }
        return max;
    }

    public static int isNextPerfectSquare(int n) {
        int isPerfectSquare = 0;
        if (n >= 0) {
            double baseNo = Math.sqrt(n);
            int intNo = (int) baseNo;
            int nextNo = intNo + 1;
            isPerfectSquare = (int) Math.pow(nextNo, 2);
        }

        return isPerfectSquare;
    }

    public static int nextPerfectSquare(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else {
            double temp;
            double squareNo = n / 2;
            do {
                temp = squareNo;
                squareNo = (temp + (n / temp)) / 2;
            } while ((temp - squareNo) != 0);
            int nextNo = (int) squareNo + 1;
            int perfectNo = nextNo * nextNo;
            return perfectNo;
        }
    }

    public static int nUpCount(int[] arr, int n) {
        int upCount = 0;
        int partialSum = 0;
        int PreviousartialSum = 0;
        for (int a = 0; a < arr.length; a++) {
            PreviousartialSum = partialSum;
            partialSum = partialSum + arr[a];
            if (PreviousartialSum <= n && partialSum > n) {
                upCount++;
            }
        }
        return upCount;
    }

    public static int primeCount(int start, int end) {
        int primeCount = 0;
        for (int a = start; a <= end; a++) {
            if (a > 1) {
                boolean isPrime = true;
                for (int b = 2; b * 2 <= a; b++) {
                    if (a % b == 0) {
                        isPrime = false;
                    }
                }

                if (isPrime) {
                    primeCount++;
                }
            }
        }

        return primeCount;
    }

    public static int isInertial(int[] arr) {
        int isInertial = 0;
        boolean containOddValue = false;
        int maxValue = 0;
        int[] oddValue = new int[arr.length];
        int[] evenValue = new int[arr.length];
        int oddValueIndex = 0;
        int evenvalueIndex = 0;
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] % 2 != 0) {
                containOddValue = true;
                oddValue[oddValueIndex] = arr[a];
                oddValueIndex++;
            } else {
                evenValue[evenvalueIndex] = arr[a];
                evenvalueIndex++;
            }
            if (arr[a] > maxValue) {
                maxValue = arr[a];
            }
        }

        if (containOddValue) {
            if (maxValue % 2 == 0) {
                for (int oddIndex = 0; oddIndex < oddValueIndex; oddIndex++) {
                    for (int evenIndex = 0; evenIndex < evenvalueIndex; evenIndex++) {
                        if (evenValue[evenIndex] != maxValue) {
                            if (evenValue[evenIndex] < oddValue[oddIndex]) {
                                isInertial = 1;
                            } else {
                                isInertial = 0;
                                break;
                            }
                        } else {
                            isInertial = 1;
                        }
                    }
                    if (isInertial == 0) {
                        break;
                    }
                }
            }
        }
        return isInertial;

    }

    public static int isPerfectSquare(int n) {
        int isPerfectSquare = 0;
        double squareNo = Math.sqrt(n);
        int realNo = (int) squareNo;
        if (squareNo - realNo == 0) {
            isPerfectSquare = 1;
        }
        return isPerfectSquare;
    }

    public static int isPerfectSquareR(int n) {
        int isPerfectSquare = 0;
        double temp;
        double squareNo = n / 2;
        do {
            temp = squareNo;
            squareNo = (temp + (n / temp)) / 2;
        } while ((temp - squareNo) != 0);
        int convertedNo = (int) squareNo;

        if ((squareNo - convertedNo) == 0) {
            isPerfectSquare = 1;
        }
        return isPerfectSquare;
    }

    public static int countSquarePairs(int[] arr) {
        int countSquarePair = 0;
        for (int targetIndex = 0; targetIndex < arr.length; targetIndex++) {
            for (int compareIndex = 0; compareIndex < arr.length; compareIndex++) {
                if (arr[targetIndex] > 0 && arr[compareIndex] > 0) {
                    if (arr[targetIndex] < arr[compareIndex]) {
                        if (isPerfectSquareR(arr[targetIndex] + arr[compareIndex]) == 1) {
                            countSquarePair++;
                        }
                    }
                }
            }
        }
        return countSquarePair;
    }

    public static int isPrime(int n) {
        int isPrime = 0;
        if (n > 1) {
            isPrime = 1;
            for (int a = 2; a * 2 <= n; a++) {
                if (n % a == 0) {
                    isPrime = 0;
                    break;
                }
            }
        }
        return isPrime;
    }

    public static int findPorcupineNumber(int n) {
        int porcunenumber = 0;
        int maxValue = Integer.MAX_VALUE;
        boolean isPorcuneNumber = false;
        n++;
        while (n <= maxValue) {
            if (isPorcuneNumber) {
                if (isPrime(n) == 1) {
                    if (n % 10 == 9) {
                        break;
                    } else {
                        isPorcuneNumber = false;
                    }
                }
            } else {
                if (isPrime(n) == 1) {
                    if (n % 10 == 9) {
                        isPorcuneNumber = true;
                        porcunenumber = n;
                    }
                }
            }
            n++;
        }
        return porcunenumber;
    }

    public static int isGuthrieSequence(int[] arr) {
        int isGuthrieSequence = 0;
        int nextSequenceNumber = arr[0];
        if (arr[arr.length - 1] == 1) {
            for (int a = 0; a < arr.length; a++) {
                if (nextSequenceNumber == arr[a]) {
                    isGuthrieSequence = 1;
                    if (arr[a] % 2 == 0) {
                        nextSequenceNumber = arr[a] / 2;
                    } else {
                        nextSequenceNumber = arr[a] * 3 + 1;
                    }
                } else {
                    isGuthrieSequence = 0;
                    break;
                }
            }
        }
        return isGuthrieSequence;
    }

    public static int stantonMeasure(int[] arr) {
        int stantomMeasure = 0;
        int occurenceOfOne = 0;
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] == 1) {
                occurenceOfOne++;
            }
        }
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] == occurenceOfOne) {
                stantomMeasure++;
            }
        }
        return stantomMeasure;
    }

    public static int sumFactor(int[] arr) {
        int sum = 0;
        int sumfactor = 0;
        for (int a = 0; a < arr.length; a++) {
            sum = sum + arr[a];
        }
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] == sum) {
                sumfactor++;
            }
        }
        return sumfactor;
    }

    public static int sumFactors(int[] arr) {
        int sum = 0;
        int sumFactor = 0;
        for (int a = 0; a < arr.length; a++) {
            sum = sum + arr[a];
        }
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] == sum) {
                sumFactor++;
            }
        }
        return sumFactor;
    }

    public static int guthrieIndex(int n) {
        int guthrieIndex = 0;
        if (n > 1) {
            while (n != 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = n * 3 + 1;
                }
                guthrieIndex++;
            }
        }
        return guthrieIndex;
    }

    public static int guthr(int n) {
        int gurthr = 0;
        if (n > 1) {
            while (n != 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = n * 3 + 1;
                }
                gurthr++;
            }
        }
        return gurthr;
    }

    public static int[] solve10() {
        int[] solve10 = new int[2];
        int tenFactorial = 1;
        int x = 10;
        int y = 20;
        boolean factorilaFound = false;
        for (int a = 0; a < 10; a++) {
            tenFactorial = tenFactorial * a;
        }
        for (x = 0; x < 10; x++) {
            int xFactorial = 1;
            if (x > 0) {
                for (int a = 1; a <= x; a++) {
                    xFactorial = xFactorial * a;
                }
            }
            for (y = 0; y < 10; y++) {
                int yFactorial = 1;
                if (y > 0) {
                    for (int b = 1; b <= y; b++) {
                        yFactorial = yFactorial * b;
                    }
                    if (xFactorial + yFactorial == tenFactorial) {
                        factorilaFound = false;
                        break;
                    }
                }
                if (factorilaFound) {
                    break;
                }
            }
            if (x == 10 && y == 10) {
                x = 0;
                y = 0;
            }
        }
        solve10[0] = x;
        solve10[1] = y;

        return solve10;
    }

    public static int repsEqual(int[] arr, int n) {
        int repsEqual = 0;
        for (int lastIndex = arr.length - 1; lastIndex >= 0; lastIndex--) {
            int lastDigit = n % 10;
            n = n / 10;
            if (lastDigit == arr[lastIndex]) {
                repsEqual = 1;
            } else {
                repsEqual = 0;
                break;
            }
        }
        return repsEqual;
    }

    public static int isCentered15(int[] arr) {
        int isCentered15 = 0;
        int lowerIndex = 0;
        int upperIndex = 0;
        int sum = 0;
        if (arr.length % 2 == 0) {
            lowerIndex = (arr.length / 2) - 1;
            upperIndex = arr.length / 2;
        } else {
            lowerIndex = (arr.length - 1) / 2;
            upperIndex = lowerIndex;
        }
        while (lowerIndex > 0 && upperIndex < arr.length) {
            sum = 0;
            for (int a = lowerIndex; a <= upperIndex; a++) {
                sum = sum + arr[a];
            }
            if (sum == 15) {
                isCentered15 = 1;
                break;
            }
            lowerIndex--;
            upperIndex++;
        }
        return isCentered15;
    }

    public static int henry(int a, int b) {
        int henry = 0;
        int perfectCount = 0;
        int max = Integer.MAX_VALUE;
        for (int n = 1; n <= max; n++) {
            int sum = 0;
            for (int div = 1; div < n; div++) {
                if (n % div == 0) {
                    sum = sum + div;
                }
            }
            if (sum == n) {
                perfectCount++;
                if (perfectCount == a) {
                    henry = henry + sum;
                } else if (perfectCount == b) {
                    henry = henry + sum;
                    break;
                }
            }

        }

        return henry;

    }

    public static int isDivisible(int[] arr, int n) {
        int isDivisible = 1;
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] % n != 0) {
                isDivisible = 0;
            } else {
                isDivisible = 1;
                break;
            }
        }
        return isDivisible;
    }

    public static int isNUnique(int[] arr, int n) {
        int isNUnique = 0;
        if (arr.length > 2) {
            for (int a = 0; a < arr.length; a++) {
                for (int innerIndex = a + 1; innerIndex < arr.length; innerIndex++) {
                    if (arr[a] + arr[innerIndex] == n) {
                        if (isNUnique == 0) {
                            isNUnique = 1;
                        } else {
                            isNUnique = 2;
                            break;
                        }
                    }
                }
                if (isNUnique == 2) {
                    isNUnique = 0;
                    break;
                }
            }

        }
        return isNUnique;
    }

    public static int isSquare(int n){
        int isSquare=0;
        
        double temp;
        double sqrtNo=n/2;
        do{
            temp=sqrtNo;
            sqrtNo = (temp+(n/temp))/2;
        }
        while((temp-sqrtNo)!=0);
        int intNo = (int)sqrtNo;
        
        if((sqrtNo-intNo)==0){
            isSquare=1;
        }
        
        return isSquare;
    }
    public static void main(String[] args) {
        System.out.println(largestAdgacentSum(new int[]{1, 2, 4, 8}));
        System.out.println(nextPerfectSquare(9));
        System.out.println(nUpCount(new int[]{2, 3, 1, -6, 8, -3, -1, 2}, 5));
        System.out.println(primeCount(10, 30));
        System.out.println(isInertial(new int[]{2, 12, 4, 6, 8, 11}));
        System.out.println(isPerfectSquareR(16));
        System.out.println(countSquarePairs(new int[]{11, 5, 4, 20}));
        System.out.println(isPrime(7));
        System.out.println(findPorcupineNumber(139));
        System.out.println(isGuthrieSequence(new int[]{4, 2, 1}));
        System.out.println(stantonMeasure(new int[]{1, 3, 1, 1, 1, 3, 3, 2, 3, 3, 3, 4, 4}));
        System.out.println(sumFactors(new int[]{1, -1, 1, -1, 1, -1, 1}));
        System.out.println(guthr(7));
        System.out.println(repsEqual(new int[]{0, 1, 2, 3}, 123));
        System.out.println(isCentered15(new int[]{9, 815, 6}));
        System.out.println(henry(1, 3));
        System.out.println(isDivisible(new int[]{}, 4));
        System.out.println(isNUnique(new int[]{7, 3, 3, 2, 4}, 11));
        System.out.println(isSquare(0));
    }
}
