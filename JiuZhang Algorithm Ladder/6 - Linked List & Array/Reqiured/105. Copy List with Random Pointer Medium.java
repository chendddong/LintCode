// A linked list is given such that each node contains an additional random 
// pointer which could point to any node in the list or null. 
// Return a deep copy of the list.

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<RandomListNode, RandomListNode> map = 
        new HashMap<RandomListNode, RandomListNode>();

        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy, newNode;

        while (head != null) {
            if (map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }

            pre.next = newNode;

            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }

            pre = newNode;
            head = head.next;
        }

        return dummy.next;
    }
}


// A linked list is given such that each node contains an additional random 
// pointer which could point to any node in the list or null. 
// Return a deep copy of the list.

/*第一遍扫的时候巧妙运用next指针， 开始数组是1->2->3->4  。 
然后扫描过程中 先建立copy节点 1->1`->2->2`->3->3`->4->4`, 
然后第二遍copy的时候去建立边的copy， 
拆分节点, 一边扫描一边拆成两个链表，这里用到两个dummy node。
第一个链表变回  1->2->3 , 然后第二变成 1`->2`->3`  */
//No HashMap version
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        copyNext(head);
        copyRadom(head);
        return splitList(head);
    }

    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }

    private void copyRadom(head) {
        while (head != null) {
            if (head.next.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    private RandomListNode splitList(RandomListNode head) {
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return newHead;
    }


}