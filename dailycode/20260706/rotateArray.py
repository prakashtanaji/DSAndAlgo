

def rotateArrSimple(arr, k):

    n = len(arr)
    k = k%n

    print(arr[n-k:])
    print(arr[:n-k])

    return arr[n-k:] + arr[:n-k]

def rotateArrLoop(arr, k):
    n = len(arr)
    k = k%n

    res = [-1] * n
    for i,num in enumerate(arr):
        toIndex = (i+k)%n
        res[toIndex] = num
    return res;


input = [1,2,3,4,5,6,7,8]
print(rotateArrLoop(input, 8))