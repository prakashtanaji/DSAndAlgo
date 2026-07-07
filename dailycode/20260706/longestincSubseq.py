from audioop import minmax


def lis(arr):
    if len(arr) <= 1:
        return len(arr)
    
    i, n = 0, len(arr)

    maxLen = 1;
    start = 1;

    while i <len(arr):
        if i+1< n and arr[i] < arr[i+1]:
            start +=1
            maxLen = max(start, maxLen)
        else:
            start = 1
        i+=1

    return maxLen;



def dfs(arr, curr, dp):
    print("counter")
    if dp[curr] != -1:
        return dp[curr]

    mx = 1;

    for prev in range(curr-1, -1, -1):
        if arr[prev] < arr[curr]:
            mx= max(mx, dfs(arr, prev, dp) + 1)
    
    dp[curr] = mx;

    return mx;

def lisCorrect(arr):
    maxLen = 1;
    n = len(arr)

    dp = [-1] * n
    dp[0] = 1

    for i in range(1,n):
        maxLen = max(maxLen, dfs(arr, i, dp))

    return maxLen;


if __name__ == "__main__":
    arr =  [30, 300, 200, 100, 35, 2, 45,67,34,3 ,3,5,6,7,7,3,4,5,4,3,5,6,4,4,5,6,4,4,4] # 4
    # res = lis(arr) # Incorrect
    res = lisCorrect(arr) # Correct
    print(res)