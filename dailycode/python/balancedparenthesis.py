
# def recurse(arr, l, r, n) :
#     if r == n:
#         print("".join(arr))
#         return
#     if l==n or l>r:
#         arr.append(')')
#         recurse(arr,l, r+1,n)
#         arr.pop()
#     if l!=n:
#         arr.append('(')
#         recurse(arr,l+1, r,n)
#         arr.pop()

# n= 3
# ar = []
# recurse(ar, 0,0,3)


class Parenthesis:
    opening=['(','[','{','<']
    closing=[')',']','}','>']

    def __init__(self, arr):
        self.arr = arr
    
    def isOpening(self, curr) :
        brace = self.arr[curr]
        for c in self.opening[::-1]:
            if brace == c: 
                return True
        return False

    def getClosingIndex(self, brace) :
        for i, c in enumerate(self.closing):
            if brace == c: 
                return i
        return -1
    
    def isBalanced(self):
        st = []
        if len(self.arr) == 0: 
            return True

        if len(self.arr) % 2 !=0: 
            return False

        for i,c in enumerate(self.arr):
            if self.isOpening(i):
                st.append(c)
            else :
                closingIndex = self.getClosingIndex(c)
                if closingIndex == -1 or st.count == 0: 
                    return False
                top =  st.pop()
                if top != self.opening[closingIndex]: 
                    return False
        stSize = len(st)
        return stSize == 0

paren = Parenthesis("{<{}[()()]>{}}") #Parenthesis("") #
res = paren.isBalanced()

print("the parenthesis are balanced?:", res)