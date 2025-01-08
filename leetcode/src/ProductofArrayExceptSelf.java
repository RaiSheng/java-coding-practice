import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new ProductofArrayExceptSelf().productExceptSelf(
                                new int[]{1, 2, 3, 4})));
    }
    public int[] productExceptSelf(int[] nums) {
        // 每個數的結果是由兩部分組成：
        // 1.
        //    - **左側的乘積**：所有在當前數字 _左邊_ 的數字的乘積。
        // 2.
        //    - **右側的乘積**：所有在當前數字 _右邊_ 的數字的乘積。

        int n = nums.length;
        int[] result = new int[n];

        // 第一步: 計算左側乘積
        result[0] = 1; // 第一個位置左側乘積初始化為 1
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1]; // 每次累乘左側的數字
        }
        // result[0]    result[1]     result[2]     result[3]
        //   (預設)1        1*1=1         1*2=2         2*3=6

        // 第二步: 計算右側乘積，同時更新結果
        int rightProduct = 1; // 初始化右側乘積為 1
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct; // 用右側乘積更新結果
            rightProduct *= nums[i];  // 累乘右側的數字
        }
        //                  result[0]    result[1]     result[2]     result[3]
        //                          1        1*1=1         1*2=2         2*3=6
        //                    1*24=24      1*12=12         2*4=8         6*1=6
        //rightProduct        12*2=24       4*3=12         4*1=4             1(預設)

        return result;
    }
}
