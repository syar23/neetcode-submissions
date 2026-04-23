class Solution {
    public int findDuplicate(int[] nums) {

        //this modifies the original array
        //can handle only one repeat
        /*for(int i=0 ;i < nums.length;i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0)
                return index+1;
            nums[index] *= -1;  
        }
        return -1;
*/
        //use floyds detection algo to solve wihtout modifying the array
        //works only if duplicate exists
        //and using O(1) extra space
        //can handle multiple repeats

        int slow = nums[0];
        int fast = nums[0];
        //cycle detection
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        //find the duplicate
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;



    }


}
