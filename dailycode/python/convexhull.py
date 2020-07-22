import sys

# st = []
# st.append(1)
# st.add(2)
# st.add(3)
# st.add(2)
# print(st)
# st.remove(2)
# print(st)
# if 4 in st:
#     print("found")
# print("end")

class Point:
    x =  0
    y = 0
    def __init__(self, _x, _y):
        self.x = _x
        self.y = _y

    def areSame(self, pt) :
        if pt is None : return False
        if self.x == pt.x and self.y == pt.y : return True
        return False

st = set()
st.add(Point(1,2))
st.add(Point(2,2))
st.add(Point(1,2))
print(st)
if Point(1,2) in st :
    print("found")

def getleftmost(points):
    lm = Point(sys.maxsize, sys.maxsize)
    lmIndex = len(points) -1
    for i in range(len(points)) :
        if points[i].x < lm.x :
            lm = points[i]
            lmIndex = i
    return lmIndex

def getNextPoint(points, onhull, st):
    if st == len(points): return -1

    for i in range(st, len(points)):
        if (i in onhull) is False:
            return i

    return -1

def getExternal(points, prev, curr1, curr2):
    pr = points[prev]
    c1 = points[curr1]
    c2 = points[curr2]
    val = ((pr.y- c2.y) * (pr.x- c1.x)) - ((pr.y- c1.y) * (pr.x- c2.x))
    if val > 0: return curr2 
    else : return curr1

def gethull(points) :
    lmIndex = getleftmost(points)

    onhull = set()
    onhull.add(lmIndex)
    prev = lmIndex

    #curr = None
    res = []
    first = True

    while lmIndex != prev or first == True :

        curr1 = getNextPoint(points, onhull, 0)
        curr2 = getNextPoint(points, onhull, curr1+1)
        while curr2 is not -1:
            curr1 = getExternal(points, prev, curr1, curr2)
            curr2 = getNextPoint(points, onhull, curr2+1)


        onhull.add(curr1)
        res.append(curr1)
        prev = curr1

        if first is True :
            onhull.remove(lmIndex)

        first = False
    
    return res

points = [Point(3,3),Point(0,0),Point(-1,1),Point(2,1),Point(1,1),Point(1,2),Point(0,2), Point(-1,-1), Point(2,2),Point(1,1),Point(2,0)]

res = []

if len(points) <=3: res = points
else: res = gethull(points)

for pt in res:
    print("({}, {})".format(points[pt].x,points[pt].y), end = " ")




