#1:46 pm
#1:48 - prompt


def getParenType(c):
    if c in "{[(":
        return 1
    elif c in ")]}":
        return -1
    else:
        return 0

def isParenMatched(pairs, open_c, close_c):
    if pairs[open_c] == close_c:
        return True
    return False

def isValidParenthesis(s: str) -> bool:

    pairs = {'[':']', '{':'}', '(':')'}

    if len(s) % 2 == 1: return False

    st = []
    for ch in s:
        parenType = getParenType(ch) 
        if parenType == 0: # not valid 
            return False
        if parenType == 1:
            st.append(ch)
        else:
            if not isParenMatched(pairs, st.pop(-1), ch):
                return False
    
    if len(st)>0: return False

    return True


if __name__ == "__main__":
    cases = ["()", "()[]{}", "(]", "([)]", "","{})", "{{}"]
    for s in cases:
        print(f"{s!r}: {isValidParenthesis(s)}")
