package AnalysisResuts0917;
//快速排序
public class Quick_Sort {
 
	// 排序的主要算法
	private static int Partition(double[] data, int start, int end) 
	{
		double mid_data = data[end];// 选取最后最个数作为中间值哨兵，从开始进行遍历，每个数与之比较
		int index = start; // 记录比哨兵小的数字在左端的位置或个数
							// 注意要考虑start = 0的情况，和《算法导论》中的伪码有区别
		for (int i = start; i < end; i++) 
		{
			// 判断每个值与哨兵的大小关系，小于等于则放在左边index位置处，并将index++
			// 可以理解为通过index计算小于哨兵的值的个数，并将所有小于或等于的数通过交换移过来
			if (data[i] <= mid_data) 
			{
				swap(data, i, index);
				index++;
			}
		}
		// 将哨兵移动至中间处，由于data[index]肯定大于mid_data，故移至最后依然满足算法的要求
		swap(data, index, end);
		return index;
	}
 
	// 分治法
	public static void QuickSort(double[] data, int start, int end) 
	{
		if (start < end) 
		{
			// 原址排序，找到中间值将数组一分为二，分治法继续递归
			int mid = Partition(data, start, end);
			QuickSort(data, start, mid - 1);
			QuickSort(data, mid + 1, end);
		}
	}
 
	// 无法像C++一样使用引用实现，故只好使用data数组进行改变
	private static void swap(double[] data, int a, int b) 
	{
		double temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
 
	public void print_array(double[] data) 
	{
		for (double num : data) 
		{
			System.out.print(num);
			System.out.print(" ");
		}
	}
 
	public static void main(String[] args) 
	{
 
		double data[] = { 3.22, 3.4, 4.5, 2.0, 1.3, 2.4, 5.6, 2.4, 5.7 };
		Quick_Sort quick_Sort = new Quick_Sort();
		
		Quick_Sort.QuickSort(data , 0 , data.length - 1);//注意初始调用的参数值
		quick_Sort.print_array(data);
 
	}
 
}
 