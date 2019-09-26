import { computeChecksum } from './checksumCalculator'
import { readFileSync } from 'fs'

describe('checksum calculator', () => {
  it('should return 0 counts for empty input', () => {
    checkExpectedTwos([], 0)
    checkExpectedTwos([''], 0)
  })
  it('should return double count of 1 for string with one double',() => {
    checkExpectedTwos(['aa'], 1)
    checkExpectedTwos(['baa'], 1)
    checkExpectedTwos(['ababa'], 1)
  })
  it('should return double count of 1 for 2 doubles in one string',() => {
    checkExpectedTwos(['abab'],1)
  })
  it('should return 0 for no doubles', () => {
    checkExpectedTwos(['abc'], 0)
  })
  it('should not count letters appearing more than twice as doubles', () => {
    checkExpectedTwos(['aaa'], 0)
  })
  it('should return triple count of 1 for string with one triple', () =>{
    checkExpectedThrees(['aaa'], 1)
  })
  it('should return 0 for no triple', () => {
    checkExpectedThrees([''],0)
    checkExpectedThrees(['aa'],0)
  })
  it('should return 1 double and 1 triple for 1 string with both', () => {
    checkExpectedThrees(['ababa'],1)
    checkExpectedTwos(['ababa'],1)
  })
  it('should return triple count of 1 for 2 triples in one string',() => {
    checkExpectedThrees(['ababab'],1)
  })
  it('should return 2 doubles for a set of multiple strings with 2 doubles',() => {
    checkExpectedTwos(['ababa', 'cdc', 'abcd'],2)
  })
  it('should return 2 threes for a set of multiple strings with 2 triples', () => {
    checkExpectedThrees(['aaa', 'bbb'], 2)
  })
  it('calculates the checksum of multiple strings', () =>{
    const result = computeChecksum(['aa', 'bb', 'cc', 'ddd', 'eee']).checksum
    expect(result).toEqual(6)
  })
  it('should calculate the puzzle input', () => {
    const input = readFileSync(__dirname + '/checksum-calculator-input.txt').toString().split('\n')
    expect(computeChecksum(input).checksum).toEqual(7192)
  })
})



const checkExpectedTwos = (input, expectedTwos) => {
  const result = computeChecksum(input)
  expect(result.twos).toEqual(expectedTwos)
}

const checkExpectedThrees = (input, expectedThrees) => {
  const result = computeChecksum(input)
  expect(result.threes).toEqual(expectedThrees)
}
