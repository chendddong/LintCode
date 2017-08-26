/*  
    There is a building of n floors. If an egg drops from the k th floor or
    above, it will break. If it's dropped from any floor below, it will not
    break.

    You're given two eggs, Find k while minimize the number of drops for the
    worst case. Return the number of drops in the worst case.
*/

/*
    Clarification
    For n = 10, a naive way to find k is drop egg from 1st floor, 2nd floor ...
    kth floor. But in this   worst case (k = 10), you have to drop 10 times.

    Notice that you have two eggs, so you can drop at 4th, 7th & 9th floor, in
    the worst case (for example,   k = 9) you have to drop 4 times.

    Example
    Given n = 10, return 4.
    Given n = 100, return 14.

/*
    Observation: Regardless of how we drop Egg1, Egg2 must do a linear search. i.e., if Egg1 breaks between  floor 10 and 15, 
    we have to check every  floor in between with the Egg2

    How to do the load balancing!!!

    The Approach:
    A First Try: Suppose we drop an egg from the 10th  floor, then the 20th, ...
    » If the  first egg breaks on the  first drop (floor 10), then we have at
    most 10 drops total.
    » If the  first egg breaks on the last drop (floor 100), then we have at most 19 drops total ( floors 10, 20, ...,90, 100, then 91 through 99).
    » That’s pretty good, but all we’ve considered is the absolute worst case. We should do some “load balancing” to make those two cases more even.

    Goal: Create a system for dropping Egg1 so that the most drops required is consistent, whether Egg1 breaks on the  first drop or the last drop.
    1. A perfectly load balanced system would be one in which Drops of Egg1 + Drops of Egg2 is always the same, regardless of where Egg1 broke.
    2. For that to be the case, since each drop of Egg1 takes one more step, Egg2 is allowed one fewer step.
    3. We must, therefore, reduce the number of steps potentially required by Egg2 by one drop each time. For example, if Egg1 is dropped on floor 20 and then floor 30, 
    Egg2 is potentially required to take 9 steps. When we drop Egg1 again, we must reduce potential Egg2 steps to only 8. That is, we must drop Egg1 at  floor 39.
    4. We know, therefore, Egg1 must start at floor X, then go up by X-1  floors, then X-2, ..., until it gets to 100.
    5. Solve for X+(X-1)+(X-2)+...+1 = 100. X(X+1)/2 = 100 -> X = 14
    We go to floor 14, then 27, then 39, ... This takes 14 steps maximum.

 */    
*/

public class Solution {

    public int dropEggs(int n) {
        long ans = 0;
        for (int i = 1; ; ++i) {
            ans += (long) i;
            if (ans >= (long) n)
                return i;
        }
    }
}