def group_anagrams(words):
    dict = {}
    for word in words:

        hash = "".join(sorted(word))
        if hash not in dict:
            dict[hash] = []
        dict[hash].append(word)

    return list(dict.values())

if __name__ == "__main__":
    input_list = ["eat", "tea", "tan", "ate", "nat", "bat"]
    anagram_groups = group_anagrams(input_list)
    print(anagram_groups)  # Output: [['eat', 'tea', 'ate'],