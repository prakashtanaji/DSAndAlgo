
import time

def calcMaxRect(tmp) -> int :
    print(tmp)
    maxVal = 0
    st = []
    st.append(0)
    index = 1
    while index < len(tmp) :
        # print ("index ", index)
        topIndex = st[-1]# st[len(st)-1] # stack peek ?
        print(topIndex)
        # print(len(st))
        if tmp[index] >= tmp[topIndex] :
            print ("appending", index)
            st.append(index)
        else :
            while topIndex != -1 and tmp[index] < tmp[topIndex]:
                maxVal = max(maxVal, (index-topIndex)*tmp[topIndex])
                print(st)
                st.pop()
                print("after pop")
                print(st)
                #break
                if len(st) == 0:
                    print (" st len is 0")
                    topIndex = -1
                    continue
                print (" st len is not 0")
                #time.sleep(2)
                topIndex = st[len(st)-1]

            print ("append", index)
            st.append(index)
            print('stack', st)
        index = index + 1
    
    print(st)
    while len(st) > 0 :
        topIndex = st.pop()
        if len(st) == 0:
            maxVal = max(maxVal, index*tmp[topIndex])
        else :
            maxVal = max(maxVal, (index-st[-1]-1)*tmp[topIndex])    

    print('returning', maxVal)
    return maxVal

arr =[[1,0,1,0],
     [1,0,1,0],
     [0,1,0,1],
     [1,0,1,1]]

tmp = []

maxSize = 0

for m in range(0,len(arr)):
    if m == 0 :
        tmp = arr[m]
    else :
        for n in range(0,len(arr[0])):
            print(m,n)
            if arr[m][n] == 0:
                tmp[n] = 0
            else:
                tmp[n] = tmp[n] + 1
    
    print("     ", tmp)
    maxSize = max(maxSize, calcMaxRect(tmp))

print('max rect size is ', maxSize)