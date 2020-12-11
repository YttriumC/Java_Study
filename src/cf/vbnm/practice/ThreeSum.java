package cf.vbnm.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		for (List<Integer> list : new ThreeSum().threeSum(new int[]{-2, 0, 1, 1, 2})) {
			System.out.println(Arrays.toString(list.toArray()));
		}

	}

	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 3)
			return new ArrayList<>();
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])
				if (i != nums.length - 2)
					continue;
			int lIndex = i - 1, rIndex = i + 1/*, lastLVal = nums[0] - 1, lastRVal = nums[nums.length - 1] + 1*/;
			while (lIndex >= 0 && rIndex <= nums.length) {
				//TODO
			}
		}
		return list;
	}
}
