import {findDifferences} from './differenceFinder'

describe('difference finder', () => {
  it('should find no differences for empty input', () => {
    expect(findDifferences('','')).toEqual([])
  })
  it('should find no differences for two identical strings', () =>{
    expect(findDifferences('a','a')).toEqual([])
  })
  it('should find one difference for two different strings of length 1', () =>{
    expect(findDifferences('a','b')).toEqual([0])
  })
  it('should find difference in the 0th position for two 2-length strings', () => {
    expect(findDifferences('aa', 'ba')).toEqual([0])
  })
  it('should find difference in the 1st position for two 2-length strings', () => {
    expect(findDifferences('aa', 'ab')).toEqual([1])
  })
  it('should find two differences for completely different two 2-length strings',()=>{
    expect(findDifferences('aa','bb')).toEqual([0,1])
    expect(findDifferences('ab','ba')).toEqual([0,1])
  })
})