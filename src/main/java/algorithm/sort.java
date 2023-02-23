package algorithm;

import java.util.Arrays;

/**
 * 정렬 알고리즘에 대한 설명
 */
public class sort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4, 11, 15, 14, 9, 8, 13, 6, 10, 7, 12};
        int[] temp = new int[arr.length];
        long start = System.currentTimeMillis();
//        bubbleSort(arr);
//        insertionSort(arr);
//        selectionSort(arr);
        mergeSort(arr, temp, 0, arr.length - 1);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr));
        System.out.printf("걸린시간 : %d(ms)", end - start);
    }

    /* 버블 정렬*/
    private static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /* 두개의 엘리멘트 서로 변경 */
    private static void swap(int[] arr, int prev, int curr) {
        int temp = arr[curr];
        arr[curr] = arr[prev];
        arr[prev] = temp;
    }

    /* 삽입정렬 */
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > temp) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = temp;
        }
    }

    /* 선택정렬 */
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }

    /* 병합정렬 */
    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left == right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);

        merge(arr,temp,left,mid,right);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[idx] = arr[l];
                l++;
            } else {
                temp[idx] = arr[r];
                r++;
            }
            idx++;
        }

        if (l > mid) {
            while (r <= right) {
                temp[idx] = arr[r];
                idx++;
                r++;
            }
        } else {
            while (l <= mid) {
                temp[idx] = arr[l];
                idx++;
                l++;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
