using System;
class Solution {
    static void Main(string[] args) 
    {
        int[] A = new int[] {1, 2,2, 3,3, 4,4,4,4};

    }

    public int NumberSameOccur(int[] A) {
        var mp = new Dictionary<int, int>();

        int maxCountNum = 0;
        foreach (var i in A) {
            if (i>A.Length) continue;

            int curr = 1;
            if(!mp.ContainsKey(i)) {
                mp.Add(i, curr);
            }
            else {
                mp[i] = mp[i] + 1;
            }

            if(maxCountNum < i && i == mp[i]) {
                maxCountNum = i;
            }
        }

        return maxCountNum;

    }
}