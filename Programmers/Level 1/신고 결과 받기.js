// 신고 결과 받기.js
function solution(id_list, report, k) {
    const reportAll = {}
    id_list.forEach((i) => {
        reportAll[i] = { banedCount: 0, ban: [] }
    })

    const setReport = [...new Set(report)]
    setReport.forEach((r) => {
        const [user, ban] = r.split(" ")
        reportAll[user].ban.push(ban)
        reportAll[ban].banedCount++
    })

    const answer = (() => {
        const result = id_list.map((i) => {
            return reportAll[i].ban.reduce((total, curB) => {
                if (reportAll[curB].banedCount >= k) return total + 1
                else return total
            }, 0)
        })
        return result
    })()

    return answer
}

const id_list = ["muzi", "frodo", "apeach", "neo"]
const report = ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"]
const k = 2

console.log(solution(id_list, report, k))