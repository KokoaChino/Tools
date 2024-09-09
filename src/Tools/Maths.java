package Tools;


public class Maths {
    // 数学运算

    // 求绝对值
    public static int abs(int a) {
        return Math.abs(a);
    }

    // 求最大公约数
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // 求最小公倍数
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
