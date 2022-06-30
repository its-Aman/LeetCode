
var MedianFinder = function() {
    this.smallPQ = new MinPriorityQueue({priority: x => x});
    this.largePQ = new MaxPriorityQueue({priority: x => x});
    this.even = true;
};

/** 
 * @param {number} num
 * @return {void}
 */
MedianFinder.prototype.addNum = function(num) {
    if(this.even) {
      this.largePQ.enqueue(num)
      this.smallPQ.enqueue(this.largePQ.dequeue().element);
    } else {
      this.smallPQ.enqueue(num)
      this.largePQ.enqueue(this.smallPQ.dequeue().element);      
    }

    this.even = !this.even
};

/**
 * @return {number}
 */
MedianFinder.prototype.findMedian = function() {
    if(this.even) {
      return (this.largePQ.front().element + this.smallPQ.front().element) / 2.0;
    } else {
      return this.smallPQ.front().element;
    }
};

/** 
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = new MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */