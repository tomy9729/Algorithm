#1181번 단어 정렬
n = int(input())

words = []
for i in range(n) : 
  words.append(input())

words.sort()
words.sort(key=lambda x:len(x))
result = []

for i in range(n) : 
  if i == 0 :
    result.append(words[i])
  elif result[len(result)-1] == words[i] : 
    continue
  else : 
    result.append(words[i])

for i in range(len(result)) : 
  print(result[i])
