arr = [3,2,7,8,3,5,7,9,1]


def qSort(arr, pivot, left, right):

    if left >= right :
        return
    i = left; j = left;

    while j< right:
        if arr[j] > arr[pivot]:
            j+=1
        else:
            #swap
            temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp

            i+=1
            j+=1
    temp = arr[pivot]
    arr[pivot] = arr[i]
    arr[i] = temp

    qSort(arr, i-1, left, i-1)
    qSort(arr, right, i+1, right)

qSort(arr, len(arr)-1,0, len(arr) -1)

print(arr)