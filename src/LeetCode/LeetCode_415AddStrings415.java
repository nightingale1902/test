package LeetCode;

public class LeetCode_415AddStrings415 {
    public String addStrings(String num1, String num2) {
        if (num1.length() >= 5100 || num2.length() >= 5100) return null;
        if (!num1.matches("^\\d+$") || !num2.matches("^\\d+$")) return null;
        if ((num1.length() != 1 && num2.charAt(0) == '0')) return num1;
        if ((num2.length() != 1 && num1.charAt(0) == '0')) return num2;
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i >= 0) carry += num1.charAt(i--) - '0';
            if(j >= 0) carry += num2.charAt(j--) - '0';
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }


}
