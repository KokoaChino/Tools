import java.util.Arrays;
import java.util.List;


public class BeatCode { // 对拍模版
    public static void run(FunctionInterface acFun, FunctionInterface myFun, List<Object[]> params) {
        for (int i = 0; i < params.size(); i++) {
            Object[] param = params.get(i);
            String ac = String.valueOf(acFun.apply(param)), my = String.valueOf(myFun.apply(param));
            if (!ac.equals(my)) {
                System.out.println((i + 1) + " / " + params.size());
                System.out.println("测试用例：\n" + Arrays.toString(param));
                System.out.println("预期结果：\n" + ac);
                System.out.println("你的输出：\n" + my);
                return;
            }
        }
    }
}