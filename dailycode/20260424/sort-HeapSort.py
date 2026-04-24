class HeapMin:
    def __init__(self):
        self.heap = []
    def push(self, val):
        self.heap.append(val);
        #heapify

        self.heapifyUp();


    def heapifyUp(self):
        curr = len(self.heap)-1;

        while curr !=0:
            parent = (int)((curr-1)/2)
            if self.heap[parent]> self.heap[curr]:
 
                self.swap(parent,curr)
                
                # temp = self.heap[parent]
                # self.heap[parent] = self.heap[curr]
                # self.heap[curr] = temp

                curr = parent
            else:
                break;


    def pop(self):
        if len(self.heap) == 0:
            return None;

        top = self.heap[0]

        self.heap[0] = self.heap[len(self.heap)-1]

        self.heap.pop(-1);

        curr = 0
        n = len(self.heap)
        while curr< n-1:

            leftIndex = curr*2+1; rightIndex = curr*2+2

            if leftIndex < n and rightIndex < n:
                if self.heap[leftIndex] >= self.heap[curr] and  self.heap[rightIndex] >= self.heap[curr]  :
                    break;
                elif self.heap[leftIndex] > self.heap[rightIndex]:
                    self.swap(rightIndex, curr)
                    curr = rightIndex
                else:
                    self.swap(leftIndex, curr)
                    curr = leftIndex
            elif leftIndex < n and self.heap[leftIndex] < self.heap[curr]:
                self.swap(leftIndex, curr)
                curr = leftIndex
            elif rightIndex < n and self.heap[rightIndex] < self.heap[curr]:
                self.swap(rightIndex, curr)
                curr = rightIndex
            else:
                break;

        return top;

                    
    def swap(self, i, j):
        temp = self.heap[i]
        self.heap[i] = self.heap[j]
        self.heap[j] = temp

    def size(self):
        return len(self.heap);


#Main

arr = [2 ,6,65,7,9,678,5]

hMin = HeapMin()

for i in range(0, len(arr)):
    hMin.push(arr[i])

print(hMin.heap)

res = []

while hMin.size() !=0:
    res.append(hMin.pop())

print(res)

