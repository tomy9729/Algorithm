const input = require('fs').readFileSync('C:/Users/tomy9/Desktop/Moz1e git/Algorithm/BaekJoon/input.txt').toString().split("\n")

const N = Number(input[0])
const h = input.slice(1, N + 1).map((i) => {
    return {
        h: Number(i),
        count: 0
    }
}).reverse()

const stack = []
let answer = 0
h.forEach((buildingH) => {
    while (stack.length != 0) {
        if (buildingH.h > stack[0].h) {
            buildingH.count += 1 + stack[0].count
            stack.shift()
        }
        else break
    }
    stack.unshift(buildingH)
    answer += buildingH.count
})
console.log(answer)