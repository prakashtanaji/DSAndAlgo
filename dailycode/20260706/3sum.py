def three_sum(nums): # runtime complexity: O(n^2), space complexity: O(n)
    nums.sort()  # Sort the input list
    result = []
    n = len(nums)

    for i in range(n - 2):
        if i > 0 and nums[i] == nums[i - 1]:
            continue  # Skip duplicates for the first number

        left, right = i + 1, n - 1
        while left < right:
            total = nums[i] + nums[left] + nums[right]
            if total < 0:
                left += 1
            elif total > 0:
                right -= 1
            else:
                result.append([nums[i], nums[left], nums[right]])
                while left < right and nums[left] == nums[left + 1]:
                    left += 1  # Skip duplicates for the second number
                while left < right and nums[right] == nums[right - 1]:
                    right -= 1  # Skip duplicates for the third number
                left += 1
                right -= 1

    return result
if __name__ == "__main__":
    nums = [-1, 0, 1, 2, -1, -4]
    result = three_sum(nums)
    print(result)  # Output: [[-1, -1, 2], [-1, 0, 1]]