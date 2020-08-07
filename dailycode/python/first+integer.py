
def getfirstpositive(nums) :
    oneFound = False
    for i,num in enumerate(nums):
        oneFound =oneFound or (num == 1)
        if num <=0:
            nums[i] = 1
    if oneFound == False : return 1

    print(nums)

    for i,numSig in enumerate(nums):
        num = abs(numSig)
        if num <len(nums) and num>=1:
            nums[num-1] = -1 * nums[num-1]
    print(nums)
    for i,num in enumerate(nums):
        if num >0: return i+1
    
    return len(nums) + 1

print('first missing positive is {1},{0}'.format(getfirstpositive([10,-10,10,-10]), 'test'))