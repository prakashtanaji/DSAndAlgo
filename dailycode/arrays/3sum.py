def threeSum(nums):
    if len(nums) <=2:
        return []
    
    res = []
    #return res;

    # for i in range(0,len(nums)-2):
    #     for j in range(i+1, len(nums)-1):
    #         for k in range(j+1, len(nums)):
    #             sum = nums[i] + nums[j] + nums[k]
    #             if sum == 0:
    #                 res.append([nums[i], nums[j], nums[k]])

    nums.sort()
    
    for i in range(len(nums)-2):
        if i> 0 and nums[i] == nums[i-1]:
            continue

        left = i+1
        right = len(nums)-1
        while left < right:
            sum = nums[i] + nums[left] + nums[right]
            if sum < 0:
                left += 1
            elif sum > 0:
                right -= 1
            else:
                res.append([nums[i], nums[left], nums[right]])
                while left < right and nums[left] == nums[left+1]:
                    left += 1
                while left < right and nums[right] == nums[right-1]:
                    right -=1
                left += 1
                right -= 1
    return res;


if __name__ == "__main__":
    nums = [-1,0,1,2,-1,-4]
    print(threeSum(nums))