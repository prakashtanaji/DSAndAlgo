nums = [1,2,3,4]
ln = len(nums)

def getmask(num:int) -> str :
    res = bin(num|1<<ln)
    return res[3:]

def getComb(nums) -> [[]] :
    output = []
    for n in range(2**len(nums)) :
        mask = getmask(n)
        curr = []

        for i in range(len(mask)):
            if mask[i] == '1' :
                curr.append(nums[i])
        output+=[curr]

    return output

print("list of combinations are ", getComb(nums))