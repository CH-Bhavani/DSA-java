/*

Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 

Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
 

Constraints:

0 <= key <= 106
At most 104 calls will be made to add, remove, and contains.
*/
class MyHashSet {

//private Boolean isExist = false;
private int[] HS = new int[1000001]; //problem this is if we have 0 in test

/** Initialize your data structure here. */
public MyHashSet() {
    
}

public void add(int key) {
    HS[key] = key;
    
    //for 0
    if (key == 0){
        HS[key] = -1;
    }
    
}

public void remove(int key) {
    HS[key] = -2;
    
}

/** Returns true if this set contains the specified element */
public boolean contains(int key) {
    if(key == 0){
        if(HS[key] == -1){
            return true;
        }
    }
    else{
        if(HS[key] == key){
            return true;
        }
    }

    return false;
 }
}



//sol 2




class MyHashSet {
    List<Integer> l;
    public MyHashSet() {
       l=new ArrayList<>(); 
    }
    
    public void add(int key) {
        if(!l.contains(key))
            l.add(key);
    }
    
    public void remove(int key) {
        if(l.contains(key))
            l.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return l.contains(key);
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
