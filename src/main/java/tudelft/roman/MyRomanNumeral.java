package tudelft.roman;

import java.util.*;

public class MyRomanNumeral {
    private static HashMap<Character, Integer> NUMERALS;
    private static SortedMap<Integer, String> NUMBERS;

    public MyRomanNumeral() {
        this.NUMERALS = new HashMap<>();
        this.NUMERALS.put('I', 1);
        this.NUMERALS.put('V', 5);
        this.NUMERALS.put('X', 10);
        this.NUMERALS.put('L', 50);
        this.NUMERALS.put('C', 100);
        this.NUMERALS.put('D', 500);
        this.NUMERALS.put('M', 1000);

        this.NUMBERS = new TreeMap<>(Collections.reverseOrder());
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

    public String intToRoman(int number) {
        int currValue = number;
        String numerals = "";

        for (int key : this.NUMBERS.keySet()) {
            if (currValue <= 0) {
                break;
            }

            int mKey = nextSmallestBaseTen(key);

            if (currValue >= key - mKey) {
                if (currValue < key) {
                    numerals += this.NUMBERS.get(mKey);
                    numerals += this.NUMBERS.get(key);
                    currValue -= key - mKey;
                }
                else if (isRepeatable(this.NUMBERS.get(key))) {
                    int factor = currValue / key;
                    for (int i = 0; i < factor; ++i) {
                        numerals += this.NUMBERS.get(key);
                        currValue -= key;
                    }
                }
                else {
                    numerals += this.NUMBERS.get(key);
                    currValue -= key;
                }
            }
        }

        return numerals;
    }

    private boolean isRepeatable(String numeral) {
        return numeral.equals("I") || numeral.equals("X") || numeral.equals("C") || numeral.equals("M");
    }

    private int nextSmallestBaseTen(int num) {
        int next = 0;

        switch (num) {
            case 1000:
            case 500:
                next = 100;
                break;
            case 100:
            case 50:
                next = 10;
                break;
            case 10:
            case 5:
                next = 1;
                break;
            default:
                next = 0;
        }

        return next;
    }
}
