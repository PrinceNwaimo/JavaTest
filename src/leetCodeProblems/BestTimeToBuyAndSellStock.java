package leetCodeProblems;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(profit, maxProfit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sol = new BestTimeToBuyAndSellStock();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit: " + sol.maxProfit(prices1)); // 5, buy at 1 sell at 6

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max profit: " + sol.maxProfit(prices2)); // 0, no profit possible
    }
}
