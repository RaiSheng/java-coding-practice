import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }



    // 1. 透過 Map 資料結構存儲資料，以此提升效能(免除雙重迴圈)
    // 2. 找到關係式 ( int complement = target - nums[i]; )
    // 3. map.get(Key) → return 該 Key 的 value

    public int[] twoSum(int[] nums, int target) {
        // 使用HashMap來記錄已經遍歷過的數字及其索引
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 計算當前數字需要的匹配值
            int complement = target - nums[i];

            // 如果匹配值已經在HashMap中找到
            if (map.containsKey(complement)) {
                // map.get(Key) → return value
                return new int[]{map.get(complement), i};
            }

            // 將當前數字及其索引加入HashMap
            map.put(nums[i], i);
        }

        // 如果沒有找到結果
        throw new IllegalArgumentException("No solution found");
    }
}
