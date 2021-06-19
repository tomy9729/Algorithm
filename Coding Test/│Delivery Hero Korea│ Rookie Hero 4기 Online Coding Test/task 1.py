S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker"
C = "Example"
def solution(S, C):
    # write your code in Python 3.6
    S_list = S.split(",")
    name = []
    for i in S_list : 
      temp = i.split()
      if "-" in temp[-1] : 
        temp[-1] = temp[-1].replace("-","")
      name.append(temp)

    Email = []
    for i in name :
        temp = ""
        temp += "<" + i[0][0].lower()
        if len(i) == 3 : 
          temp += i[1][0].lower()
        if len(i[-1]) > 8 : 
          temp += i[-1][:8].lower()
        else : 
          temp += i[-1].lower()
        Email.append(temp)

    count = [1]*len(Email)
    for i in range(len(Email)) : 
      for j in range(i+1,len(Email)) :
        if Email[i] == Email[j] :
          count[j] +=1
   
    for i in range(len(Email)) : 
      if count[i] > 1 : 
        Email[i] += str(count[i])
      Email[i] += "@"+C.lower() + ".com>"
      S_list[i] += " "+Email[i]
    
    return ",".join(S_list)
solution(S, C)
