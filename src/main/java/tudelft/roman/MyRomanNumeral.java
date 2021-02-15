package tudelft.roman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyRomanNumeral {
    private static HashMap<Character, Integer> NUMERALS;
    private static HashMap<Integer, String> NUMBERS;

    public MyRomanNumeral() {
        this.NUMERALS = new HashMap<>();
        this.NUMERALS.put('I', 1);
        this.NUMERALS.put('V', 5);
        this.NUMERALS.put('X', 10);
        this.NUMERALS.put('L', 50);
        this.NUMERALS.put('C', 100);
        this.NUMERALS.put('D', 500);
        this.NUMERALS.put('M', 1000);

        this.NUMBERS = new HashMap<>();
        this.NUMBERS.put(1, "I");
        this.NUMBERS.put(5, "V");
        this.NUMBERS.put(10, "X");
        this.NUMBERS.put(50, "L");
        this.NUMBERS.put(100, "C");
        this.NUMBERS.put(500, "D");
        this.NUMBERS.put(1000, "M");
    }

    public int romanToInt(String numerals) {
        numerals = numerals.toUpperCase();

        char[] numeralArr = numerals.toCharArray();
        int number = 0;
        int currNum = 0;
        int nextNum = 0;

        for (int i = 0; i < numeralArr.length; ++i) {
            currNum = this.NUMERALS.get(numeralArr[i]);
            nextNum = i < numeralArr.length - 1 ? this.NUMERALS.get(numeralArr[i+1]) : 0;

            if (currNum < nextNum) {
                currNum = nextNum - currNum;
                ++i;
            }

            number += currNum;
        }

        return number;
    }

//    public String intToRoman(int number) {
////        System.out.printf("intToRoman(%d) = %s\n", number, this.NUMBERS.get(number));
//        ArrayList numeralArr = new ArrayList();
//
//        String numerals = "";
//        for (Object ch : numeralArr) {
//            numerals += "";
//        }
//
//        return numeralArr.size() > 0 ? numerals : "";
//    }
}
