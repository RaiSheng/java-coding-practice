public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{1, 1, 1, 2, 3, 4, 1}));
    }

    // 假設必定存在一個元素 x，其個數必定會大於總元素個數之 1 / 2
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            // 若 count 為 0 ， 將當前元素設定為 候選元素
            if (count == 0) {
                candidate = num;
            }
            // 計數更新
            count += candidate == num ? 1 : -1;
        }

        // 回傳答案
        return candidate;
    }
}

