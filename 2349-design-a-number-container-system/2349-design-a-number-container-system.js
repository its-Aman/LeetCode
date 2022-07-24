
var NumberContainers = function() {
    this.num = {};
    this.numMap = {};
};

/** 
 * @param {number} index 
 * @param {number} number
 * @return {void}
 */
NumberContainers.prototype.change = function(I, N) {
  this.num[I] = N;

  if(!(N in this.numMap))
    this.numMap[N] = new MinPriorityQueue();
  
  this.numMap[N].enqueue(I);
};

/** 
 * @param {number} number
 * @return {number}
 */
NumberContainers.prototype.find = function(N) {
  while(
    N in this.numMap && 
    this.numMap[N].size() > 0 && 
    this.num[this.numMap[N].front().element] !== N
  )
    this.numMap[N].dequeue();
  
  if(N in this.numMap && this.numMap[N].size() > 0)
    return this.numMap[N].front().element;
  
  return -1;
};

/** 
 * Your NumberContainers object will be instantiated and called as such:
 * var obj = new NumberContainers()
 * obj.change(index,number)
 * var param_2 = obj.find(number)
 */