package �㷨.�ݹ�;

import java.util.Arrays;

/**
 * @author lzw
 * @version ����ʱ�䣺2016��7��12�� ����1:18:59
 * @Description:
 */

public class ȫ���� {

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

	// k��ʾ��ǰѡȡ�����������е�λ���±�,m��Ҫ���е�����ĳ���.
	public static void permutation(int[] arr, int k, int m) {
		// ��ǰλ�����������һ��λ���غ�ʱ,��ʱ��ӡ������.
		// System.out.println("k=" + k + " m=" + m);
		if (k == m - 1) {
			System.out.println(Arrays.toString(arr));
		} else {
			for (int i = k; i < m; i++) {
				// ��ǰλ��Ԫ�������λ�õ�Ԫ�������滻
				swap(arr, k, i);
				permutation(arr, k + 1, m);
				// ��λ�û�����,��������һ������.
				// System.out.println("..k=" + k + " m=" + m + " i=" + i);
				swap(arr, k, i);

			}
		}
	}
}