class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap=new PriorityQueue<>((a,b)->b-a);
        minHeap=new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num<maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        if(Math.abs(maxHeap.size()-minHeap.size())>1){
            minHeap.offer(maxHeap.poll());
        } else if(maxHeap.size()<minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double) (maxHeap.peek()+minHeap.peek())/2;
        }
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */