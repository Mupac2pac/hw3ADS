// 
// Decompiled by Procyon v0.5.36
// 

package hw3;

public class MergeSort
{
    public static <T extends Comparable<T>> void sort(final T[] a) {
        mergesort(a, 0, a.length - 1);
    }
    
    private static <T extends Comparable<T>> void mergesort(final T[] a, final int i, final int j) {
        if (j - i < 1) {
            return;
        }
        final int mid = (i + j) / 2;
        mergesort((Comparable[])a, i, mid);
        mergesort((Comparable[])a, mid + 1, j);
        merge(a, i, mid, j);
    }
    
    private static <T extends Comparable<T>> void merge(final T[] a, final int p, final int mid, final int q) {
        final Object[] tmp = new Object[q - p + 1];
        int i = p;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= q) {
            if (a[i].compareTo(a[j]) <= 0) {
                tmp[k] = a[i++];
            }
            else {
                tmp[k] = a[j++];
            }
            ++k;
        }
        if (i <= mid) {
            while (i <= mid) {
                tmp[k++] = a[i++];
            }
        }
        else {
            while (j <= q) {
                tmp[k++] = a[j++];
            }
        }
        for (k = 0; k < tmp.length; ++k) {
            a[k + p] = (T)tmp[k];
        }
    }
    
    public static void main(final String[] args) {
        final Integer[] a = { 2, 1, 4, 3, -1, 5, 9 };
        sort(a);
        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i].toString());
        }
    }
}
