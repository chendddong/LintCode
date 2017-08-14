public class MergeSort {



	private static int[] mergesort(int[] num, int s, int t, int[] temp) {
		int m;
		int[] num2 = new int[t + 1];
		if (s == t)
			temp[s] = num[s];
		else {
			m = (s + t) / 2;
			mergesort(num, s, m, num2);
			mergesort(num, m + 1, t, num2);
			merg(num2, s, m, t, temp); 
		}
		return temp;
	}


	public static void merg(int[] num, int l, int m, int n, int[] temp) {
		int i, j, k;
		i = l;
		j = m + 1;
		k = l;
		while (i <= m && j <= n) {
			if (num[i] < num[j])
				temp[k++] = num[i++];
			else
				temp[k++] = num[j++];
		}
		
		while (i <= m) {
			temp[k++] = num[i++];
		}
		while (j <= n) {
			temp[k++] = num[j++];
		}
	}

	public static void main(String[] args) {
		int[] num = { 51, 38, 49, 27, 62, 05, 16, -14, 55 };
		int[] temp = new int[num.length];
		num = mergesort(num, 0, num.length - 1, temp);
		for (int i : num) {
			System.out.print(i + " ");
		}

	}
}