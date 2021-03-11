##Back Tracking: Important pointers   

Solving a backtracking problem is actually a traversal process of a decision tree.
You only need to think about 3 questions:
1. **Path**: It is the choice that has been made.
2. **Selection list**: that is, the choices you can make currently.
3. **End condition**: It is the condition that reaches the bottom of the decision tree and can no longer make a choice.

- The core is the recursion in the for loop. 
It is very simple to "make a selection" before the recursive call, and "cancel the selection" after the recursive call.


- As long as we make a choice before the recursion and cancel the choice just now after the recursion , we can get the selection list and path of each node correctly.

### Tree traversal template 
``` java
treeTraversal(TreeNode node) {

	for (TreeNode child : node.getChildren()) {
		treeTraversal(child);
	}
}
```

- Unlike dynamic programming, which has overlapping sub-problems that can be optimized, 
the backtracking algorithm is purely brute force and the complexity is generally high.  
  

- In fact, think about it, are backtracking algorithms a bit similar to dynamic programming? We have repeatedly emphasized in the series of dynamic programming articles that the three points of dynamic programming that need to be clear are "state", "selection" and "base case". Does it correspond to the "path" that has been traveled, and the current "selection list" "And "End Condition"?


- To some extent, the brute force solution phase of dynamic programming is the backtracking algorithm. It's just that some problems have the nature of overlapping sub-problems, which can be optimized with dp table or memo to sharply prun the recursive tree, which becomes dynamic programming


- It's better to detect invalid cases as soon as possible.