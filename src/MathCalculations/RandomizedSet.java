package MathCalculations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    
    ArrayList<Integer> database;
    Map<Integer, Integer> values; // values, index
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.database = new ArrayList<>();
        this.values = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(values.containsKey(val)) return false;
        database.add(val);
        values.put(val, database.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!values.containsKey(val)) return false;
        int i = values.get(val);
        int size = database.size()-1;
        if(i == size) {
            database.remove(i);
        } else {
            int last = database.get(size);
            database.set(i, last);
            database.remove(size);
            values.put(last, i);
        }
        values.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        int rand = r.nextInt(database.size());
        // int rand = 0 + (int)(Math.random() * (database.size() - 0));
        return database.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */