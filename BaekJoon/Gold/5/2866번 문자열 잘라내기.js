const input = require('fs').readFileSync('C:/Users/tomy9/Desktop/Moz1e git/Algorithm/BaekJoon/input.txt').toString().split("\n")

const [R, C] = input[0].split(" ").map((i) => Number(i))
let verticalStr = []
for (let i = 0; i < C; i++) {
    verticalStr.push("")
}
for (let i = 2; i <= R; i++) {
    input[i].split("").forEach((i, index) => {
        verticalStr[index] += i
    })
}

let answer = 0

//길이가 같다 == 중복되는게 없다 => answer +=1, 각 문자열 0 삭제
//길이가 다르다 == 중복되는게 있다 => 종료
//answer+1 == R => 종료
while (true) {
    if (answer + 1 == R) break
    if (verticalStr.length != [...new Set(verticalStr)].length) break

    answer += 1
    verticalStr = verticalStr.map((v) => v.substr(1, v.length))
}

console.log(answer)