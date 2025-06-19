class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] arr = new int[points.length];
        for(int i=0;i<points.length;i++){
            arr[i]=points[i][0];
        }
        Arrays.sort(arr);
         int max=0;
        for(int j=1;j<points.length;j++){  
            int cur=arr[j]-arr[j-1];
            if(max<cur){
                max=cur;
            }
        }
        return max;
    }
}