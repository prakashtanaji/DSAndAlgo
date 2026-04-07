nums = [11, 2, 7, 0, 11, 15, -2, -3, 3, 3, 9, 6]
target = 9

def two_sum(nums, target):
    print(nums, target)
    found = {}
    result = []
    for i, num in enumerate(nums):
        complement = target - num
        if complement in found:
            result.append([complement, num])
        found[num] = i
    return result

#print(two_sum(nums, target))
if __name__ == "__main__":
    print(two_sum(nums, target))


