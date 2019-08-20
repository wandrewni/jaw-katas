const checker = require('./phoneConsistencyChecker')

describe('phone consistency checker', () => {
  const check = checker.check
  it('should be a real function', () => {
    check(null)
  })
  it('should be consistent in cases of empty or null lists', () => {
    expect(check(null)).toBe(true)
    expect(check([])).toBe(true)
  })
  it('should NOT be consistent in case of two identical numbers', () => {
    expect(check(['911', '911'])).toBe(false)
  })
  it('should consider a single item to be consistent', () => {
    expect(check(['1'])).toBe(true)
  })
  it('should be consistent in case of two different numbers of the same length', () => {
    expect(check(['911', '999'])).toBe(true)
  })
  it('should consider prefix matches to be inconsistent', () => {
    expect(check(['9', '91'])).toBe(false)
    expect(check(['91', '9'])).toBe(false)
    expect(check(['911', '91'])).toBe(false)
  })
  it('should check consistency amongst all numbers in list', () => {
    expect(check(['1', '2', '13'])).toBe(false)
    expect(check(['2', '1', '13'])).toBe(false)
  })
  it('should work for everything', () => {
    expect(check(['111','1112','1212'])).toBe(false)
    expect(check(['1234','5678','9124','4'])).toBe(true)
    expect(check(['1','2','3','4','5','6','7','890','91','000004'])).toBe(true)
  })
})
