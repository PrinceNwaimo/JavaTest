package leetCodeProblems;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - prices[i - 1];
            if (currProfit > 0) {
                profit += currProfit;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 solver = new BestTimeToBuyAndSellStock2();

        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {1,2,3,4,5};
        int[] prices3 = {7,6,4,3,1};

        System.out.println(solver.maxProfit(prices1));
        System.out.println(solver.maxProfit(prices2));
        System.out.println(solver.maxProfit(prices3));
    }
}
