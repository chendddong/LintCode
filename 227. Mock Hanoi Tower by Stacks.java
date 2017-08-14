public class Tower {
    private Stack<Integer> disks;
    // create three towers (i from 0 to 2)
    public Tower(int i) {
        disks = new Stack<Integer>();
    }
    
    // Add a disk into this tower
    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }
    
    // @param t a tower
    // Move the top disk of this tower to the top of t.
    public void moveTopTo(Tower t) {
        int top = disks.pop();
        t.add(top);
    }
    
    // @param n an integer
    // @param destination a tower
    // @param buffer a tower
    // Move n Disks from this tower to destination by buffer tower
    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }

    public Stack<Integer> getDisks() {
        return disks;
    }
}
/**
 * Your Tower object will be instantiated and called as such:
 * Tower[] towers = new Tower[3];   
 * for (int i = 0; i < 3; i++) towers[i] = new Tower(i);
 * for (int i = n - 1; i >= 0; i--) towers[0].add(i);   
 * towers[0].moveDisks(n, towers[2], towers[1]);
 * print towers[0], towers[1], towers[2]
*/
