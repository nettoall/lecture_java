package algorithm.sort.merge;

public class MergeSort {
	static int[] buff;
	
	static void __mergeSort(int[] a, int left, int right) {
		if(left < right) {
			int i ;
			int center = (left + right) / 2;
			int p = 0;
			int j = 0;
			int k = left;
			
			__mergeSort(a, left, center);
			__mergeSort(a, center + 1, right);
			
			for(i = left; i <= center; i++) {
				buff[p++] = a[i];
			}
			
			while(i <= right && j < p) {
				a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
			}
			
			while(j < p) {
				a[k++] = buff[j++];
			}
		}
	}
	
	static void mergeSort(int[] a, int n) {
		buff = new int[n];
		
		__mergeSort(a, 0, n - 1);
		
		buff = null;
	}
	
	public static void main(String[] args) {
		System.out.println("병합 정렬");
		int[] x = {22,5,11,32,120,68,70};
		
		mergeSort(x, x.length);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i < x.length; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}

}
