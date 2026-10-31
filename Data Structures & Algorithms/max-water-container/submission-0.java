class Solution {
    public int maxArea(int[] heights) {
        int l=0, r=heights.length-1;
        int maxA = 0;
        while(l<r) {
            int A = (r-l)*Math.min(heights[r], heights[l]);
            maxA = Math.max(maxA, A);
            if(heights[r] < heights[l])
                r--;
            else
                l++;
        }

        return maxA;
    }
}
