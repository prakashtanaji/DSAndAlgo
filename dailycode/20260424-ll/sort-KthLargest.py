arr = [3,5,7,2,3,6,7,9,7,5]
k = 2

#2:47

def findKthHighest(arr, k):

    if len(arr) < k or k ==0:
        return None;

    left = 0;
    right = len(arr)-1;
    pivotPos = QPivot(arr, left, right-1, right);

    while pivotPos != k-1:
        if k>pivotPos:
            pivotPos = QPivot(arr,pivotPos+1, right-1, right);
        else:
            pivotPos = QPivot(arr,left, pivotPos-1-1, pivotPos-1);

    return arr[k-1]
    
def QPivot(arr, left, right, pivot):
    i = left; j = left;

    while j<pivot:
        if arr[j]>=arr[pivot]:
            #swap(i,j)
            temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp

            i+=1
            j+=1
        else:
            j+=1

    temp = arr[i]
    arr[i] = arr[pivot]
    arr[pivot] = temp

    print(arr)

    return i;

print(findKthHighest(arr, k))
    

