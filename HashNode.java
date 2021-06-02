// 
// Decompiled by Procyon v0.5.36
// 

package hw3;

class HashNode<K, V>
{
    K key;
    V value;
    HashNode<K, V> next;
    
    public HashNode(final K key, final V value) {
        this.key = key;
        this.value = value;
    }
}
