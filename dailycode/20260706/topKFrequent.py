import heapq;

def topKFreq(nums, k):
    n = len(nums)

    if n == 0 or k <= 0:
        return []
    
    freq = {}
    for num in nums:
        freq[num] = freq.get(num, 0) + 1
    
    maxHeap = []
    for num, count in freq.items():
        maxHeap.append((-count, num)) 
        
    heapq.heapify(maxHeap)
    
    res = []
    for _ in range(k):
        res.append(heapq.heappop(maxHeap)[1])

    print(res)

topKFreq([1, 1, 1, 2, 2,2, 3,5,6,3,5,7,4,5,8,5], 2)


         # Use negative count for max-heap behavior