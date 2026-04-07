import sys;

s1 = "abcba"
s2 = "aabbc"
print(s1)
print(s2)

if len(s1) != len(s2):
    print("Not anagrams")
    exit(0)

# directly implementing the most optimized solution using the array not hashmap
freq = [0] * 26
for ch in s1:
    ch0Index = ord(ch) - ord('a')
    freq[ch0Index] +=1

for ch in s2:
    ch0Index = ord(ch) - ord('a')
    if(freq[ch0Index]==0):
        print ("Not anagrams1")
        sys.exit(0)
    freq[ch0Index] -=1

print("Anagrams")