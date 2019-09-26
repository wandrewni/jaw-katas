export const computeChecksum = (boxIds) => {
  const result = {
    twos: 0,
    threes: 0
  }
  boxIds.forEach(boxId => {
    result.twos += hasMultiples(boxId, 2)
    result.threes += hasMultiples(boxId, 3)
  })
  result.checksum = result.twos * result.threes
  return result
}

const hasMultiples = (id, occurrences) => {
  for (let i = 0; i < id.length; i++) {
    let charCount = 1
    for (let j = 0; j < id.length; j++) {
      if (i !== j && id[i] === id[j]) charCount++
    }
    if (charCount === occurrences) return true
  }
  return false
}

