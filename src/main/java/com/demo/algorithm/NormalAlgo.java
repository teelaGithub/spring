package com.demo.algorithm;

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
     * 归并排序：
     */
    public static void mergeSort(int[] arr) {
        
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
            System.out.printf("%2d ", arr[i]);
        }
        System.out.println();
        NormalAlgo.shellSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%2d ", arr[i]);
        }
        System.out.println();
    }
}
