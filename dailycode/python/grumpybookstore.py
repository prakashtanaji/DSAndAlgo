#

grumpydays=[1,0,1,0,0]  #n
Updatedgrumpydays=[1,0,1,0,1] #n-k
cust=             [4,2,1,1,8] # n
#                      16
#                       +2 
k = 3
#  # => (n-k) * n


def happycusts(gdays, cust, k) :

    happyCust = 0
    for i in range(len(cust)) :
        happyCust += gdays[i]*cust[i]

    for d in range(k) :
        if gdays[d] == 0:
            happyCust += cust[d]

    maxDays = happyCust

    d = k
    while d < len(gdays) :
        if gdays[d] == 0 :
            happyCust += cust[d]
        if gdays[d-k] == 0 :
            happyCust -= cust[d-k]
        d+=1 
        maxDays = max(maxDays, happyCust)

    return maxDays

print(happycusts(grumpydays, cust, 3))
    
