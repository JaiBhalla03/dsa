class Solution{
public:
    int i = 0;
    void solve(Node* &root, string str){
        if(i < str.size() && isdigit(str[i])){
            int sum = 0;
            while(i < str.size() && isdigit(str[i])){
                sum*=10;
                sum+=str[i]-'0';
                i++;
            }
            root->data = sum;
        }
        if(i < str.size() && str[i] == '('){
            root->left = new Node(0);
            i++;
            solve(root->left, str);
            if(root->left->data == 0) root->left = nullptr;
        }
        if(i < str.size() && str[i] == '('){
            root->right = new Node(0);
            i++;
            solve(root->right, str);
            if(root->right->data == 0) root->right = nullptr;
        }
        if(i >= str.size() || str[i] == ')'){
            i++;
            return;
        }
    }
    // function to construct tree from string
    Node *treeFromString(string str){
        Node* root = new Node(0);
        solve(root, str);
        return root;
    }
};
