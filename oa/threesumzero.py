nums = [14, 5, 79, 0 ,-3,- 11, 15, -2, -3, 3, 3, 9, 6]
target =0;

# Time O(n2), space O(n2)
def two_sum_map():
    twosummap = {}
    for i in range(len(nums)):
        for j in range(i + 1, len(nums)):
            s = nums[i] + nums[j]
            if s in twosummap:
                twosummap[s].append((i, j))
            else:
                twosummap[s] = [(i, j)]

    print(twosummap)
    return twosummap

# Used the two summap to find pairs that sum to the target minus the current number. This will run in O(n2) + O(n) time and O(n2) space.
def three_sum():
    two_sum_map_result = two_sum_map()
    res = set();
    for i, num in enumerate(nums):
        if -num in two_sum_map_result:
            for pair in two_sum_map_result[-num]:
                if i not in pair:
                    res.add(tuple(sorted([num, nums[pair[0]], nums[pair[1]]])))
                    print("Found three pair :" + str(num) + ", " + str(nums[pair[0]]) + ", " + str(nums[pair[1]]))
    print(res)
print(three_sum())

# This will run in O(nlogn) + O(n2), time space O(1) by using two pointers to find pairs that sum to the target minus the current number. This will run in O(n2) time and O(1) space.
def three_sum_no_duplicates():
    nums.sort()
    for i, num in enumerate(nums):
        if i>0 and nums[i] == nums[i-1]:
            continue
        j = i+1
        k = len(nums)-1
        while j<k:
            if j>i+1 and nums[j] == nums[j-1]:
                j += 1
                continue
            if k<len(nums)-1-1 and nums[k] == nums[k+1]:
                k -= 1
                continue
            s = num + nums[j] + nums[k]
            if s == target:
                print("Found three sum :" + str(num) + ", " + str(nums[j]) + ", " + str(nums[k]))
                j += 1
                k -= 1
            elif s < 0:
                j += 1
            else:
                k -= 1
        
#three_sum_no_duplicates()