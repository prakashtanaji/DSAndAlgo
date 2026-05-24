#arr = [3,2,7,8,3,5,7,9,1, -1, -3]

arr = [3,2,7,8,3,5,7,9,1, -1, -3, 56, 89, 1 , 4 , 2  ,3,6,3,7,4,3,2,65,7,9,9]
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

def mergeSort(arr, left, right):

    if left == right:
        return [arr[left]]#arr[left:right]

    mid = (int)((left+right)/2)

    leftArr = mergeSort(arr, left, mid)
    rightArr = mergeSort(arr, mid+1, right)

    return merge(leftArr, rightArr);

print(mergeSort(arr, 0, len(arr)-1))


