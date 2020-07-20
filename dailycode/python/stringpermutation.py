str = "tesi"

print (str)

chrs = set(str)
print(chrs)

dt = {}

for c in str:
    dt[c] = dt.get(c,0) +1

sorted(dt)
print(dt)

op=''
l = len(str)

# tempSorted = dict.items()

# print (tempSorted)
# dictSorted = sorted(tempSorted)

# print (dictSorted)

def recurse(dict, s):
    if len(s) == l:
        print(s)
        return

    for c in sorted(dict.keys()):
        if dict[c] == 0 :
            continue
        dict[c] = dict.get(c) -1
        # s= s+c
        recurse(dict, s+c)
        dict[c] = dict.get(c) + 1
    # for k,v in dict:
    #     print(k,v)
    #     if v == 0 :
    #         continue
    #     dict[c] = v-1
    #     print('after',k,v)
    #     # s= s+c
    #     recurse(dict, s+c)
    #     dict[c] = v

recurse(dt, op)