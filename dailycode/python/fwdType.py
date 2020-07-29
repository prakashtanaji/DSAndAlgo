from typing import List

class Node:

    
    def __init__(self):
        self.value = None
        self.isvalid = False
        for i in range(26):
            self.subNodes = [None for _ in range(26)]
    
    def preOrderIterative(self, k) :
        
        res = []
        if k == 0 : return res
        
        currK = k
        st = []
        st.append(self)
        
        #currK -=1
        
        while len(st) > 0:
            curr = st.pop()
            if curr.isvalid == True:
                res.append(curr.value)
                currK -=1
            
            if currK == 0: break
            
            for i in range(25, -1,-1):
                if curr.subNodes[i] != None:
                    st.append(curr.subNodes[i])
        
        return res
                    
    def add(self, word:str, pos):
        if pos == len(word):
            self.value = word
            self.isvalid = True
        else:
            cIndex = ord(word[pos:pos+1])-97
            if self.subNodes[cIndex] == None:    
                self.subNodes[cIndex] = Node()
            
            self.subNodes[cIndex].add(word, pos+1)
    
    def goToSbStr(self, word:str, pos:int) :
        if pos == len(word):
            return self
        cIndex = ord(word[pos:pos+1])-97
        if self.subNodes[cIndex] == None: 
            return None
        else:
            return self.subNodes[cIndex].goToSbStr(word, pos+1)
        
            
    
class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        k=3
        # create a trie 
        trie = Node()

        for word in products:
            trie.add(word, 0)

        res = []

        for i in range(len(searchWord)):
            subWord = searchWord[:i+1]
            curr = trie.goToSbStr(subWord, 0)
            if curr != None:
                res1:List[str] = curr.preOrderIterative(k)
                res.append(res1)

        return res
        

if __name__ == "__main__":
    prods =  ["mousepad","moneypot","monitor","m","ma"]
    word = "a"
    sol = Solution()
    res = sol.suggestedProducts(prods, word)
    print(res)
