def find(nums, target):
    i = 0; j = len(nums)-1;
    while i<=j: # [4,5,6,7,0,1,2]
        mid = (i+j)//2;
        if nums[mid] == target:
            return mid; 
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



if __name__ == "__main__":
    input = [4,5,6,7,10,13,18,25,0,1,3]
    target = 13;
    print(find(input, target))
