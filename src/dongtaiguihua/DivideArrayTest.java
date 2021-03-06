package dongtaiguihua;

public class DivideArrayTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 0, 1, 7, 2, 4 };
		System.out.println(getMaxDiff(array));

	}

	/* f[i][j]表示i个元素装容量为j的背包能装的最大容量 */
	public static int getMaxDiff(int[] array) {
		int sum = getSum(array);
		int length = array.length;
		int[][] f = new int[length + 1][sum / 2 + 1];
		for (int i = 0; i < length; i++) {
			for (int j = 1; j <= sum / 2; j++) {
				f[i + 1][j] = f[i][j];
				if (array[i] <= j && f[i][j - array[i]] + array[i] > f[i][j]) {
					f[i + 1][j] = f[i][j - array[i]] + array[i];
				}
			}
		}
		return sum - 2 * f[length][sum / 2];
	}

	public static int getSum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

}
