public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {

        System.out.println(new BestTimetoBuyandSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

    }

    public int maxProfit(int[] prices) {

//        醜陋的 <方法I>
//        int maxProfit = 0;
//
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[j] - prices[i] > 0) {
//                    maxProfit = Math.max((prices[j] - prices[i]), maxProfit);
//                }
//            }
//        }
//
//        return maxProfit;


        // <方法II> 動態規劃思路：在一次遍歷中追蹤到當前的最低買入價格，以及可能的最大利潤

        // 初始化最低買入價與最大利潤
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;

        // 一次遍歷陣列
        for (int price : prices) {
            // 更新最小值
            minValue = Math.min(price, minValue);
            // 更新最大收益
            maxProfit = Math.max(price - minValue, maxProfit);
        }

        return maxProfit;
    }
}
