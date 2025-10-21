// [[index, value],[index, value], ... ]

class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;

        List<int[]> priceList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] unit = new int[]{i,prices[i]};
            priceList.add(unit);
        }

        // sort
        priceList.sort(Comparator.comparingInt(arr -> arr[1]));

        // two pointer
        
        int maxBenefit = 0;
        for (int i = 0; i < N-1; i++) {
            int headPointer = i;
            int tailPointer = N-1;

            while (headPointer < tailPointer) {
                int[] buy = priceList.get(headPointer);
                int[] sell = priceList.get(tailPointer);
                int benefit = sell[1] - buy[1];

                if (buy[0] > sell[0]) {
                    tailPointer--;
                    continue;
                } else {
                    if (maxBenefit < benefit) {
                        maxBenefit = benefit;
                    }
                    break;
                }
            }
        }

        return maxBenefit;

    }
}