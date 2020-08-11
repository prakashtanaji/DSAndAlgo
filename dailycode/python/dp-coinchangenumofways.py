import time

coins = [5,3,4]
total = 10

noOfWays = 0
#st = set()
res = []
def getways(coins, rem, arr) :
    if rem == 0:
        global noOfWays, res, st
        noOfWays +=1
        #st.add(arr.sort())
        res.append(arr[:])
        
    for c in coins:
        if rem-c>=0:
            arr.append(c)
            getways(coins, rem-c, arr)
            arr.pop()

# print(time.perf_counter())
# arr = []
# getways(coins, total, arr)
# print("No. of ways to give change", noOfWays)
# print(res)
#print(st)
# print(time.perf_counter())

def getwaysDP(coins, total):
    mat = [[0 for j in range(total+1)] for i in coins]
    for r in range(len(mat)):
        mat[r][0] = 1

    for c in range(len(mat[0])):
        if c > coins[0] and c % coins[0] == 0:
            mat[0][c] = 1

    for r in range(1, len(coins)) :
        for c in range(1,len(mat[0])):
            withoutCoin = 0
            if c-coins[r] >=0:
                withoutCoin = mat[r][c-coins[r]]
            mat[r][c] = mat[r-1][c] + withoutCoin
        [print(mat[i]) for i in range(len(mat))]

    return mat[len(coins)-1][total]

print("No. of ways to give change", getwaysDP(coins, total))

