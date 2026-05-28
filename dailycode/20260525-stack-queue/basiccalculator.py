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
            j = i-1;
            subExp = []
            while tokens[j] != "(":
                subExp.append(opStack.pop())
                j-=1
            opStack.pop()

            opStack.append(evalExp(subExp))
        else:
            opStack.append(tokens[i])

    evalExp(opStack)

    return opStack[0]

def evalExp(exp):
    subOpStack = []
    for i,token in enumerate(exp):
        if token in "+-*/":
            subOpStack.append(token)
        else: #number
            if subOpStack and subOpStack[-1] in "*/":
                subOpStack.append(token)
                evalLast3(subOpStack)
            elif subOpStack and  subOpStack[-1] in "+-":
                if i != len(exp)-1 and exp[i+1] in "+-":
                    subOpStack.append(token)
                    evalLast3(subOpStack)
    return subOpStack[0]

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
  cases = ["1 + 1", " 2-1 + 2 ", "(1+(-4+5+2)-3)+(6+8)"] # notice unary operator
  for expr in cases:
    print(f"{expr!r}: {basiccalculator(expr)}")
