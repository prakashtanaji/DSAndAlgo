arr = [2,3,1,3,2]

rangearr = [0] * len(arr)*2-1
print(arr)

for i in range(len(arr)) :
    rangearr[i+len(arr)] = arr[i]

print(rangearr)