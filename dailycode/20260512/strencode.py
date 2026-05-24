def encode(s):
    encoded_str = "";
    for str_Val in s:
        strLenEncode = constLenEncode(str_Val);
        strStringEncode = constStringEncode(str_Val);
        encoded_str += strLenEncode + strStringEncode;
    return encoded_str;

def constLenEncode(str_Val):
    return "$"+str(len(str_Val)) + "$";


def constStringEncode(str_Val):
    return str_Val[::-1];
    # 65 = "A", 97= "a" ord(c)-97 gives the index of the character in the alphabet chr(c) will give the character for example 
    # ord('A') = 65, ord('a') = 97
    # ord('A')-97 = 0, ord('a')-97 = 0
    # ord('B')-97 = 1, ord('b')-97 = 1
    # ord('C')-97 = 2, ord('c')-97 = 2
    # ord('D')-97 = 3, ord('d')-97 = 3
    # ord('E')-97 = 4, ord('e')-97 = 4
    # ord('F')-97 = 5, ord('f')-97 = 5
    # ord('G')-97 = 6, ord('g')-97 = 6

def decode(s):
    res = []
    i=0;
    while i<len(s):
        st, end = getEncodedStringStrtAndEnd(i, s);
        print(i, len(s))
        print(st, end)
        if st == -1 or end > len(s):
            print("Cannot decode");
            break;
        decode_str_section = "".join((reverse(s,st,end)));
        res.append(decode_str_section);
        i = end+1
    return res;

def reverse(s, st, end):
    res = ['']*(end-st+1);

    if st>end or end>= len(s):
        return "ERROR";
    i = 0
    while end >=st:
        res[i]=s[end];
        i+=1;
        end-=1

    return res;



def getEncodedStringStrtAndEnd(i, s):
    if s[i] != '$':
        return -1, -1;
    
    st = i+1;
    len = 0;
    while s[st] != '$':
        len = len*10 + int(s[st]);
        st+=1;
    end = st + len;
    
    return st+1, end;

if __name__ == "__main__":                  
    s = ["Redmond", "Seattle", "$7$", "Seattle","Redmond", "Seattle"];
    encoded_str = encode(s);
    print(encoded_str);
    decoded_str = decode(encoded_str);
    print(decoded_str);
