/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *     If value is provided, then it holds a single integer
 *     Otherwise it holds an empty nested list
 *     constructor(value?: number) {
 *         ...
 *     };
 *
 *     Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     isInteger(): boolean {
 *         ...
 *     };
 *
 *     Return the single integer that this NestedInteger holds, if it holds a single integer
 *     Return null if this NestedInteger holds a nested list
 *     getInteger(): number | null {
 *         ...
 *     };
 *
 *     Set this NestedInteger to hold a single integer equal to value.
 *     setInteger(value: number) {
 *         ...
 *     };
 *
 *     Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
 *     add(elem: NestedInteger) {
 *         ...
 *     };
 *
 *     Return the nested list that this NestedInteger holds,
 *     or an empty list if this NestedInteger holds a single integer
 *     getList(): NestedInteger[] {
 *         ...
 *     };
 * };
 */

class NestedIterator {
  private idx = 0;
  private result: Array<number>;

  constructor(private nestedList: NestedInteger[]) {
    this.result = this.flatten(nestedList);
  }

  private flatten(nestedList: NestedInteger[]): Array<number> {
    let result = new Array<number>();

    for(let item of nestedList) {
      console.log(item);

      if(item.isInteger() && item.getInteger() != null){
        result.push(item.getInteger());
      } else if(item.getList().length) {
        console.log('else -> ',item.getList())
        result = result.concat(this.flatten(item.getList())); 
      }
    }

    return result;
  }

  public hasNext(): boolean {
    return this.idx < this.result.length;
  }

  public next(): number {
    const num = this.result[this.idx];
    this.idx += 1;
    return num;
  }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = new NestedIterator(nestedList)
 * var a: number[] = []
 * while (obj.hasNext()) a.push(obj.next());
 */