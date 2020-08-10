calls = 0

def move(source, dest, temp, count) :
    global calls
    
    if count == 1:
        disc = source.pop()
        dest.append(disc)
        return
    calls+=1
    move (source, temp, dest, count-1)
    move (source, dest, temp, 1)
    move (temp, dest, source, count-1)

stSource = [10,9,8,7,6,5,4,3,2,1]
stDest = []
stTemp = []

def printStack(name, st) :
    print("Stack ", name)
    for val in st[::-1]:
        print(val)

printStack("Source", stSource)
printStack("Dest", stDest)
printStack("Temp", stTemp)

move(stSource, stDest, stTemp, len(stSource))

printStack("Source", stSource)
printStack("Dest", stDest)
printStack("Temp", stTemp)
print("Number of calls made{0}".format(calls))