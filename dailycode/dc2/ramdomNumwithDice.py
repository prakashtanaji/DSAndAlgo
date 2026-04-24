
from codecs import ignore_errors
import math
import random
from typing import final;
#from random import randint;

def getRandom(n):
    isNotGood = True;
    rand36 = 0;
    rand = random.randint(1,6)
    count = 1

    while isNotGood == True:

        if (6**count) > n:
            break;
        rand = rand*6; # 6, 12... 36
        rand = rand + random.randint(1,6)  # 7, 8 ... 42
        rand = rand - 6*count
        count+=1 # give range form 1 to 36

        print("Rand:");
        print(count)
        print(rand);
    return rand;


def calcRandom(n):
    isAccepted = False;
    finalRand = 0;
    while isAccepted == False:
        finalRand = getRandom(n);

        if finalRand <= n:
            isAccepted = True;
    return finalRand % n;
    

print(calcRandom(100))



        #rand * 6 -> 6, 12, 18, 24, 30 36
        # + rand 6    7, 8, 9 10, 11, 12, .....42
        # 42-6 =  1 - 36


        # > 30 ignore_errors

        #  1 - 30

        #  % 10




        #math.randrandom(1,6);
#         sum+=rand;
#     print(sum)
#     #sum ranges from 10 to 60
#                     # 11    59   
#     if sum == n*6: return 1;

#     return sum//6;

# print(getRandom(10))