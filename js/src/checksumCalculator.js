export const countTuples = (boxIds) => {
  const result = {}
  if (boxIds.length === 0)
    result.twos = 0
  else {
    const id = boxIds[0]
    result.twos = hasMultiples(id, 2) ? 1 : 0
    result.threes = hasMultiples(id, 3) ? 1 : 0
  }
  return result
}
const hasMultiples = (id, ocurrences) => {
  for (let i = 0; i < id.length; i++) {
    let charCount = 1
    for (let j = 0; j < id.length; j++) {
      if (i!==j && id[i] === id[j]) charCount++
    }
    if (charCount === ocurrences) return true
  }
  return false
}