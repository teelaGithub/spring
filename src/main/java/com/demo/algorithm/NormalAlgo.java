package com.demo.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 排序算法
 *
 * @author litinglan 2019/5/22 10:46
 */
public class NormalAlgo {
    /**
     * 冒泡排序：从小到大
     * 相邻2个数比较，一趟比较下来最大的数排最后，在重新对数据比较排序
     * 时间复制度：O(n^2)
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序：每次找到未排序列最小/大值后直接与已排序列末尾交换（而不是每次都交换）
     * 时间复制度：O(n^2)
     */
    public static void selectionSort(int[] arr) {
        int mixIndex = 0, temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            //mixIndex 最小值位置，i 已排序列末尾
            mixIndex = i;
            //找出最小值的位置下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[mixIndex] > arr[j]) {
                    mixIndex = j;
                }
            }
            //直接和最小值交换
            temp = arr[mixIndex];
            arr[mixIndex] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 直接插入排序：对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
     * 已排序列比较时需往后移
     * 时间复制度：O(n^2)
     */
    public static void insertionSort(int[] arr) {
        int key = 0;//待排序数据
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            //与已排序列从后往前比较交换
//            for (int j = i - 1; j >= 0; j--) {
//                if (arr[j] > key) {
//                    arr[j + 1] = arr[j];
//                    arr[j] = key;
//                }
//            }
            //网络答案
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * 希尔排序：取一个整数increment（小于n）作为间隔将全部元素分为increment个子序列，所有距离为increment的元素
     * 放在同一个子序列中，在每一个子序列中分别实行直接插入排序
     * increment=len/2 或 increment=len/3+1
     */
    public static void shellSort(int[] arr) {
        int d = arr.length / 2;
        while (d >= 1) {
            for (int i = d; i < arr.length; i++) {
                int j = i - d;
                int temp = arr[i];    //记录要插入的数据
                while (j >= 0 && arr[j] > temp) {  //从后向前，找到比其小的数的位置
                    arr[j + d] = arr[j];    //向后挪动
                    j -= d;
                }
//                if (j != i - d)    //存在比其小的数
                arr[j + d] = temp;
            }
            d /= 2;
        }
    }

    /**
     * 归并排序：采用分治法，将待排序列递归划分子序列并使之有序，再合并有序子序列
     * 时间复杂度：O(nlgn)
     */
    public static void mergeSort(int[] arr) {
        mSort(arr, 0, arr.length - 1);
    }

    //将原序列递归划分成若干左右子序列
    private static void mSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        mSort(arr, left, mid);
        mSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    //合并左右子序列
    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;//左子序列起始子针
        int j = mid + 1;//右子序列起始子针
        int t = 0;//缓存序列起始子针
        int[] temp = new int[right - left + 1];//临时缓存序列
        //将左右子序列合并保存在临时序列中
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[t++] = arr[j++];
            } else {
                temp[t++] = arr[i++];
            }
        }
        //将左序列剩余元素放入临时序列
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        //将右序列剩余元素放入临时序列
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //将临时序列元素复制到原序列中
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    /**
     * 快速排序：
     */
    public static void quickSort(int[] arr) {

    }

    public static void main(String[] args) {
        int[] arr = new int[9];
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        NormalAlgo.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
