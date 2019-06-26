package niukewang;

/**
 * @Author: YourName
 * @Date: 2019-06-20
 */
public class TestClass {
    private static void testMethod(){
        System.out.println("testMethod");
    }
    /*链接：https://www.nowcoder.com/questionTerminal/e252668ee94947bea07edd7300340115来源：牛客网

此处是类对方法的调用，不是对象对方法的调用。
2）方法是static静态方法，直接使用"类.方法"即可，因为静态方法使用不依赖对象是否被创建。
null可以被强制类型转换成任意类型（不是任意类型对象），于是可以通过它来执行静态方法。
3）非静态的方法用"对象.方法"的方式，必须依赖对象被创建后才能使用，若将testMethod()方法前的static去掉，则会报 空指针异常 。此处也验证了2）的观点
当然，不管是否静态方法，都是已经存在的，只是访问方式不同。*/

    /*作者：吃土豆的人2018
链接：https://www.nowcoder.com/questionTerminal/e252668ee94947bea07edd7300340115
来源：牛客网

1. 如上题，方法为静态，程序没有报错，此时调用方法可以是 类.静态方法或对象（类的实例化）.静态方法，程序木有错误说明null有可能转化为此类类型，
    符合上述，也可能转化为此类类型对象，因为类对象调用静态方法不需要实例化，所以程序也正常运行。
2.去掉方法中的static，此时编译无错误，运行出现空指针异常NullPointerException,由于此时调用非静态方法，对象.方法，而程序无编译错误，
    故只能是把null转化为了此类类对象，因为调用非静态方法绝不允许类.方法，故null只能被转化为此类对象，出现空指针异常是因为null转化为的此类对象没有new,即没有被实例化，
    而调用非静态方法的对象必须实例化。
3. 就这样吧。结论: null可以被强制转化为任意类型的对象*/
    public static void main(String[] args) {
        ((TestClass)null).testMethod();
    }
}
