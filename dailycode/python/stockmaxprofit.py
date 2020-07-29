price = [2,1,6,4,9,4]

def getMax1MoreTrans(price, mat, day, currK):
    maxProfit = 0
    for i in range(day, 0, -1) :
        maxProfit = max(maxProfit, mat[currK-1][i]+max(0,price[day-1]-price[i-1]))

    return maxProfit

def findNextPoint(mat, r, c):
    if mat[r][c-1] == 0: 
        return (0,c-1)
    while mat[r][c-1] == mat[r][c]:
        c=c-1
    while mat[r-1][c] == mat[r][c]:
        r=r-1
    return (r,c)

def buyday(price, startPrice, endPrice, stDay):
    for d in range(stDay-1, 1, -1):
        if price[stDay-1] - price[d-1] == startPrice - endPrice:
            return d

    return -1

def findDaysTransact(mat, k, price):
    days = []
    r,c = findNextPoint(mat, k, len(price))
    while r != 0 :
        days.append(c)
        bDay = buyday(price, mat[r][c], mat[r][c-1], c)
        days.append(bDay)
        r,c = findNextPoint(mat, r, c-1)

    return days


def maxProfit(price, k) :
    mat = [[0 for i in range(len(price)+1)] for j in range(k+1)]
    print(mat)

    for i in range(1, k+1):
        for j in range(2, len(price)+1):
            currMax = 0
            curMax  = max(mat[i][j-1], getMax1MoreTrans(price, mat, j, i))
            mat[i][j] = curMax
    
    print(mat)

    print(findDaysTransact(mat, k, price))


    return mat[k][len(price)]

print("Max profix is ", maxProfit(price, 3))




    