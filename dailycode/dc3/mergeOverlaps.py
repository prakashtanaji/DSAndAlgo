def mergeIntervals(intervals):
    n = len(intervals)

    intervals.sort();
    res = []

    for i in range(n):
        start = intervals[i][0];    
        end = intervals[i][1];

        # handle for the case of the new intrernal is alraedy in the prev res
        if res and  end<=res[-1][1]:
            continue;

        for j in range(i+1, n):
            if end> intervals[j][0]:
                end = max(end, intervals[j][1])
        res.append([start, end])

    return res;

def isOverlap(int1, int2):
    if int1[0] <= int2[0] < int1[1] or ( int2[0]<= int1[0] and int2[1] > int1[0]):
        return True
    return False;
def mergeIntervalsnLogn(intervals):
    n = len(intervals)

    if n==0 or n == 1:
         return intervals;

    intervals.sort();
    res = [intervals[0]]

    for i in range(1, n):
        if isOverlap(res[-1], intervals[i]):
            res[-1][1] = max(res[-1][1], intervals[i][1])
        else:
            res.append(intervals[i])


    return res;

if __name__ == "__main__":
    intervals = [[1,3],[2,6],[8,10],[15,18],[16,17]]
    print(mergeIntervalsnLogn(intervals))

