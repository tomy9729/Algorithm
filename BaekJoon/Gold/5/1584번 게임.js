const input = require('fs').readFileSync('C:/Users/tomy9/Desktop/Moz1e git/Algorithm/BaekJoon/input.txt').toString().split("\n")

const N = Number(input[0])//위험
let index = 1
const danger = (() => {
    const result = []
    for (let i = 0; i < N; i++, index++) {
        result.push(input[index].split(" ").map(Number))
    }
    return result
})()

const M = Number(input[index++])//죽음
const death = (() => {
    const result = []
    for (let i = 0; i < M; i++, index++) {
        result.push(input[index].split(" ").map(Number))
    }
    return result
})()

const isIn = (x, y, area) => {
    const check = area.find((eachArea => {
        const [minX, minY, maxX, maxY] = [
            Math.min(eachArea[0], eachArea[2]),
            Math.min(eachArea[1], eachArea[3]),
            Math.max(eachArea[0], eachArea[2]),
            Math.max(eachArea[1], eachArea[3]),
        ]
        if (minX <= x && x <= maxX && minY <= y && y <= maxY) return true
        else return false
    }))
    if (check) return true
    else return false
}


const area = Array.from(Array(501), () => new Array(501).fill(25001))
area[0][0] = 0
const bfs = () => {
    const dx = [0, 0, 1, -1]
    const dy = [1, -1, 0, 0]

    const q = []
    q.push({ x: 0, y: 0 })
    while (q.length != 0) {
        const cur = q.shift()
        for (let i = 0; i < 4; i++) {
            const next = { x: cur.x + dx[i], y: cur.y + dy[i] }

            if (isIn(next.x, next.y, [[0, 0, 500, 500]])) {
                const nextPoint = (() => {
                    if (isIn(next.x, next.y, danger)) return area[cur.x][cur.y] + 1
                    else return area[cur.x][cur.y]
                })()
                if (!isIn(next.x, next.y, death)) {
                    if (area[next.x][next.y] > nextPoint) {
                        area[next.x][next.y] = nextPoint
                        q.push(next)
                    }
                }
            }
        }
    }
}

bfs()
if (area[500][500] == 25001) console.log(-1)
else console.log(area[500][500])