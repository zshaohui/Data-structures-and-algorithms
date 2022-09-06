package datestructure.hash;

import java.util.Map;

class TestHashMap7{
    public static void main(String[] args) {
        HashMap7<Object, Object> map = new HashMap7<>();
        for (int i = 0; i < 100; i++) {
            map.put(i,i);
        }
    }
}


public class HashMap7<K, V> {

    //DEFAULT_CAPACITY  不给初始容量默认为16
    final int DEFAULT_CAPACITY = 16;

    //扩容因子为0.75
    final float LOAD_FACTOR = 0.75f;

    private int size;

    //元素为链表的数组
    Entry<K, V>[] buckets;

    public HashMap7() {
        this.size = 0;
        this.buckets = new Entry[DEFAULT_CAPACITY];
    }

    public HashMap7(int capacity) {
        this.size = 0;
        this.buckets = new Entry[capacity];
    }


    /**
     * hashmap的添加元素，先看容量够不够，不够就先扩容然后再插入，够了就直接插入
     * 插入用的putVal方法
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        if (size >= buckets.length * LOAD_FACTOR) resize();
        putVal(key, value, buckets);
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public V get(K key) {
        //获取该key在数组的几号位置
        int index = getIndex(key, buckets.length);
        //查看该数组是否为空
        if (buckets[index] == null) return null;
        Entry<K, V> entry = buckets[index];
        //查找链表
        while (entry != null) {
            //看该节点的key的hashcode和字符是不是与传进来的一样，完全相同就直接返回value
            if ((entry.key.hashCode() == key.hashCode())
                    && (entry.key == key || entry.key.equals(key))) {
                return entry.value;
            }
            //不相同的话就查看链表中的下一个元素
            entry = entry.next;
        }
        return null;
    }

    /**
     * 大小扩容
     */
    private void resize() {
        //直接扩容两倍
        Entry<K, V>[] newBuckets = new Entry[buckets.length * 2];
        rehash(newBuckets);
        buckets = newBuckets;
    }

    /**
     * 重新散列
     *
     * @param newBuckets
     */
    private void rehash(Entry<K, V>[] newBuckets) {
        //重置map大小
        size = 0;
        for (int i = 0; i < buckets.length; i++) {
            //看节点是否为空，为空就跳过
            if (buckets[i] == null) {
                continue;
            }
            Entry<K, V> entry = buckets[i];
            //将元素放入新数组中
            putVal(entry.key, entry.value, newBuckets);
        }
    }

    private void putVal(K key, V value, Entry<K, V>[] newBuckets) {
        //现获取元素应该放在数组中几号桶里（数组的几号位置）
        int index = getIndex(key, newBuckets.length);
        //获得该位置的节点
        Entry<K, V> entry = newBuckets[index];
        //如果节点为空 ，说明该位置上没有元素，就直接插入，并对size++
        if (entry == null) {
            newBuckets[index] = new Entry(key, value);
            size++;
            return;
        }
        //如果节点不为空，就使用拉链法，也就是挂在元素后面
        while (entry != null) {
            if ((key.hashCode() == entry.key.hashCode()) && (entry.key == key || entry.key.equals(key))) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }
        //说明数组中该链表上没有与要put的key相同，就创建一个新的Node节点，将数组中对应位置上的节点的next指向自己
        Entry newEntry = new Entry(key, value, newBuckets[index]);
        //将新建的节点放进数组中
        newBuckets[index] = newEntry;
        //记录map的元素的个数
        size++;
    }


    /**
     * hashmap是数组+链表 这个方法是返回元素在数组中的哪个位置，注意是数组
     *
     * @param key
     * @param length
     * @return
     */
    private int getIndex(K key, int length) {
        int hashCode = key.hashCode();
        int index = hashCode % length;
        return Math.abs(index);
    }


    /**
     * 返回map的个数
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 存放的内容
     */
    static class Entry<K, V> implements Map.Entry<K, V> {
        int hash;
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }
}
