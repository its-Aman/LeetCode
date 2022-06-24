/**
 * @param {number[]} target
 * @return {boolean}
 */
var isPossible = function(target) {
  const mpq = new MaxPriorityQueue({priority: x => x});
  let sum = 0;
  
  for(let item of target) {
    sum += item; 
    mpq.enqueue(item);
  }
  
  while(true) {
    let { element } = mpq.dequeue();
    sum -= element; 
    
    if(element == 1 || sum == 1)
      return true;
  
    if(element < sum || sum == 0 || element % sum == 0)
      return false;
    
    element %= sum;
    sum += element;
    mpq.enqueue(element);
  }
};