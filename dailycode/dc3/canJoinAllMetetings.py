def minMeetingRooms(start, end):

    #Naiveapproach

    n = len(start)

    room = 1
    res = 1

    for  i in range(n):
        room = 1
        for j in range(i+1, n):
           if  start[j]< end[i] and end[j]> start[i]:
               room+=1;
        res = max(res, room)
    return res;

def minMeetingRoomsTwoSort(start, end):

    n = len(start)

    start.sort();
    end.sort();

    room = 0;
    res = 0;

    i=0; j=0;


    while i<n and j<n:
        if start[i] < end[j]:
            room+=1;
            i+=1;
        else:
            room-=1;
            j+=1;
        res = max(res, room)
    return res;


if __name__ == "__main__":
    meetings = [[1,3],[2,6],[8,10],[15,18],[16,17]]
    start = [1,2,8,15,16,5]
    end =   [3,6,10,18,17,6]

    print(minMeetingRoomsTwoSort(start, end))

