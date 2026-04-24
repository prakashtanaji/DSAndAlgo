import math;
#Sieve method:

def primeSumSieve(n):
    isPrime = [True] * (n+1)

    isPrime[0] = isPrime[1] = False

    sum = 0

    # for i in range(2, (int)(n**0.5) + 1):
    for i in range(2, (int)(math.sqrt(n)) + 1):
        if isPrime[i] == True:
            # mark all mut+ltiples as not prime
            for j in range(i*i, n+1, i):
                isPrime[j] = False
    
    for i in range(n+1):
        if isPrime[i] == True:
            print(i);
            sum+= i

    return sum;

def primeSumSqrt(n):

    if n <=1: return 0;

    sum = 0
    for i in range(2,n+1):
        isPrime = True;
        for j in range(2, (int)(math.sqrt(i)) +1):
            if i%j == 0:
                isPrime = False
                break;
        if isPrime == True:
            sum+=i;

    return sum;


def primeSumSet(n):

    if n <=1: return 0;

    sum = 2
    st = {2}
    #st.add(2)
    for i in range(3,n+1):
        isPrime = True;
        for prm in st:
            if i%prm == 0:
                isPrime = False;
                break;
        if isPrime == True:
            st.add(i);
            sum+=i;

    return sum;

n = 1000
print(primeSumSieve(n));
print(primeSumSqrt(n));
print(primeSumSet(n));


