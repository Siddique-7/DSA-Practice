public class Integer_to_Roman_12 {

    public static String intToRoman(int num) {
        // Arrays of Roman numerals for each digit place
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] + 
               hundreds[(num % 1000) / 100] +
               tens[(num % 100) / 10] +
               ones[num % 10];
    }

    public static void main(String[] args) {
        int num1 = 3;      // "III"
        int num2 = 58;     // "LVIII"
        int num3 = 1994;   // "MCMXCIV"

        System.out.println(intToRoman(num1));  // Output: III
        System.out.println(intToRoman(num2));  // Output: LVIII
        System.out.println(intToRoman(num3));  // Output: MCMXCIV
    }
}
