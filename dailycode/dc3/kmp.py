def lps(pattern):
    n = len(pattern)
    lps = [0]*n

    i = 0; j = 1;

    while j<n:

        seq = 0;

        if pattern[i] == pattern[j]:
            lps[j]=i+1
            i+=1; j+=1;
        else:
            if(i != 0):
                i=0;
            else:
                j+=1

    return lps;

def match(input, pattern, lps):
    n = len(input)
    i = 0; j = 0;

    matchCount = 0
    while i<n:
        if(input[i] == pattern[j]):
            
            matchCount+=1
            if(matchCount == len(pattern)):
                return i-matchCount+1;
            i+=1; j+=1;
        else:
            matchCount=0
            if j ==0:
                i+=1
            else:
                j = lps[j]-1
                if j<0: j = 0;
    return -1;





if __name__ == "__main__" : # ensure executed when invoked as a file not as as exported module
    pattern = "abc"
    input = "abdcebabacabcacababcd";

    if len(pattern)> len(input):
        print("No match");
        

    print(lps(pattern))

    print(match(input, pattern, lps(pattern)))

