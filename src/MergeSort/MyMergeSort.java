package MergeSort;

public class MyMergeSort {

    private static void merge(int[] arr, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = 0;

        int[] temp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= r) {
            temp[k++] = arr[j++];
        }

        // Copy temp to arr
        for (i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
