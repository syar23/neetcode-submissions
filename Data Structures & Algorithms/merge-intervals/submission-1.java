class Solution {
    public int[][] merge(int[][] intervals) {
        //take care of edge cases
        //1. sort intervals by start time
        //2. keep [currStart, currEnd] interval
        //3. For each next [s,e], if s<=currEnd, currEnd = max(currEnd,e)
        // else push current Interval to output
        //4. Add the last current Interval to output

        if(intervals == null || intervals.length <= 1)
            return intervals;
        
        //sort
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //set current Interval
        int[] curr = intervals[0];

        List<int[]> list = new ArrayList<>();

        for(int i=1;i<intervals.length;i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            if(s<=curr[1])
                curr[1]=Math.max(curr[1],e);
            else {
                list.add(curr);
                curr = intervals[i];
            }          
        }
        list.add(curr);
        // 3) to array
        return list.toArray(new int[list.size()][]);
    }
}
