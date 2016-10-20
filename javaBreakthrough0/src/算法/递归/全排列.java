package 算法.递归;

import java.util.Arrays;

/**
 * @author lzw
 * @version 创建时间：2016年7月12日 下午1:18:59
 * @Description:
 */

public class 全排列 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		permutation(arr, 0, arr.length);
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// k表示当前选取的数在数组中的位置下标,m是要排列的数组的长度.
	public static void permutation(int[] arr, int k, int m) {
		// 当前位置与数组最后一个位置重合时,此时打印排列数.
		// System.out.println("k=" + k + " m=" + m);
		if (k == m - 1) {
			System.out.println(Arrays.toString(arr));
		} else {
			for (int i = k; i < m; i++) {
				// 当前位置元素与后面位置的元素依次替换
				swap(arr, k, i);
				permutation(arr, k + 1, m);
				// 将位置换回来,继续做下一个排列.
				// System.out.println("..k=" + k + " m=" + m + " i=" + i);
				swap(arr, k, i);

			}
		}
	}
}