def duplicates(arr):
    # TODO: implement — each value is in [0, n) where n = len(arr)
    n = len(arr)

    for i in range(n):
        index = arr[i]% n
        arr[index] +=n
    
    res = []

    for i in range(n):
        if (arr[i]// n) >=2:
            res.append(i)


    return res
if __name__ == "__main__":
    # n = 6; every value is < n
    arr = [1, 3, 5, 2, 2, 5]
    res = duplicates(arr)
    for idx in res:
        print(idx)