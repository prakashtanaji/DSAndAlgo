from typing import List
class WordChain1:
    def longestStrChain(self, words: List[str]) -> int :
        words = sorted(words, key=lambda word:len(word))
        print(words)
        return 0


wc = WordChain1()
wc.longestStrChain(["a","bda","ba","b","bca","bdca"])