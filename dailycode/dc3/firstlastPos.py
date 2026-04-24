
def findFirst(nums, target):
    i = 0; j = len(nums)-1;
    res = 100
    while i<=j: # [4,5,6,7,0,1,2]
        mid = (i+j)//2;
        if nums[mid] == target:
            res = min(res, mid)
            j = mid-1;
        # go left 
        elif nums[i] <= nums[mid]  and (target >= nums[i] and target < nums[mid]):
            j = mid-1;
        # go right
        elif nums[mid] <= nums[j] and (target > nums[mid] and target <= nums[j]):
            i = mid+1;
        elif nums[i] <= nums[mid]:
            i = mid+1;
        else:
            j = mid-1;
    return res;

def findLast(nums, target):
    i = 0; j = len(nums)-1;
    res = -1
    while i<=j: # [4,5,6,7,0,1,2]
        mid = (i+j)//2;
        if nums[mid] == target:
            res = max(res, mid)
            i = mid+1;
        # go right
        elif nums[mid] <= nums[j] and (target > nums[mid] and target <= nums[j]):
            i = mid+1;
        # go left 
        elif nums[i] <= nums[mid]  and (target >= nums[i] and target < nums[mid]):
            j = mid-1;
        elif nums[mid] <= nums[j]:
            j = mid-1;
        else:
            i = mid+1;
    return res;


if __name__ == "__main__":
    input = [3, 4,5,6,7,10,13,18,25,0,1,3,3]
    target = 3;
    print(findFirst(input, target))
    print(findLast(input, target))
