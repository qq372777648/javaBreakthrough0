package 算法.排序;

public class quicksort2 {
	public int data[];

	private int partition(int sortArray[], int low, int hight) {
		int key = sortArray[low];

		while (low < hight) {
			while (low < hight && sortArray[hight] >= key)//row=hight 或 sortArray[hight]<key
				hight--;
			
			sortArray[low] = sortArray[hight];//小的
			//low++;
			while (low < hight && sortArray[low] <= key)//row=hight 或 sortArray[low]>key
				low++;
			sortArray[hight] = sortArray[low];//大的
			//hight--;
		}
		sortArray[low] = key;//基值
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		return low;
	}

	public void sort(int low, int hight) {
		if (low < hight) {
			int result = partition(data, low, hight);
			sort(low, result - 1);
			sort(result + 1, hight);
		}

	}

	public void display() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成方法存根
        quicksort2 qs = new quicksort2();
        int data[] = {44,22,2,32,54,22,88,77,99,11};
        int data2[] = {1,2,3,4,5};
        qs.data = data;
        qs.sort(0, qs.data.length-1);
        qs.display();
        
        qs.data = data2;
        qs.sort(0, qs.data.length-1);
        qs.display();
	}
}