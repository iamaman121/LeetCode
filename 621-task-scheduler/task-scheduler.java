class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq= new int[26];
        for(char ch: tasks){
            freq[ch-'A']++;
        }
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++){
            if(freq[i]>0) pq.add(freq[i]);
        }
        int time=0;
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<=n;i++){
                if(!pq.isEmpty()){
                    temp.add(pq.remove());
                }
            }
            for(int cnt:temp){
                if(--cnt>0) pq.add(cnt);
            }
            time+=pq.isEmpty()?temp.size():n+1;
        }
        return time;
    }
}