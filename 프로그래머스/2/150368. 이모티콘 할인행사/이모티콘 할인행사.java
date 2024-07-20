class Solution {
    static int[] discount = {10,20,30,40};
    static int maxOfSubscribe;
    static int maxOfCost;
    public int[] solution(int[][] users, int[] emoticons) {
        findResult(0,emoticons.length, new int[emoticons.length],users,emoticons);
        return new int[]{maxOfSubscribe,maxOfCost};
    }

    public void findResult(int index,int emoticonsLength, int[] discounts,int[][] users, int[] emoticons){
        if (index == emoticonsLength){
            int subscribe = 0;
            int cost = 0;

            for (int[] user: users){
                int userDiscountRate = user[0];
                int userMaxCost = user[1];

                int sum = 0;

                for (int i = 0; i < emoticons.length; i++){
                    if (discounts[i]>=userDiscountRate){
                        sum += emoticons[i]/100*(100-discounts[i]);
                    }
                }
                if (sum>=userMaxCost)subscribe++;
                else cost+=sum;
            }
            if (subscribe>maxOfSubscribe){
                maxOfSubscribe = subscribe;
                maxOfCost = cost;
            }else if (subscribe == maxOfSubscribe){
                maxOfCost = Math.max(maxOfCost,cost);
            }
            return;
        }
        for (int i = 0; i < 4; i++){
            discounts[index] = discount[i];
            findResult(index+1,emoticonsLength,discounts,users,emoticons);
        }
    }
}