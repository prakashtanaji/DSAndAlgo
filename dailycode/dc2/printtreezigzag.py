class TreeNode:
    def __init__(self, val=0, left =None, right = None):
        self.val = val
        self.left = left
        self.right = right
    
    val = None
    left = None
    right = None
    def print(self):
        print( self.val + " ")

def print ZigZag(TreeeNode root):

    queue = []
    queue.append(root)

    level = 0

    while queue != None :

        stk = []
    
        while queue !=None:
            node = queue.pop(0)
            node.print()

            if level % 2 == 0: # parse L to R
                stk.append(node.left)
                stk.append(node.right)
            else:
                stk.append(node.right)
                stk.append(node.left)
            
            queue = stk;
        level++

if __name__ == "__main__":
    TreeeNode r = TreeeNode(1)
    r.left = TreeeNode(2)
    r.right = TreeeNode(3)
    r.left.left = TreeeNode(4)
    r.left.right = TreeNode(5)
    r.right.left = TreeeNode(6)
    r.right.right = TreeeNode(7)
    ZigZag(r)




#          1                               level 0  if level 0 L -> R ot R L
#        2       3   L-> R
#     4    5   6   7 L<-R

#     8  9   10  11    L-> R

    

#     o/p: 1 2 3 7 6 5 4

#     q -  1                      1

#     st 2 ,3  -> q - 3, 2

#                                3   2

#     st - 7   6     5    4   ->  Q= 4,5,6,7  
    
    
#                                 4 , 5 6 7
                                
# st :    8 9 10 11   Q =  11, 10, 9, 8  11






