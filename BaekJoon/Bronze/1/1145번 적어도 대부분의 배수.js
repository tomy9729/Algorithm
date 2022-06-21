const input = require('fs').readFileSync('C:/Users/tomy9/Desktop/Moz1e git/Algorithm/BaekJoon/input.txt').toString().split("\n")

const arr = input[0].split(" ").map(Number)

const answer = (() => {
    let num = 1
    while (num++) {
        if (arr.filter((a) => num % a == 0).length >= 3)
            return num

    }
})()

console.log(answer)