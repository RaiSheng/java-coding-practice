import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(2));
    }
    public boolean isHappy(int n) {
        // 使用 HashSet 檢查結果是否重覆
        Set<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n != 0) {
                // 當前位數的平方
                sum += (n % 10) * (n % 10);
                // 捨棄最右邊處理過的 1 位數
                n /= 10;
            }
            n = sum;
        }

        // 直到有一天 n == 1 或 set 開始重覆，則 return
        return n == 1;
    }
}
