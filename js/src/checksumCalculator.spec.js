const {countTuples} = require('./checksumCalculator')


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
})


const checkExpectedTwos = (input, expectedTwos) => {
  const result = countTuples(input)
  expect(result.twos).toEqual(expectedTwos)
}

const checkExpectedThrees = (input, expectedThrees) => {
  const result = countTuples(input)
  expect(result.threes).toEqual(expectedThrees)
}

it('should collect counts', () => {
  const myString = 'abcsafssa'

  console.log(myString)
  const result = {}
  for (let i = 0; i < myString.length; i++) {
    let letter = myString[i]
    if (!result[letter]) result[letter] = 0
    result[letter]++
  }
  console.log(result)
})
/*
empty list counts 0 - done
empty string counts 0 - done
string with a 2-ple counts for 2 - done
more than 2 is not a tuple
triples should not count as doubles
string with a 3-ple counts for 3
string with neither counts for neither
string with 2-ple and 3-ple counts for both
string with 2 2-ples counts only once
string with 2 3-ples counts only once
should collect tuple counts for multiple words
checksum is 2pls * 3pls
 */