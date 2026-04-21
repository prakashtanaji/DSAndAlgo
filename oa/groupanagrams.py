words = ["eat", "tea", "tan", "ate", "nat", "bat", "test"]
# this method runtime efficient but space inefficient, we can do 
# better by using a frequency count of 
# characters in the word as the key instead of sorting the word. This will run in O(nk) time and O(nk) space, where n is the number of words and k is the average length of the words.
def anagrams_with_sorting():
    ana_map = {}
    for word in words:
        sorted_word = ''.join(sorted(word))
        if sorted_word in ana_map:
            ana_map[sorted_word].append(word)
        else:
            ana_map[sorted_word] = [word]

    for sorted_word, lst in ana_map.items():
        print(lst)
    #print(ana_map.items()   )

#anagrams_with_sorting()

# runtime is O(nk) and space is O(nk) where n is the number of words and 
# k is the average length of the words. 
# This is more efficient than the sorting method which runs in O(nklogk) time and O(nk) space.
def anagrams_with_freq():
    ana_map = {}
    for word in words:
        # Create a frequency count of characters in the word
        freq = {}
        for char in word:
            freq[char] = freq.get(char, 0) + 1
        # Convert the frequency dictionary to a tuple of (char, count) pairs
        freq_tuple = tuple(sorted(freq.items()))
        if freq_tuple in ana_map:
            ana_map[freq_tuple].append(word)
        else:
            ana_map[freq_tuple] = [word];

    for freq_tuple, lst in ana_map.items():
        print(lst)

anagrams_with_freq()