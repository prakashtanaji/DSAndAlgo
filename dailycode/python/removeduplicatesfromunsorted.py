def removedup(nums) :
    st = []
    curr = 1
    st.append(nums[0])

    for i in range(1, len(nums)):
        if nums[i] not in st:
            nums[curr] = nums[i]
            st.append(nums[i])
            curr+=1
    return nums[:curr]

def removedupcompletely(nums) :
    st = set()
    stres = []
    # stres.append(nums[0])
    # st.append(nums[0])

    for i in range(len(nums)):
        if nums[i] in st:
            # ind = stres.index(nums[i])
            # if ind is not None:
            if nums[i] in stres:
                stres.remove(nums[i])
        else:
            st.add(nums[i])
            stres.append(nums[i])
    return stres

nums = [1,1,1,5,2,3,3,5,4,6,8,4,9,3,4,2,1,6,2,9,10,1,8,9]
#print(removedup(nums))
print(removedupcompletely(nums))

