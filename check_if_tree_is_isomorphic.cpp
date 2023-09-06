class Solution {
public:
    bool isIsomorphic(Node *root1, Node *root2) {
        // If both trees are empty, they are isomorphic
        if (root1 == nullptr && root2 == nullptr)
            return true;

        // If one of the trees is empty, they cannot be isomorphic
        if (root1 == nullptr || root2 == nullptr)
            return false;

        // If the data of the current nodes is different, they cannot be isomorphic
        if (root1->data != root2->data)
            return false;

        // Check for isomorphism with the same children order or swapped children order
        return (isIsomorphic(root1->left, root2->left) && isIsomorphic(root1->right, root2->right)) ||
               (isIsomorphic(root1->left, root2->right) && isIsomorphic(root1->right, root2->left));
    }
};
