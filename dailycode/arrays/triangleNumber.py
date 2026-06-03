def triangleNumber(nums):
    # Your code goes here
    res = []
    for i in range(len(nums)-2):
        for j in range(i+1, len(nums)-1):
            for k in range(j+1, len(nums)):
                if isTriangle(nums[i], nums[j], nums[k]):
                    res.append([nums[i], nums[j], nums[k]])
    return res;


def isTriangle(a, b, c):
    if a+c > b and a+b> c and b+c > a:
        return True
    return False

res = triangleNumber([2,5,3,4,0,1])
print(res)