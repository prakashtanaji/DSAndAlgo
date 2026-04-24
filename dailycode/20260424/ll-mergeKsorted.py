mat = [[1,2,4],[2,5,8],[1,9]]

def merge(arr1, arr2):
    n1 = len(arr1)
    n2 = len(arr2)

    i =0; j=0;

    res = []

    while i<n1 and j<n2:
        if arr1[i] < arr2[j]:
            res.append(arr1[i])
            i+=1
        else:
            res.append(arr2[j])
            j+=1
    while i<n1:
        res.append(arr1[i])
        i+=1
    while j<n2:
        res.append(arr2[j])
        j+=1
    return res;

def mergeKSorted(mat, left, right):

    if left == right:
        return mat[left]

    
    mid = (int)((left+right)/2)

    left = mergeKSorted(mat, left, mid)

    right = mergeKSorted(mat, mid+1, right)

    return merge(left, right)

res = mergeKSorted(mat, 0, len(mat)-1)



import heapq;

def heapMerge(mat):

    n = len(mat)
    if n==0: return []

    if n ==1: return mat[0]

    #create minHeap
    heapMin = []
    for i in range(0,n):
        subLen = len(mat[i])

        if subLen >0:
            heapq.heappush(heapMin, (mat[i][0],i, 0))
    
    res = []
    while len(heapMin) :
        curr, i, j = heapq.heappop(heapMin)
        res.append(curr)

        if j+1 < len(mat[i]):
            heapq.heappush(heapMin, (mat[i][j+1], i, j+1))
    return res;


print(heapMerge(mat))



