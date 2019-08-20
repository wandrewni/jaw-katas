module.exports = {
  check: (phoneNumbers) => {
    const eitherIsPrefix = (a, b) => b.startsWith(a) || a.startsWith(b)

    if (!phoneNumbers || phoneNumbers.length < 2) return true
    const phoneQuantity = phoneNumbers.length
    for (let j = 0; j < phoneQuantity; j++)
      for (let i = j; i < phoneQuantity; i++)
        if (i !== j && eitherIsPrefix(phoneNumbers[i], phoneNumbers[j])) return false
    return true
  }
}