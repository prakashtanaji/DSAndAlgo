from typing import List
class Solution:
    
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        d = {}
        for i in range(len(nums)):
            n = nums[i]
            if self.isInRange(d, n, t): return True
            d[n]= d.get(n,0)+1
            if i - k >=0:
                nAtK = nums[i-k]
                if d.get(nAtK) == 1: d.pop(nAtK)
                else : d[nAtK]= d.get(nAtK)-1
            
        return False

    def isInRange(self, dt, num, t):
        for n in range(num-t, num+t+1):
            if n in dt: return True
        return False


sol = Solution()
print("the result is {0}".format(sol.containsNearbyAlmostDuplicate([5,10,3,8], 1, 1)))
    
