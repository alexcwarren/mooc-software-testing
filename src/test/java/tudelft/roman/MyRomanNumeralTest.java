package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyRomanNumeralTest {

    private MyRomanNumeral roman;

    @BeforeEach
    public void initialize() {
        this.roman = new MyRomanNumeral();
    }

    @Test
    public void singleNumber() {
        int result = roman.romanToInt("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void numberWithManyDigits() {
        int result = roman.romanToInt("VIII");
        Assertions.assertEquals(8, result);
    }

    @Test
    public void numberWithSubtractiveNotation() {
        int result = roman.romanToInt("IV");
        Assertions.assertEquals(4, result);
    }

    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        int result = roman.romanToInt("XLIV");
        Assertions.assertEquals(44, result);
    }

    @Test
    public void singleNumeral() {
        String result = roman.intToRoman(1);
        Assertions.assertEquals("I", result);
    }

    @Test
    public void multipleNumerals() {
        String result = roman.intToRoman(8);
        Assertions.assertEquals("VIII", result);
    }

    @Test
    public void numeralWithSubtractiveNotation() {
        String result = roman.intToRoman(9);
        Assertions.assertEquals("IX", result);
    }

    @Test
    public void numeralWithandWithoutSubtractiveNotation() {
        String result = roman.intToRoman(434);
        Assertions.assertEquals("CDXXXIV", result);
    }
}
