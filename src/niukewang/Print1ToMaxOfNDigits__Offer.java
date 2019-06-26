package niukewang;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: YourName
 * @Date: 2019-06-08
 * [剑指offer] 打印1到最大的n位数
 */
public class Print1ToMaxOfNDigits__Offer {
    public void print1ToMaxOfNDigits(int n) {
        if (n < 0)
            return;
        char[] number = new char[n];
        Arrays.fill(number, '0');
        while (!increment(number)) {
            printNumber(number);
        }
        return;
    }
    public boolean increment(char[] num) {
        boolean isOverflow = false;
        int size = num.length;
        int carry = 0;
        for (int i = size - 1; i >= 0; i--) {
            int temp = num[i] - '0' + carry;
            if (i == size - 1)
                temp++;
            if (temp >= 10) {
                if (i == 0) //最高位溢出
                    isOverflow = true;
                else {
                    temp -= 10;
                    carry = 1;
                    num[i] = (char) ('0' + temp);
                }
            } else {
                num[i] = (char) ('0' + temp);
                break;
            }
        }
        return isOverflow;
    }

    public void printNumber(char[] num) {
        int size = num.length;
        int i = 0;
        while (i < size && num[i] == '0') //i < size在前，否则越界
            i++;
        //char[] printNum = new char[size - i];
        //System.arraycopy(num, i, printNum, 0, size - i);//复制数组
        if (i == size)//不打印全0
            return;
        char[] printNum = Arrays.copyOfRange(num, i, size);//复制数组
        System.out.println(printNum);

    }

    //全排列
    public void printToMax2(int n){
        if(n <= 0) return;
        char[] number = new char[n];
        Arrays.fill(number, '0');
        printOrder(number,n,0);
    }
    public void printOrder(char[] number, int n, int loc){
        if(loc == n) return;
        for(int i = 0; i <= 9; i++){
            number[loc] = (char)('0' + i);
            if(loc == n - 1){
                printNumber(number);
            }
            printOrder(number,n,loc + 1);
        }
    }
@Test
public void test(){
    Print1ToMaxOfNDigits__Offer print1ToMaxOfNDigits__offer = new Print1ToMaxOfNDigits__Offer();
    print1ToMaxOfNDigits__offer.print1ToMaxOfNDigits(1);
}

/*
public void print1ToMaxOfNDigits(int n) {
    if (n < 0)
        return;
    byte[] number = new byte[n];
    //Arrays.fill(number, 0);
    Arrays.fill(number, (byte) 0);
    while (!increment(number)) {
        printNumber(number);
    }
    return;
}
    public boolean increment(byte[] num) {
        boolean isOverflow = false;
        int size = num.length;
        int carry = 0;
        for (int i = size - 1; i >= 0; i--) {
            byte temp = (byte) (num[i] + carry);
            if (i == size - 1)
                temp++;
            if (temp >= 10) {
                if (i == 0) //最高位溢出
                    isOverflow = true;
                else {
                    temp -= 10;
                    carry = 1;
                    num[i] = temp;
                }
            } else {
                num[i] = temp;
                break;
            }
        }
        return isOverflow;
    }

    public void printNumber(byte[] num) {
        int size = num.length;
        int i = 0;
        while (i < size && num[i] == 0) //i < size在前，否则越界
            i++;
        //char[] printNum = new char[size - i];
        //System.arraycopy(num, i, printNum, 0, size - i);//复制数组
        if (i == size)//不打印全0
            return;
        byte[] printNum = Arrays.copyOfRange(num, i, size);//复制数组
        System.out.println(printNum);

    }
*/

    //全排列
/*    public void printToMax2(int n){
        if(n <= 0) return;
        char[] number = new char[n];
        Arrays.fill(number, '0');
        printOrder(number,n,0);
    }
    public void printOrder(byte[] number, int n, int loc){
        if(loc == n) return;
        for(int i = 0; i <= 9; i++){
            number[loc] = (byte) i;
            if(loc == n - 1){
                printNumber(number);
            }
            printOrder(number,n,loc + 1);
        }
    }*/
}
