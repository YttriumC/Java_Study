package cf.vbnm.practice;

public class FindMedianSortedArrays {
	public static void main(String[] args) {
		System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(
				new int[]{}, new int[]{3,4}));
	}
/*
 *	给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数。
 *
 *	进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0) {
			return (double) (nums2[nums2.length / 2] + nums2[(nums2.length - 1) / 2]) / 2;
		}
		if (nums2 == null || nums2.length == 0) {
			return (double) (nums1[nums1.length / 2] + nums1[(nums1.length - 1) / 2]) / 2;
		}
		int totalLen = nums1.length + nums2.length;
		int middleIndex = (((totalLen & 0x1) == 0) ? totalLen - 1 : totalLen) / 2;
		int middle = nums1[0], nums1Index = 0, nums2Index = 0;
		for (int i = 0; i <= middleIndex; i++) {
			if (nums1Index == nums1.length) {
				middle = nums2[nums2Index];
				nums2Index++;
				continue;
			}
			if (nums2Index == nums2.length) {
				middle = nums1[nums1Index];
				nums1Index++;
				continue;
			}
			if (nums1[nums1Index] < nums2[nums2Index]) {

				middle = nums1[nums1Index];
				nums1Index++;
			} else {

				middle = nums2[nums2Index];
				nums2Index++;
			}
		}
		int middle2 = middle;
		if ((totalLen & 1) == 0) {
			if (nums1.length == nums1Index) {
				middle2 = nums2[nums2Index];
				return (double) (middle + middle2) / 2;
			} else if (nums2.length == nums2Index) {
				middle2 = nums1[nums1Index];
				return (double) (middle + middle2) / 2;
			}
			middle2 = Math.min(nums1[nums1Index], nums2[nums2Index]);
		}
		return (double) (middle + middle2) / 2;
	}
}
