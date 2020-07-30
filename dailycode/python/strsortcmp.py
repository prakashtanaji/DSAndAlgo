#import sys

#print (sys.version)
from functools import cmp_to_key 

def isStr(input):
    try :
        value = int(input)
    except ValueError :
        return True
    return False

def reverse_numeric(x, y):
    xStr = isStr(x[1])
    yStr = isStr(y[1])
    if xStr != yStr:
        if xStr: 
            return -1
        else : 
            return 1
    if xStr == False:
        return 0
    if x[1] == y[1]:
        return x[0] - y[0]
    else:
        if x[1] <= y[1]: return -1
        else : return 1
    
res = sorted([[5,'apple'], [90, 678],[2, 'orange'], [4,'apple'], [1, 3]], key=cmp_to_key(reverse_numeric))
print(res)

# A function that returns the length of the value:
#def myFunc(e1,e2):
#  return e1[1] > e2[1]

cars = ['Ford', 'Mitsubishi', 'BMW', 'VW']

#cars = sorted(cars, cmp=myFunc)

print(cars)
