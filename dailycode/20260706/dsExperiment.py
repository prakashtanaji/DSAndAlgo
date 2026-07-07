if __name__ == "__main__":




    mat = [[0 for i in range(5)] for i in range(5)]

    mat = [
        [0,1,0,0,1,1],
        [0,0,1,0,1,1],
        [0,1,0,0,0,0],
        [0,1,0,0,1,1],
        [0,1,0,0,1,1]
        ]

    def getAdjLand(mat, i,j):

        maxRows = len(mat)
        maxCols = len(mat[])
        allSides = [(i-1,j-1),(i-1,j),(i-1,j+1),
                    (i,j-1),          (i,j+1),
                    (i+1,j-1),(i+1,j),(i+1,j+1)]

        validCood = []
        for land in allSides:
            if land[0] >=0 and land<maxRows and \
                land[1] >=0 and land<maxCols and \
                mat[land[0],land[1]] == 1:
                validCood.append(land)
        return validCood;
        


    print(mat)



#List
    # lst = [1,2,3,4,5]
    # lst1 = lst

    # print(lst1)
    # print(lst1[-2])
    # # lst.pop()
    # # print(lst)

    # #print(lst.pop(0))
    # #print(lst)

    # # lst.sort(reverse=True)
    # # print(lst)

    # # for i,j in enumerate(lst):
    # #     print(i,j)

    # print(lst)
    # print(lst[::-1])
    # print(lst[1:-2])
    # print(lst[:3])

    







#Dictionary
    # hp = {"three": "val3", "four": "val4"}
    # hp["one"] = "val1"
    # hp["two"] = "val2"
    # print(hp)
    # hp.pop("two")
    # print(hp)
    # print(hp.get("three"))
    # print(hp.get("five", 0))

#Set

    # st = set()
    # st.add(5)
    # st.add(10)
    # print(st)
    # st.remove(5)
    # print(st)
    # print(len(st))

    # st.add(25)
    # st.add(35)
    # st.add(15)
    # print(st.pop())

    # lst = list(st)
    # print("my List item: ", lst)
    # lst.append(25)
    # st = set(lst)
    # print(st)
