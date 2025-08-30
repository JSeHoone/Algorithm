import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class RandomizedSet {
    List<Integer> value = new ArrayList<>();
    Random rand = new Random();

    public RandomizedSet() {

    }
    
    public boolean insert(int val) {
        if (this.value.contains(val)) {
            return false;
        } else {
            this.value.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (this.value.contains(val)) {
            this.value.remove(Integer.valueOf(val)); 
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        int randIndex = this.rand.nextInt(this.value.size());
        return this.value.get(randIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */