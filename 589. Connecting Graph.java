/* 
    Another approach is to use BFS 
    合并 / 连边 想到用 Union Find
    
    初始化的时候自成老大哥
    
    [1,2,3,4,5]
    [1,2,3,4,5]
    
    update the array when applying the union
    
    connect O(1)
    query O(1)
    
    k query total is O(k)
    
    What can UF do:
        1. if a and b are connected
 */ 


/**
 * Given n nodes in a graph labeled from 1 to n. There is no edges in the graph
 * at beginning.
 */

/*
    You need to support the following method:
    1. connect(a, b), add an edge to connect node a and node b. 2.query(a, b), check if two nodes are connected

    Example
    5 // n = 5
    query(1, 2) return false
    connect(1, 2)
    query(1, 3) return false
    connect(2, 4)
    query(1, 4) return true
 */


public class ConnectingGraph { 
    /* 
        Another approach to solve this problem is to use BFS.
        When there is words like combine / merge, we must come up with Union
        Find.
        
        When we initialize the father, we treat each one of them as
        their father.

        Example: 

        father:
        [1,2,3,4,5]
        [1,2,3,4,5]
        
        Then we update the array when applying the union:
        
        Running time for both actions

        connect O(1)
        query O(1)
        
        When there are k queries total is O(k)
        
        What can UF do:
            1. if a and b are connected (graph)

        Note:
            This is the basic template of Union Find. 
            Must be familiar with this!
     */
    
    /* 
        Technically speaking, there's no such thing as a null array; but since arrays are objects, array types are reference types (that is: array variables just hold references to arrays), and this means that an array variable can be null rather than actually pointing to an array:

        int[] notAnArray = null;
        An empty array is an array of length zero; it has no elements:

        int[] emptyArray = new int[0];
        (and can never have elements, because an array's length never changes after it's created).

        Here we just treat the array father as an object and the first element
        of the father father[0] is the reference of the array. And if we would
        like to modify the array latter, we have to 're-initialize' later and
        using the index from 1.
     */ 
    private int[] father = null;
    public ConnectingGraph(int n) {
        /* Re-initialize the array */
        father = new int[n + 1];
        /* Assign the numbers themselves as their father the first time */
        for (int i = 1; i < n + 1; ++i) {
            father[i] = i;
        }
    }
    /* Find */
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }     
    /* Union */
    public void connect(int a, int b) {
        int root_a = find(a); 
        int root_b = find(b); 
        if (root_a != root_b) {
            father[root_a] = root_b;
        }
    }    
    /* Search */
    public boolean  query(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        return root_a == root_b;
    }
}

/*
    Algorithm walk through:

    State 0: Initial state
        
        Graph:

        ++++++++++
        1 2 3 4 5 
        ++++++++++

        father:
        
        -------------------
        1 | 2 | 3 | 4 | 5 |
        -------------------
        1 | 2 | 3 | 4 | 5 |
        -------------------

    State 1: connect(1, 4)

        Graph:

        ++++++++++
        1--4 
             3
        5 2  
        ++++++++++

        father:
        
        -------------------
        1 | 2 | 3 | 4 | 5 |
        -------------------
        4 | 2 | 3 | 4 | 5 |
        -------------------

    State 2: connect(2, 4)

        Graph:

        ++++++++++
        1--4
            \
             2
        5  3  
        ++++++++++

        father:
        
        -------------------
        1 | 2 | 3 | 4 | 5 |
        -------------------
        4 | 4 | 3 | 4 | 5 |
        -------------------            


    State 3: connect(1, 5)

        Graph:

        ++++++++++
        1--4
        |    \
        |     2
        5  3  
        ++++++++++

        father:

        -------------------
        1 | 2 | 3 | 4 | 5 |
        -------------------
        4 | 4 | 3 | 5 | 5 |
        -------------------              
            


    State 4: connect(4, 3)

        Graph:

        ++++++++++
        1--4
        |  | \
        |  |  2
        5  3  
        ++++++++++

        father:
        
        -------------------
        1 | 2 | 3 | 4 | 5 |
        -------------------
        4 | 4 | 3 | 5 | 5 |
        -------------------    

    State 4: query(4, 3)

        Graph:

        ++++++++++
        1--4
        |  | \
        |  |  2
        5  3  
        ++++++++++

        father:
        
        -------------------
        1 | 2 | 3 | 4 | 5 |
        -------------------
        4 | 4 | 3 | 3 | 3 |
        -------------------  

    State 5: query(1, 2)

        Graph:

        ++++++++++
        1--4
        |  | \
        |  |  2
        5  3  
        ++++++++++

        father:
        
        -------------------
        1 | 2 | 3 | 4 | 5 |
        -------------------
        3 | 3 | 3 | 3 | 3 |
        -------------------                         
       

 */