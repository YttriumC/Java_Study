package cf.vbnm.acm;

public class TwoSum {
	public static void main(String[] args) {
		TwoSum twoSum=new TwoSum();
		twoSum.twoSum(new int[]{-1, -2, -3, -4, -5},-8);
	}

	//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
	public int[] twoSum(int[] nums, int target) {
		int[] rtn=new int[2];
		for (int i = 0; i < nums.length; i++) {
			int toFind;
			toFind = target - nums[i];
			for (int j = 0; j < nums.length; j++) {
				if(toFind==nums[j])
					if(i!=j)
					{
						rtn[0]=i;
						rtn[1]=j;
						return rtn;
					}
			}

		}
		return null;
	}
}
