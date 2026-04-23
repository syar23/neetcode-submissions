class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //take care of edge cases
        //sort the intervals based on end time
        //Min removals = total intervals − max number of non-overlapping intervals you can keep.
        //To maximize kept intervals, always keep the one that finishes earliest (classic activity selection).

        //what if 2 intervals have same end time
        //We sort by end. If two intervals have equal end, their order doesn’t matter because:
        //When you encounter the first one, you’ll keep it (since start >= lastEnd).
        //The next one will have start < end (because they overlap at the end point), so it will be skipped.
        //In effect, you keep at most one of them, which is optimal.
        
        if(intervals == null || intervals.length<=1)
            return 0;
   
        int count=0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));      
        int prevEnd = Integer.MIN_VALUE;
        for(int[] inter : intervals) {
            if(inter[0] >= prevEnd) {
                count++;
                prevEnd=inter[1];
            } //else: overlaps -> skip this interval :remove it
        }
        return intervals.length-count;
    }
}
