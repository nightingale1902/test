package LeetCode;

public class LeetCode_043MultiplyStrings043 {
    public String multiply(String num1, String num2) {
        //1. num1 和 num2 是否为空。
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return null;
        //2. num1 和 num2 的长度小于110。
        if (num1.length() >= 110 || num2.length() >= 110) return null;
        //3. num1 和 num2 只包含数字 0-9。
        if (!num1.matches("^\\d+$") || !num2.matches("^\\d+$")) return null;
        //4. num1 和 num2 均不以零开头，除非是数字 0 本身。
        if ((num1.length() != 1 && num2.charAt(0) == '0') || (num2.length() != 1 && num1.charAt(0) == '0')) return "0";
        int[] res = new int[num1.length() + num2.length() - 1];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                res[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int i = res.length - 1; i > 0; i--) {
            if (res[i] > 9) {
                res[i - 1] += res[i] / 10;
                res[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        //Arrays.stream(res).forEach(sb::append);
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
    public boolean isNumberic(String string){
        //Pattern pattern = Pattern.compile("^\\d+$");
       // Matcher isNum = pattern.matcher(string);
        return string.matches("^\\d+$");

    }

    public String multiply2(String num1, String num2) {
        if (num1.length() == 0 && num2.length() == 0) return "0";
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0 ; i--) {
            for (int j = num2.length() - 1; j >= 0 ; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int posLow = i + j + 1;
                int posHigh = i + j;
                mul += result[posLow];
                result[posLow] = mul % 10;
                result[posHigh] += mul / 10;
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int res : result){
            if (!(sb.length() == 0 && res == 0))
                sb.append(res);
        }
        return (sb.length() == 0) ? "0" : sb.toString();
    }

}
