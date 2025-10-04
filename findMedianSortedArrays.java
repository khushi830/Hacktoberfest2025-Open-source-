class Solution
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int len=nums1.length+nums2.length;
        if(len%2==1)
            return (double)findKthElement(nums1,nums2,(len+1)/2);
        else
            return ((double)findKthElement(nums1,nums2,len/2)+findKthElement(nums1,nums2,len/2+1))/2;
    }

    public int findKthElement(int[] nums1, int[] nums2, int k)
    {
        if(nums1.length > nums2.length)
            return findKthElement(nums2, nums1, k);

        int n1 = nums1.length, n2 = nums2.length;
        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);

        while(low <= high)
        {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            if(l1 <= r2 && l2 <= r1)
                return Math.max(l1, l2);
            else if(l1 > r2)
                high = cut1 - 1;
            else
                low = cut1 + 1;
        }

        return -1;
    }
}
