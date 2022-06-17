const input = require('fs').readFileSync('C:/Users/tomy9/Desktop/Moz1e git/Algorithm/BaekJoon/input.txt').toString().split("\n")

let [hour, min] = input[0].split(" ").map((i) => Number(i))
const time = Number(input[1])

const answer = (() => {
    min += time
    hour += parseInt(min / 60)
    min = (() => {
        if (min == 59) return min % 60
        else return (min + 1) % 60 - 1
    })()
    hour = (() => {
        if (hour == 23) return hour % 24
        else return (hour + 1) % 24 - 1
    })()

    return `${hour} ${min}`
})()

console.log(answer)
