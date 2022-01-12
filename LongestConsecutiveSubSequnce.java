class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
	static int findLongestConseqSubseq(int nums[], int N)
	{
	   // add your code here
	   if (nums == null || nums.length == 0) return 0;
        int count = 1;
        int max = 1;
         TreeSet<Integer> treeSet = new TreeSet<>();
        for (int a : nums) {
            treeSet.add(a);
        }

        int prev = treeSet.first();

        for (Integer integer : treeSet) {
            if (integer == prev) continue;
            if ((prev + 1) == integer) {
                count++;
                if (max < count) max = count;
            } else {
                count = 1;
            }
            prev = integer;
        }
        return max;
	}
}