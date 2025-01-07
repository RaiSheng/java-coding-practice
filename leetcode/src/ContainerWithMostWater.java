public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        // 初始化左右指針和最大容器容量
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        // 當左右指針未相遇時持續遍歷
        while (left < right) {
            // 計算當前容器的容量
            int area = (right - left) * Math.min(height[left], height[right]);

            // 更新最大容量（若當前容量更大）
            maxArea = Math.max(maxArea, area);

            // 移動矮的那一側指針
            // 因為容器的高度由較矮的牆決定，移動矮的一側可能會發現更大的容器
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        // 返回最大的容器容量
        return maxArea;
    }
}
