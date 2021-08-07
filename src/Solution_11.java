public class Solution_11 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int left, right, area, minHeight;
        left = 0;
        right = height.length-1;
        area = 0;
        while(left<right) {
            minHeight = Math.min(height[left], height[right]);
            area = Math.max(area, minHeight * (right - left));
            if (height[left] > minHeight) {
                while (left < right && height[right] <= minHeight) right--;
            } else {
                while (left < right && height[left] <= minHeight) left++;
            }
        }
        return area;
    }
}
