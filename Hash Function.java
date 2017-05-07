class Solution {
    public int hashCode(char[] key,int HASH_SIZE) {
        long ans = 0;
        for(int i = 0; i < key.length;i++) {
            ans = (ans * 33 + (int)(key[i])) % HASH_SIZE; 
        }
    return (int)ans;
    }
}

/*
That's the way to write hash functions

E.g.
["abcd"](97,998,99,100);
ans = 0;
ans = 97;
ans = (97*33 + 98) % 1000 = 299;
ans = (299 * 33 + 99) % 1000 = 966;
ans = (966 * 33 + 100) % 1000 = 978;

We use long because if the size of the int Limit.
*/