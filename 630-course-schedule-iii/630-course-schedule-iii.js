/**
 * @param {number[][]} courses
 * @return {number}
 */
var scheduleCourse = function(courses) {
  courses.sort((a, b) => a[1] - b[1]);
  const pq = new MaxPriorityQueue({priority: x => x});
  let time = 0;
  
  for(let [duration, lastDay] of courses) {
    if(time + duration <= lastDay) {
      pq.enqueue(duration);
      time += duration;
    } else if(!pq.isEmpty() && pq.front().element > duration) {
      time += duration - pq.dequeue().element;
      pq.enqueue(duration);
    }
  }
  
  return pq.size();
};