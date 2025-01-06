import java.util.HashMap;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 使用 HashMap 存儲每個數字以及其最後一次出現的位置
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 如果數字已經存在於 map 中
            if (map.containsKey(nums[i])) {
                // 計算索引距離
                if (i - map.get(nums[i]) <= k) {
                    // 符合題目條件
                    return true;
                }
            }
            // 更新該數字在 map 中的最新索引
            map.put(nums[i], i);
        }
        // 遍歷完成仍未找到
        return false;
    }
}
