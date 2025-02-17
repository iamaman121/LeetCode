class Solution {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        int n = pizzas.length;
        int oddDays= (n/4)/2+(n/4)%2, evenDays= (n/4)/2;
        int j=n-1;
        long ans = 0;
        while(oddDays-->0){
            ans+= pizzas[j--];
        }
        while(evenDays-->0){
            ans+= pizzas[j-1];
            j-=2;
        }
        return ans;
    }
}