class Solution {
public:
    int minMovesToSeat(vector<int>& seats, vector<int>& stud) {
        sort(seats.begin(), seats.end());
        sort(stud.begin(), stud.end());
        int totalMoves= 0;
        for(int i=0;i<(int)stud.size();++i){
            totalMoves+= abs(seats[i]-stud[i]);
        }
        return totalMoves;
    }
};