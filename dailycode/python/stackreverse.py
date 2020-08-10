

def printStack(name, st) :
    print("Stack ", name)
    for val in st[::-1]:
        print(val)
# st = [1,2,3,4]
# printStack("initial", st)

# st.reverse()
# printStack("after", st)


def reverse(st):
    if len(st) == 0:
        return
    temp = st.pop()
    reverse(st)
    insertAtBottom(st,temp)

def insertAtBottom(st, item):
    if len(st) == 0:
        st.append(item)
    else:
        tmp = st.pop()
        insertAtBottom(st, item)
        st.append(tmp)

st = [1,2,3,4]
printStack("initial", st)

reverse(st)
printStack("after", st)