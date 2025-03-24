class Solution {
    public int leastInterval(char[] tasks, int n) {
        int t=tasks.length;
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[1]-a[1]);
        int[] freq= new int[26];
        int[] idle= new int[26];
        for(char ch: tasks){
            freq[ch-'A']++;
        }
        int time=1;
        while(t>0){
            int maxFreq=0, idx=-1;
            for(int i=0;i<26;i++){
                if(freq[i]>maxFreq && time>=idle[i]){
                    idx=i;
                    maxFreq= freq[i];
                }
            }
            if(idx!=-1){
                // System.out.println("done "+idx+" "+ time+" "+freq[idx]);
                freq[idx]--;
                idle[idx]=time+n+1;
                t--;
                time++;
            }
            else{
                int minTime=(int)1e9; maxFreq=0;
                for(int i=0;i<26;i++){
                    if(freq[i]==0) continue;
                    if(idle[i]<minTime){
                        minTime= idle[i];
                        idx=i;
                        maxFreq= freq[i];
                    }
                    else if(idle[i]==minTime && freq[i]>maxFreq){
                        idx=i;
                        maxFreq= freq[i];
                    }
                }
                if(idx!=-1){
                    // System.out.println("done "+idx+" "+ time+" "+freq[idx]);
                    time= minTime;
                    freq[idx]--;
                    idle[idx]=time+n+1;
                    t--;
                    time++;
                }
            }
        }
        return time-1;
    }
}