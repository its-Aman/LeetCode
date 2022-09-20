/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        return distanceK_hashmap(root, target, k);
        return distanceK_dfs(root, target, k);
    }

    public List<Integer> distanceK_dfs(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();

        if (k == 0)
            ans.add(target.val);
        else
            dfs(ans, root, target.val, k, 0);

        return ans;
    }

    private int dfs(List<Integer> res, TreeNode node, int target, int K, int depth) {

        //This is for handling cases when the tree is empty (or) you reach the left and right branch of leaf node.
        //When tree is empty we will not be able to travel k distance or it wont have a target node, so we return 0.
        //When we reach the left and right node of leaf node(leaf node is the last node in the current path) it means there is no further nodes to add to solution which are at distance K 
        //from root in the current path it followed, so we return 0.

        if (node == null) return 0;

        //When we reach the distance K from target node in the current path, we add it to the solution vector and return 0 because we are not going to travel further in this path as we 
        //have already reached distance K from target node.

        if (depth == K) {
            res.add(node.val);
            return 0;
        }

        //These left and right variables are created because we need the distance from target node for nodes that are above the target node(here above the target node means parent 
        //node/ancestor nodes of target node).The nodes that are ancestors of target node will use this distance and subtract this distance from K to calculate nodes that are at the other 
        //branch of it with distance (K-distance from target node of current node) 

        //eg: in the below tree if 3 is the target node and K=2, after recursing down the target node and adding node 1(which is at distance K=2 from target node 3) to the answer, 
        //control reaches back to node 3, node 3 returns value of 1 to node 5 because node 5 is at distance 1 from node 3. Now, node 5 subtracts this value 1 from K(=2) which gives 
        //1(K-1) as result. Then node 5 searches nodes at distance 1 on its right side(which is node 8) and that will be added to the result
        /*
                         5
                       /   \
                      3     8
                    /   \
                   2     4
                 /
                1
         */

        int left, right;

        //Here if condition evaluates nodes that are below the target node(descendants of target node) and else condition is for evaluating the nodes that are above the target 
        //node(parent/ancestors of target node)

        //we have node.val==target in IF condition because until we reach the target node we cant increase the depth variable because here depth is the height of each node from target 
        //node below the target node(for descendant nodes of target node)
        //we have depth>0 in IF condition because depth will be greater than 0 when we have already reached the target node in recursion and when we are in search of nodes at 
        //distance K from target node below the target node(i.e , when we are in search of descendant nodes of target node that are at distance K from target node)
        //The need for these two conditions is only once node.val==target condition is true(i.e , when we reach the target node for first time in recursion) and the remaining times when 
        //we want to detect if the control is below the target node searching for its descendants at distance K ,the depth variable is the only indicator because we increment depth 
        //variable only in IF condition(observe depth variable being passed in ELSE condition) 

        //The ELSE part is very simple, it just traverses over the tree until we reach the target node and it passes depth variable without incrementing because here depth variable denotes 
        //the distance of nodes below target node from target node and since we are currently above target node we don't increment it.

        if (node.val == target || depth > 0) {
            left = dfs(res, node.left, target, K, depth + 1);
            right = dfs(res, node.right, target, K, depth + 1);
        } else {
            left = dfs(res, node.left, target, K, depth);
            right = dfs(res, node.right, target, K, depth);
        }

        //This condition is mainly to distinguish when the descendants of target node that are distance K has been added to the result vector and the control has recursed back to the 
        //target node and now we need to calculate the nodes at distance K above the target node.We return 1 here because this 1 will be a indication that the node that receives this 
        //value is at distance 1 above the target node(ancestor at distance 1 from target node (or) simply the parent node of target node)

        if (node.val == target) return 1;


        //This condition is for adding nodes at distance K above the target node(ancestor of target node) to the result vector.As already mentioned above, left and right variable indicates 
        //distance of current nodes above the target node from target node, so when left variable or right variable is equal to K we simply add it to result vector and we return 0 because 
        //we will not go further in this path as already we have found the node that we want.
        //this condition is particularly for the case when value of K is 1 and tree is being traversed above the target node
        if (left == K || right == K) {
            res.add(node.val);
            return 0;
        }

        //when left value is greater than 0 then the current node is currently above the target node(at a ancestor of target node) and the target node is to the left branch of current node 
        // and left variable denotes the distance of current node from the target node(which is in the left branch of current node) so we perform dfs on the right side of current node to 
        //calculate the nodes at distance K from target node(or nodes at distance K-left from current node in its right branch).After dfs we return left+1 because left is the distance of 
        //current node from target node and left+1 will be the distance of current node's parent from target node and we are returning this value to current node's parent.
        //A important point to note is that we pass left+1 as the depth now        

        if (left > 0) {
            dfs(res, node.right, target, K, left + 1);
            return left + 1;
        }


        //when right value is greater than 0 then the current node is currently above the target node(at a ancestor of target node) and the target node is to the right branch of current 
        //node and right variable denotes the distance of current node from the target node(which is in the right branch of current node) so we perform dfs on the left side of current 
        //node to calculate the nodes at distance K from target node(or nodes at distance K-right from current node in its left branch).After dfs we return right+1 because right is the 
        //distance of current node from target node and right+1 will be the distance of current node's parent from target node and we are returning this value to current node's parent.
        //A important point to note is that we pass right+1 as the depth now
        if (right > 0) {
            dfs(res, node.left, target, K, right + 1);
            return right + 1;
        }

        //This is when none of the above condition is true or when all nodes at distance K is added to the result vector and we just have to return some value of no significance

        return 0;
    }

    public List<Integer> distanceK_hashmap(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        setParents(root, parents);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(null);
        q.offer(target);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        seen.add(null);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                if (k == 0) {
                    while (!q.isEmpty())
                        ans.add(q.poll().val);
                    break;
                }
                q.offer(null);
                k--;
            } else {
                if (!seen.contains(curr.left)) {
                    seen.add(curr.left);
                    q.offer(curr.left);
                }
                if (!seen.contains(curr.right)) {
                    seen.add(curr.right);
                    q.offer(curr.right);
                }

                TreeNode parent = parents.get(curr);
                if (!seen.contains(parent)) {
                    seen.add(parent);
                    q.offer(parent);
                }
            }
        }

        return ans;
    }

    private void setParents(TreeNode root, Map<TreeNode, TreeNode> parents) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        parents.put(root, null);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                TreeNode curr = q.poll();

                if (curr.left != null) {
                    q.offer(curr.left);
                    parents.put(curr.left, curr);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                    parents.put(curr.right, curr);
                }
            }
        }
    }

}