package com.company;

public class SHM<K, V> implements ISHM<K, V> {

    private Node[] buckets;

    private Node getExistedNode(Node head, Object key){
        if (head == null)
        {
            return null;
        }

        if (head.getKey().equals(key)){
            return head;
        }
        return getExistedNode(head.getNextNode(), key);
    }

    private Node getPreviousNode(Node head, Object key){
        if (head == null)
        {
            return null;
        }
        Node nextNode = head.getNextNode();

        if (nextNode == null){
            return null;
        }

        if (head.getKey().equals(key)){
            return null;
        }

        if (nextNode.getKey().equals(key)){
            return head;
        }
        return getPreviousNode(head.getNextNode(), key);
    }

    public SHM(){
        buckets = new Node[10];
    }

    public SHM(int initialSize){
        buckets = new Node[initialSize];
    }

    private static int getBucketIndex(int initialSize, int hashCode) {
        long max = Integer.MAX_VALUE;
        long min = Integer.MIN_VALUE;

        int result = (int)((max - ((long) hashCode)) / ((max - min) / (long) initialSize));
        return result > initialSize - 1 ? initialSize - 1 : result;
    }

    @Override
    public Object get(K key) {
        int index = getBucketIndex(buckets.length, key.hashCode());
        Node bucket = buckets[index];
        if (bucket == null){
            return null;
        } else {
            Node existedNode = getExistedNode(bucket, key);
            if (existedNode == null)
            {
                return null;
            } else {
                return existedNode.getValue();
            }

        }

    }

    @Override
    public void put(K key, V val) {
        int index = getBucketIndex(buckets.length, key.hashCode());
        if (index > buckets.length - 1 || index < 0) {
            throw new RuntimeException("here " + index + " code " + key.hashCode());
        }
        Node bucket = buckets[index];
        if (bucket == null){
            buckets[index] = new Node(key, val);
        } else {
            Node existedNode = getExistedNode(bucket, key);
            if (existedNode == null)
            {
                Node newHead = new Node(key, val);
                newHead.setNextNode(bucket);
                buckets[index] = newHead;
            } else {
                existedNode.setValue(val);
            }
        }
    }

    @Override
    public void remove(K key) {
        int index = getBucketIndex(buckets.length, key.hashCode());
        Node bucket = buckets[index];
        if (bucket != null){
            Node existedNode = getExistedNode(bucket, key);
            Node previousNode = getPreviousNode(bucket, key);

            if (existedNode != null)
            {
                if (previousNode == null){
                    if (existedNode.getNextNode() == null){
                        buckets[index] = null;
                    } else {
                        buckets[index] = existedNode.getNextNode();
                        existedNode = null;
                        System.out.println("First node in bucket");
                    }
                } else {
                    previousNode.setNextNode(existedNode.getNextNode());
                    existedNode = null;
                }
            }
        }
    }
}
