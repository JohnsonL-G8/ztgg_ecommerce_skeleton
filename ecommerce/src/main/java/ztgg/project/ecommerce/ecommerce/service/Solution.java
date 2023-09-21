package ztgg.project.ecommerce.ecommerce.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

class Solution {
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int  n = receiver.size();
        DisjoinSet uf = new DisjoinSet(n);
        for(int i = 0; i < receiver.size(); i++) {
            uf.union(i, receiver.get(i));
        }

        HashMap<Integer, TreeSet> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int key = uf.find(i);
            TreeSet<Integer> set = map.getOrDefault(key, new TreeSet<>());
            set.add(i);
            map.put(key, set);
        }

        int result = 0;

        for(Integer key : map.keySet()) {
            int curResult = 0;
            TreeSet<Integer> set = map.get(key);
            TreeSet<Integer> reverseSet = (TreeSet) set.descendingSet();
            List<Integer> list = new ArrayList<>();
            for(Integer num : reverseSet) {
                list.add(num);
            }
            for(int i = 0; i < k; i++) {
                curResult += list.get(i % list.size());
            }
            result = Math.max(result, curResult);
        }

        return result;
    }



    class DisjoinSet {
        private int[] id;
        private int count;

        public DisjoinSet(int size) {
            id = new int[size];
            for(int i = 0; i < size; i++)
                id[i] = i;
        }

        private int find(int p) {
            // 寻找p节点所在组的根节点，根节点具有性质id[root] = root
            while (p != id[p]) p = id[p];
            return p;
        }

        public void union(int p, int q) {
            // Give p and q the same root.
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot)
                return;
            // 将一棵树(即一个组)变成另外一课树(即一个组)的子树
            id[pRoot] = qRoot;
            count--;
        }
    }
}
