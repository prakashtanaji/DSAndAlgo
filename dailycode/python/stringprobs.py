import sys

def chReplace(s, l, r):
    return s[:l] + s[r:r+1] + s[l+1:]

def solveReduce(s, k) :
    l = 0
    r = 0
    count = 0
    while r < len(s):
        if count ==0 or s[l-1] != s[r]:
            s = chReplace(s, l, r) #s[l] = s[r]
            count = 1
            l+=1
        else :
            count += 1
            if count <= k:
                s = chReplace(s, l, r)
                l+=1
        r+=1
    return s[:l]

#print(solveReduce('xxxaabbbbqkjkjkjkjkkkkkjkkkkkeer', 2))

def solveReduce2(s, k):
    res = ['' for i in range(len(s))]
    l = 0
    r = 0
    count = 0
    while r < len(s):
        if count ==0 or res[l-1] != s[r]:
            res[l] = s[r]
            count = 1
            l+=1
        else :
            count += 1
            if count <= k:
                res[l] = s[r]
                l+=1
        r+=1
    return res[:l]


#res = solveReduce2('xxxaabbbbqkjkjkjkjkkkkkjkkkkkeer', 2)

#print(''.join(res))

###################################
charCount = 26

def getCharCount(s):
    res = [0 for i in range(charCount)]
    for c in s:
        iChar = ord(c)-97
        res[iChar] += 1
    return res

def reduce(maskAOrig, maskCount, s):
    maskA = [v for v in maskAOrig]
    res = ['' for i in range(len(s))]
    index = 0

    itIndex = 0
    for itIndex, c in enumerate(s):
        iChar = ord(c)-97
        if maskA[iChar] >0:
            maskA[iChar]-=1
            maskCount-=1
            if maskCount == 0: 
                break
        else :
            res[index] = c
            index +=1

    if maskCount == 0:
        return ''.join(res[:index]) + s[itIndex+1:]
    else :
        return s
    

def solveStrSetRemove(mask, s):
    maskA = getCharCount(mask)

    sPrev = s
    sRed = reduce(maskA, len(mask), sPrev)

    count = 0
    while len(sRed) != len(sPrev):
        count+=1
        sPrev = sRed
        sRed = reduce(maskA, len(mask), sPrev)
    return count

print("Number of iterations that can be removed = {}".format(solveStrSetRemove("apple", "ahkaplabjelepnhjhpajhjp")))

def solveStrSetRemove2(mask, s):
    maskA = getCharCount(mask)
    sArray = getCharCount(s)
    minCount = sys.maxsize
    for i, count in enumerate(maskA):
        if count >0:
            minCount = int(min(minCount, sArray[i]/maskA[i]))

    return minCount

print("Number of iterations that can be removed = {}".format(solveStrSetRemove2("apple", "ahkaplabjelenhjhpapjhjp")))
