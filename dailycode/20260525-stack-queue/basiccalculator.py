def basiccalculator(s: str) -> int:

    tokens = lexer(s)

    print(tokens)

    return parser(tokens)

    return 0;


def parser(tokens):
    opStack = []

    for i in range (len(tokens)):
        if tokens[i] == ")":
            # Parse until prev "(" and add back to stack
            j = len(opStack)-1;
            subExp = []
            while (str)(opStack[j]) != "(" and j>=0:
                subExp.append(opStack.pop())
                j-=1
            opStack.pop()

            opStack.append(evalExp(subExp[::-1]))
        else:
            opStack.append(tokens[i])

    return evalExp(opStack)

def evaluate(subNumStack, subOpStack):
    if len(subNumStack) == 1: return

    num2 = (int)(subNumStack.pop())
    num1 = (int)(subNumStack.pop())
    optr = subOpStack.pop()

    res = 0
    if optr == "+": res = num1 +  num2
    elif optr == "-": res = num1 -  num2
    elif optr == "*": res = num1 *  num2
    elif optr == "/": res = (int)(num1 /  num2) 
    subNumStack.append(res)

def evalExp(exp):
    subOpStack = []
    subNumStack = []
    for i,token in enumerate(exp):
        if (str)(token) in "+-*/":
            subOpStack.append(token)
        else: #number
            subNumStack.append(token)
            if subOpStack and subOpStack[-1] in "*/":
                evaluate(subNumStack, subOpStack)
            elif subOpStack and  subOpStack[-1] in "+-":
                if (i != len(exp)-1 and exp[i+1] in "+-") or (i == len(exp)-1):
                    evaluate(subNumStack, subOpStack)


    evaluate(subNumStack, subOpStack)

    return subNumStack[0]

#def bc2(opStack):


def evalLast3(opStack):
    num2 = opStack.pop()
    optr = opStack.pop()
    num1 = opStack.pop()

    res = 0
    if optr == "+": res = num1 +  num2
    elif optr == "-": res = num1 -  num2
    elif optr == "*": res = num1 *  num2
    elif optr == "/": res = (int)(num1 /  num2) 
    opStack.append(res)

def lexer(s):
    tokens = []
    for ch in s:
        if ch == " ":
            continue
        if ch in "+-":
            if len(tokens) == 0 or tokens[len(tokens)-1] == "(":
                tokens.append(0)
            tokens.append(ch)
        else:
            tokens.append(ch)
    return tokens;


if __name__ == "__main__":
  cases = ["1 + 1", " 2-1 + 2 ", "(1+(-4+5+2)-3)+(6+8)", "(1+(-4+5*2))/3", "1+(-4+5*2)/3", "1+(-3+5*3*2)/3"] # notice unary operator
#   cases = ["(1+(-4+5*2))/3"] # notice unary operator
  for expr in cases:
    print(f"{expr!r}: {basiccalculator(expr)}")
