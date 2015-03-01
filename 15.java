// Sort the array and for every 'a' item from left to right
// sweep the rest of the array to find 'b' and 'c' as if we were
// solving a twoSum problem
// Update the left and right pointers multiple times to avoid duplicates
// Credits to: https://oj.leetcode.com/discuss/23638/concise-o-n-2-java-solution

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        
        for (int i = 0; i < num.length-2; i++) {
            
            if (i > 0 && num[i] == num[i-1]) // avoid duplicates for the first element
                continue;
            
            int key = -num[i];
            
            // use two pointers to search the rest of the array for the key
            for (int left = i+1, right = num.length-1; left < right;) {
                if (num[left] + num[right] < key) {
                    do { ++left; } while (left < right && num[left] == num[left-1]);
                } else if (num[left] + num[right] > key) {
                    do { --right; } while (right > left && num[right] == num[right+1]);
                } else { // found, num[left] + num[right] == key
                    result.add(Arrays.asList(num[i], num[left], num[right]));
                    do { ++left; } while (left < right && num[left] == num[left-1]);
                    do { --right; } while (right > left && num[right] == num[right+1]);
                }
            }
        }
        
        return result;
    }
}



// Follows my first version using Hashmap and Set
// See also: https://oj.leetcode.com/discuss/10756/my-accepted-o-n-2-solution-without-hashmap
public class Solution {
    
    public class Item {
        private int iidx;
        private int jidx;
        
        public Item(int iidx, int jidx) {
            this.iidx = iidx;
            this.jidx = jidx;
        }
    }
    
    public List<List<Integer>> threeSum(int[] num) {
        
        HashMap<Integer, HashMap> hm = new HashMap<Integer, HashMap>();
        
        // hm is a hasmap storing the sum of all possible combinations between
        // two entries of the array.
        // key: the sum
        // value: the index of the two elements that add up to this sum
        // 
        // problems:
        // 1) a sum can be composed of different numbers (we need to store all combinations that appear)
        // 2) we need to avoid duplicates in these combinations
        
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                Item item = new Item(i, j);
                
                int sum = num[i] + num[j];
                
                HashMap<Integer, Item> ihm = hm.get(sum);
                
                if (ihm == null) {
                    ihm = new HashMap<Integer, Item>();
                    hm.put(sum, ihm);
                }
                
                // I need to avoid storing duplicates.
                // I use the maximum of the two mumbers as a key
                int key = Math.max(num[i], num[j]);
                ihm.put(key, item);
            }
        }
        
        ArrayList<List<Integer>> retList = new ArrayList<List<Integer>>();
        
        Set set = new HashSet();
        
        for (int i = 0; i < num.length; i++) {
            HashMap<Integer, Item> ihm = hm.get(-num[i]);
            
            if (ihm == null)
                continue;
            
            for (Item item : ihm.values()) {    // all the items have the same sum
            
                if (i == item.iidx || i == item.jidx) // make sure the numbers are distinct
                    continue;
                
                // a <= b <= c
                int a = num[i], b = num[item.iidx], c = num[item.jidx];
                
                if (a > b) { int tmp = a; a = b; b = tmp; }
                if (b > c) { int tmp = b; b = c; c = tmp; }
                if (a > b) { int tmp = a; a = b; b = tmp; }
                
                String key = Integer.toString(a) +  Integer.toString(b) + Integer.toString(c);
                
                if (set.contains(key))
                    continue;
                
                set.add(key);
                
                ArrayList<Integer> row = new ArrayList<Integer>();
                row.add(a);
                row.add(b);
                row.add(c);
                retList.add(row);
                
            }
        }
        
        return retList;
    }
}
