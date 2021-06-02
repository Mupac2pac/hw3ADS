// 
// Decompiled by Procyon v0.5.36
// 

package hw3;

import java.util.Iterator;
import java.util.ArrayList;

class Map<K, V>
{
    private ArrayList<HashNode<K, V>> bucketArray;
    private int numBuckets;
    private int size;
    
    public Map() {
        this.bucketArray = new ArrayList<HashNode<K, V>>();
        this.numBuckets = 10;
        this.size = 0;
        for (int i = 0; i < this.numBuckets; ++i) {
            this.bucketArray.add(null);
        }
    }
    
    public int size() {
        return this.size;
    }
    
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    private int getBucketIndex(final K key) {
        final int hashCode = key.hashCode();
        final int index = hashCode % this.numBuckets;
        return index;
    }
    
    public V remove(final K key) {
        final int bucketIndex = this.getBucketIndex(key);
        HashNode<K, V> head = this.bucketArray.get(bucketIndex);
        HashNode<K, V> prev = null;
        while (head != null && !head.key.equals(key)) {
            prev = head;
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        --this.size;
        if (prev != null) {
            prev.next = head.next;
        }
        else {
            this.bucketArray.set(bucketIndex, head.next);
        }
        return head.value;
    }
    
    public V get(final K key) {
        final int bucketIndex = this.getBucketIndex(key);
        for (HashNode<K, V> head = this.bucketArray.get(bucketIndex); head != null; head = head.next) {
            if (head.key.equals(key)) {
                return head.value;
            }
        }
        return null;
    }
    
    public void add(final K key, final V value) {
        final int bucketIndex = this.getBucketIndex(key);
        for (HashNode<K, V> head = this.bucketArray.get(bucketIndex); head != null; head = head.next) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
        }
        ++this.size;
        HashNode<K, V> head = this.bucketArray.get(bucketIndex);
        final HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        this.bucketArray.set(bucketIndex, newNode);
        if (1.0 * this.size / this.numBuckets >= 0.7) {
            final ArrayList<HashNode<K, V>> temp = this.bucketArray;
            this.bucketArray = new ArrayList<HashNode<K, V>>();
            this.numBuckets *= 2;
            this.size = 0;
            for (int i = 0; i < this.numBuckets; ++i) {
                this.bucketArray.add(null);
            }
            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    this.add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
    
    public static void main(final String[] args) {
        final Map<String, Integer> map = new Map<String, Integer>();
        map.add("this", 1);
        map.add("coder", 2);
        map.add("this", 4);
        map.add("hi", 5);
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
