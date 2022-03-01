import java.util.Stack;

/*
There are ‘N’ people at a party. Each person has been assigned a unique id between 0 to 'N' - 1(both inclusive). A celebrity is a person who is known to everyone but does not know anyone at the party.
Given a helper function ‘knows(A, B)’, It will returns "true" if the person having id ‘A’ know the person having id ‘B’ in the party, "false" otherwise. Your task is to find out the celebrity at the party. Print the id of the celebrity, if there is no celebrity at the party then print -1.
Note:
1. The helper function ‘knows’ is already implemented for you.
2. ‘knows(A, B)’ returns "false", if A doesn't know B.
3. You should not implement helper function ‘knows’, or speculate about its implementation.
4. You should minimize the number of calls to function ‘knows(A, B)’.
5. There are at least 2 people at the party.
6. At most one celebrity will exist.
*/

public class FindCelebrity_CodingNinja {
    static class Runner {
        public static boolean knows(int i, int j){
            return true;
        }
    }
    public static int findCelebrityStack(int n) {
        // Create a stack and push all ids in it.
        Stack<Integer> ids = new Stack<Integer>();
        for(int i = 0; i < n; i++) {
            ids.push(i);
        }

        // Finding celebrity.
        while(ids.size() > 1) {
            int id1 = ids.peek();
            ids.pop();
            int id2 = ids.peek();
            ids.pop();

            if(Runner.knows(id1, id2)) {
                // Because person with id1 can not be celebrity.
                ids.push(id2);
            }
            else {
                // Because person with id2 can not be celebrity.
                ids.push(id1);
            }
        }

        int celebrity = ids.peek();
        boolean knowAny = false, knownToAll = true;

        // Verify whether the celebrity knows any other person.
        for(int i = 0; i < n; i++) {
            if(Runner.knows(celebrity, i)) {
                knowAny = true;
                break;
            }
        }

        // Verify whether the celebrity is known to all the other person.
        for(int i = 0; i < n; i++) {
            if(i != celebrity && !Runner.knows(i, celebrity)) {
                knownToAll = false;
                break;
            }
        }

        if(knowAny || !knownToAll) {
            // If verificatin failed, then it means there is no celebrity at the party.
            celebrity = -1;
        }

        return celebrity;
    }

    public static int findCelebrityTwoPointer(int n) {

        // Two pointers pointing at start and end of search space.
        int p = 0, q = n - 1;

        // Finding celebrity.
        while(p < q) {
            if(Runner.knows(p, q)) {
                // This means p cannot be celebrity.
                p++;
            }
            else {
                // This means q cannot be celebrity.
                q--;
            }
        }

        int celebrity = p;
        boolean knowAny = false, knownToAll = true;

        // Verify whether the celebrity knows any other person.
        for(int i = 0; i < n; i++) {
            if(Runner.knows(celebrity, i)) {
                knowAny = true;
                break;
            }
        }

        // Verify whether the celebrity is known to all the other person.
        for(int i = 0; i < n; i++) {
            if(i != celebrity && !Runner.knows(i, celebrity)) {
                knownToAll = false;
                break;
            }
        }

        if(knowAny || !knownToAll) {
            // If verificatin failed, then it means there is no celebrity at the party.
            celebrity = -1;
        }

        return celebrity;
    }


}
