export const findDifferences = (id1, id2) => {
  const differences = []
  for (let position = 0; position < id1.length; position++) {
    if (id1[position] !== id2[position]) {
      differences.push(position)
    }
  }
  return differences
}