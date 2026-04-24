arr1 = [1,3,5,5,7,9,10]
arr2 = [4,5,5,6,7,9,11]
arr3 = [1,3,5,5,7,9,15]

def ThreecommonArray(arr1,arr2,arr3):

    n1 = len(arr1);n2 = len(arr2);n3 = len(arr3)

    if n1==0 or n2==0 or n3==0:
        return []
    
    i=0;j=0;k=0;

    res = {}
    while i<n1 and j<n2 and k<n3:
        if arr1[i] ==arr2[j] and arr1[i] ==arr1[k]:
            res[arr1[i]] = res.get(arr1[i], 0) +1
            #res.append(arr1[i])
            i+=1;j+=1;k+=1

        elif arr1[i] <= arr2[j] and arr1[i] <= arr3[k] :
            i+=1
        elif arr2[j] <= arr3[k] and arr2[j] <= arr1[i]:
            j+=1
        else:
            k+=1
    
    print(res.values());

    for k,v in res.items():
        print(k,"-")

    res.pop(k-2)

    for k,v in res.items():
        print(k,"-")

ThreecommonArray(arr1,arr2,arr3);