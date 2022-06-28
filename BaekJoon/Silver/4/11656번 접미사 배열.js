const input = require('fs').readFileSync('C:/Users/tomy9/Desktop/Moz1e git/Algorithm/BaekJoon/input.txt').toString().split("\n")

const S = input[0]
const answer = (() => {
    const result = []
    for (let i = 0; i < S.length; i++) {
        result.push(S.substr(i, S.length))
    }
    result.sort()
    return result
})()
console.log(answer.join("\n"))