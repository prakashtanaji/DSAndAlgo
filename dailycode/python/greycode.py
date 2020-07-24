n = 3

def getbinary(num, mask):
    res = bin(num | 1<<mask)
    return res[3:]

def greycode(n) -> [] :
    curr = 0
    mask = 1
    shiftDir = 1

    op = []
    for i in range(2**n) :
        op.append(getbinary(curr, n))

        curr = curr ^ mask
        if shiftDir == 1:
            mask = mask << 1
        if shiftDir == 0:
            mask = mask >> 1

        if mask == 1 << n-1:
            shiftDir = 0
        elif mask == 1:
            shiftDir = 1

    return op

print(greycode(n))
