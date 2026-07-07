def twoSum(nums, target): # runtime = O(n**2) space = O(1)
    res = []

    n = len(nums)
    if n <=1:
        return res;

    for i in range(n):
        for j in range(i+1, n):
            if nums[i] + nums[j] == target:
                res.append((nums[i], nums[j]))  
    return res;

def twoSumOpt(nums, target): # runtime = O(n) space = O(n)
    seen = set()
    res = []
    n = len(nums)

    if n<=1:
        return res;

    for i in range(n):
        complement = target - nums[i]
        if complement in seen:
            res.append((nums[i], complement))
        seen.add(nums[i])

    return res;

    # seen = set()
    # for i in range(n):
    #     complement = target - nums[i]
    #     if complement in seen:
    #         res.append((nums[i], complement))
    #     seen.add(nums[i])
    # return res;

def twoSumSorted(nums, target): # runtime = O(nlogn) space = O(1)
    res = []
    n = len(nums)

    if n<=1:
        return res;
    nums.sort();

    #sorted(nums)

    i,j = 0, n-1

    while i<j:
        if nums[i] + nums[j] == target:
            res.append((nums[i], nums[j]))
            i+=1
            j-=1
        elif nums[i] + nums[j] < target:
            i+=1
        else:
            j-=1
    return res;


if __name__ == "__main__":
    nums = [2,2,7,2,11,2,15]
    res = twoSumSorted(nums, 9)
    print(res)
    print(nums)