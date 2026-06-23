import sys
import time

prices = [2,3,1,9,4,1]
n = 16
maxArr = [0 for i in range(n+1)]
print(maxArr)

def maxProfitRecursion(prices, remLength):
    global maxArr
    #if remlength == 0 return 0
    maxVal = 0
    minRange = min(len(prices), remLength)
    for i in range(minRange):
        maxVal = max(maxVal, prices[i] + maxProfitRecursion(prices, remLength-i-1))
    maxArr[remLength] = max(maxVal,maxArr[remLength])
    return maxVal

print(time.perf_counter())
res = maxProfitRecursion(prices, n)
print("max profit from rod of length {0} is {1}".format(n, res))
print(time.perf_counter())
#print(maxArr)


arr = []
def maxProfitImproved(prices, lenOfRod) :
    global arr
    arr= [0 for i in range(lenOfRod+1)]
    for i in range(1,lenOfRod+1):
        maxVal = 0
        for b in range(min(i,len(prices))):
            maxVal = max(maxVal, prices[b] + arr[i-b-1])
        arr[i]= maxVal
    return arr[lenOfRod]

res = maxProfitImproved(prices, n)

print("max profit from rod of length {0} is {1}".format(n, res))
print(time.perf_counter())
print(arr)