package Tools;

import java.util.*;


class SortedList implements Iterable<Integer> { // 平衡树

    private final TreeMap<Integer, Integer> map;
    private int size;

    public SortedList() {
        map = new TreeMap<>();
        size = 0;
    }

    public int size() { // 返回元素个数
        return size;
    }

    public boolean isEmpty() { // 判断集合是否为空
        return size == 0;
    }

    public void clear() { // 清空所有元素
        map.clear();
        size = 0;
    }

    public SortedList copy() { // 深拷贝
        SortedList res = new SortedList();
        res.map.putAll(this.map);
        res.size = this.size;
        return res;
    }

    public void add(int val) { // 添加元素
        map.merge(val, 1, Integer::sum);
        size++;
    }

    public void addAll(Collection<Integer> vals) { // 批量添加元素
        for (int val : vals) add(val);
    }

    public void remove(int val) { // 删除元素（如果存在）
        if (!contains(val)) return;
        map.merge(val, -1, Integer::sum);
        if (map.get(val) == 0) map.remove(val);
        size--;
    }

    public void removeAll(Collection<Integer> vals) { // 批量删除元素
        for (int val : vals) remove(val);
    }

    public int pop(int idx) { // 弹出指定下标的元素
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException(String.format("索引: %d, 元素个数: %d", idx, size));
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        int cnt = 0;
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            int key = entry.getKey(), value = entry.getValue();
            if (idx < cnt + value) {
                if (value == 1) it.remove();
                else entry.setValue(value - 1);
                size--;
                return key;
            }
            cnt += value;
        }
        throw new IllegalStateException("无法访问的代码");
    }

    public boolean contains(int val) { // 判断是否包含某个元素
        return map.containsKey(val);
    }

    public int get(int idx) { // 获取指定下标的元素
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException(String.format("索引: %d, 元素个数: %d", idx, size));
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cnt += entry.getValue();
            if (idx < cnt) return entry.getKey();
        }
        throw new IllegalStateException("无法访问的代码");
    }

    public int getMin() { // 获取最小元素
        if (size == 0) throw new NoSuchElementException("集合为空");
        return map.firstKey();
    }

    public int getMax() { // 获取最大元素
        if (size == 0) throw new NoSuchElementException("集合为空");
        return map.lastKey();
    }

    public int count(int val) { // 统计某个元素出现的次数
        return map.getOrDefault(val, 0);
    }

    public int bisectLeft(int val) { // 查找插入位置的左边界（第一个 >=val 的位置）
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.headMap(val).entrySet()) {
            index += entry.getValue();
        }
        return index;
    }

    public int bisectRight(int val) { // 查找插入位置的右边界（第一个 >val 的位置）
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.headMap(val, true).entrySet()) {
            index += entry.getValue();
        }
        return index;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private final Iterator<Map.Entry<Integer, Integer>> entryIter = map.entrySet().iterator();
            private int currCnt = 0;
            private Integer currVal = null;

            @Override
            public boolean hasNext() {
                return currCnt > 0 || entryIter.hasNext();
            }

            @Override
            public Integer next() {
                if (currCnt == 0 && entryIter.hasNext()) {
                    Map.Entry<Integer, Integer> entry = entryIter.next();
                    currVal = entry.getKey();
                    currCnt = entry.getValue();
                }
                if (currCnt <= 0) {
                    throw new NoSuchElementException();
                }
                currCnt--;
                return currVal;
            }
        };
    }
}