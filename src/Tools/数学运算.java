package Tools;


class Maths { // 数学运算

    public static int gcd(int a, int b) { // 求最大公约数
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) { // 求最小公倍数
        return a * b / gcd(a, b);
    }
}
