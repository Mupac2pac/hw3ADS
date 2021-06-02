// 
// Decompiled by Procyon v0.5.36
// 

package hw3;

public class QuickSort
{
    public static <T extends Comparable<T>> void sort(final T[] a) {
        quicksort(a, 0, a.length - 1);
    }
    
    private static <T extends Comparable<T>> void quicksort(final T[] a, final int i, final int j) {
        if (i < j) {
            final int l = partition(a, i, j);
            quicksort((Comparable[])a, i, l);
            quicksort((Comparable[])a, l + 1, j);
        }
    }
    
    private static <T extends Comparable<T>> int partition(final T[] a, final int p, final int q) {
        T x = a[p];
        final int m = (p + q) / 2;
        if ((a[p].compareTo(a[m]) <= 0 && a[m].compareTo(a[q]) <= 0) || (a[q].compareTo(a[m]) <= 0 && a[m].compareTo(a[p]) <= 0)) {
            x = a[m];
        }
        if ((a[p].compareTo(a[q]) <= 0 && a[q].compareTo(a[m]) <= 0) || (a[m].compareTo(a[q]) <= 0 && a[q].compareTo(a[p]) <= 0)) {
            x = a[q];
        }
        int i = p - 1;
        int j = q + 1;
        while (true) {
            if (++i > q || a[i].compareTo(x) >= 0) {
                while (--j >= p && a[j].compareTo(x) > 0) {}
                if (i >= j) {
                    break;
                }
                swap(a, i, j);
            }
        }
        return j;
    }
    
    private static <T extends Comparable<T>> void swap(final T[] a, final int i, final int j) {
        final T x = a[i];
        a[i] = a[j];
        a[j] = x;
    }
    
    public static void main(final String[] args) {
        final Integer[] a = { 6, 7, 2, 8, 1, 2, 4, 3, 5 };
        sort(a);
        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i].toString());
        }
    }
}
