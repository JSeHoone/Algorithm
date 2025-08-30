class RandomizedSet {
    private final ArrayList<Integer> arr = new ArrayList<>();
    private final HashMap<Integer, Integer> idx = new HashMap<>();
    private final Random rand = new Random();

    public RandomizedSet() {

    }
    
    public boolean insert(int val) {
        if (idx.containsKey(val)) return false;
        idx.put(val, arr.size());
        arr.add(val);
        return true;
    }

    public boolean remove(int val) {
        Integer i = idx.get(val);
        if (i == null) return false;

        int lastIdx = arr.size() - 1;
        int lastVal = arr.get(lastIdx);

        
        arr.set(i, lastVal);
        idx.put(lastVal, i);

        arr.remove(lastIdx);
        idx.remove(val);
        return true;
    }

    public int getRandom() {
        int i = rand.nextInt(arr.size());
        return arr.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */