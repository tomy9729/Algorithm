const input = require('fs')
    .readFileSync('C:/Users/tomy9/Desktop/Moz1e git/Algorithm/BaekJoon/input.txt')
    .toString().split("\n")

const A = input[1].split(" ").map((i) => Number(i))
const B = input[2].split(" ").map((i) => Number(i))

const union = [...new Set([...A, ...B])]

const answer = 2 * union.length - (A.length + B.length)

console.log(answer)