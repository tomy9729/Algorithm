S = 'admin  -wx 29 Sep 1983        833 source.h\nadmin  r-x 23 Jun 2003     854016 blockbuster.mpeg\nadmin  --x 02 Jul 1997        821 delete-this.py\nadmin  -w- 15 Feb 1971      23552 library.dll\nadmin  --x 15 May 1979  645922816 logs.zip\njane   --x 04 Dec 2010      93184 old-photos.rar\njane   -w- 08 Feb 1982  681574400 important.java\nadmin  rwx 26 Dec 1952   14680064 to-do-list.txt'
#S = "admin  -w- 15 Feb 1971      23552 library.dll\nadmin  --x 15 May 1979  645922816 logs.zip\njane   --x 04 Dec 2010      93184 old-photos.rar\njane   -w- 08 Feb 1982  681574400 important.java"
#S = ""
def solution(S):
    # write your code in Python 3.6
    if S =="":
      return "NO FILES"
    S = S.split("\n")
    file = []
    for i in S : 
      file.append(i.split())
    result = []
    for i in file : 
      if i[0] != "admin" :
        continue
      if i[1][2] == "-" : 
        continue
      if int(i[5]) >= 14*(2**20) : 
        continue
      result.append(i[2:5])
    if len(result) == 0 :
      return "NO FILES"
    for i in result : 
      i[0] = int(i[0])
      i[2] = int(i[2])
      if i[1] == "Jan" : 
        i.append(1)
      elif i[1] == "Feb" : 
        i.append(2)
      elif i[1] == "Mar" : 
        i.append(3)
      elif i[1] == "Apr" : 
        i.append(4)
      elif i[1] == "May" : 
        i.append(5)
      elif i[1] == "Jun" : 
        i.append(6)
      elif i[1] == "Jul" : 
        i.append(7)
      elif i[1] == "Aug" : 
        i.append(8)
      elif i[1] == "Sep" : 
        i.append(9)
      elif i[1] == "Oct" : 
        i.append(10)
      elif i[1] == "Nov" : 
        i.append(11)
      elif i[1] == "Dec" : 
        i.append(12)
    result = sorted(result,key=lambda x : (x[2],x[3],x[0]))
    temp = ""
    temp = temp + str(result[0][0])+" "+result[0][1]+" "+str(result[0][2])
    return temp

solution(S)
