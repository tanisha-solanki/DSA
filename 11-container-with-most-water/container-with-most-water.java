class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int right = n-1;
        int left = 0;
int maxArea = Integer.MIN_VALUE;
int currentArea;
        while(right>left){
        currentArea =Math.min(height[left], height[right]) * (right-left); 
        maxArea = Math.max(currentArea,maxArea);
        
        if(height[left]<height[right]){
            left++;
        }
        else
        right--;
                }
    return maxArea;
    }
}