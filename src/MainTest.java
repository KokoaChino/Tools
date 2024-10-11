// int n = Integer.parseInt(reader.readLine());
// int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainTest {

    public int ac_fun(int a, int b) { // 正确代码
        return a + b;
    }

    public int my_fun(int a, int b) { // 测试代码
        return Math.abs(a + b);
    }

    private static List<Object[]> getParams() {
        List<Object[]> res = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 500; i++) {
            res.add(new Object[]{rand.nextInt(20000) - 10000, rand.nextInt(20000) - 10000});
        }
        return res;
    }

    public static void main(String[] args) {
        MainTest test = new MainTest();
        FunctionInterface acFun = (params) -> {
            int a = (int) params[0], b = (int) params[1];
            return test.ac_fun(a, b);
        };
        FunctionInterface myFun = (params) -> {
            int a = (int) params[0];
            int b = (int) params[1];
            return test.my_fun(a, b);
        };
        BeatCode.run(acFun, myFun, getParams()); // 开始对拍
    }
}