import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Aufgabe A
    public static int generateRandomMonth() {
        Random random = new Random();
        int randomNum = random.nextInt(12) + 1;
        return randomNum;
    }

    public static String monthMapper() {

        System.out.println("Enter a number between 1-12 or \"r\" to pick a random month: ");
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        String[] array = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };


        if (s.equals("r")) {
            int month = generateRandomMonth();
            return array[month-1];


        } else if (1 <= Integer.parseInt(s) && Integer.parseInt(s) <= 12) {
            return array[Integer.parseInt(s)-1];
        }

        return "Invalid month";
    }

    public static int[] extendArray(int[] arrayA, int[] arrayB) {
        int lenArrayA = arrayA.length;
        int lenArrayB = arrayB.length;
        int lenBothArrays = lenArrayA + lenArrayB;

        int[] sumArrays = new int[lenArrayA + lenArrayB];

        if (lenArrayA < lenArrayB) {
            for (int i=0; i<lenArrayA; i++)
                sumArrays[i] = arrayA[i];
            for (int j=0; j<lenArrayB; j++)
                sumArrays[lenArrayA+j] = arrayB[j];
        } else if (lenArrayB < lenArrayA) {
            for (int i=0; i<lenArrayB; i++)
                sumArrays[i] = arrayB[i];
            for (int j=0; j<lenArrayA; j++)
                sumArrays[lenArrayB+j] = arrayA[j];
        } else if (lenArrayA == lenArrayB) {
            for (int i=0; i<lenBothArrays; i++) {
                if (i % 2 == 0)
                    sumArrays[i] = arrayB[i/2];
                else
                    sumArrays[i] = arrayA[i/2];
            }
        }
        return sumArrays;
    }

    // Aufgabe B

    public static boolean compareDoubles() {

        Scanner myScanner = new Scanner(System.in);
        System.out.print("Number 1: ");
        double firstNum = myScanner.nextDouble();
        System.out.print("Number 2: ");
        double secondNum = myScanner.nextDouble();

        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.DOWN);

        String firstNumS = df.format(firstNum);
        String secondNumS = df.format(secondNum);

        if (firstNumS.equals(secondNumS))
            return true;

        return false;

    }

    public static int countWordsStartWith(String[] toSearchArray, String toMatchArray) {
        int count = 0;
        int lenToSearchArray = toSearchArray.length;

        for (int i=0; i<lenToSearchArray; i++) {
            if (toSearchArray[i].startsWith(toMatchArray))
                count += 1;
        }

        return count;
    }


    public static void main(String[] args) {
        Main inst = new Main();

        // Aufgabe A
        //int num = inst.generateRandomMonth();
        //System.out.println(num);

        //String m = inst.monthMapper();
        //System.out.println(m);

        //int[] arr1 = {1, 2, 11, 12, 13};
        //int[] arr2 = {3, 4, 5};
        //int[] arr = inst.extendArray(arr1, arr2);
        //for (int i =0; i<arr.length; i++)
            //System.out.println(arr[i]);

        // Aufgabe B
        //boolean val = inst.compareDoubles();
        //System.out.println(val);

        String[] a = {"those", "who", "thdo", "remember", "The"};
        String b = "th";
        int c = inst.countWordsStartWith(a, b);
        System.out.println(c);
    }
}