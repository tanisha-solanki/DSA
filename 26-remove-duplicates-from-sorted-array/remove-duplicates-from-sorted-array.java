class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,j=1,k=1;
        while(j<nums.length){
            if(nums[j]==nums[j-1])
            j++;

            else{
                i++;
                nums[i]=nums[j];
                j++;
                k++;
            }

        }
   return k;  }
   
}