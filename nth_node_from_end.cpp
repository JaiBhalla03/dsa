class Solution{
public:
    int getNthFromLast(Node *head, int n)
    {
        Node* temp = head;
        int len = 0;
        while(temp){
            temp = temp->next;
            len++;
        }
        if(n > len) return -1;
        int count = len - n;
        temp = head;
        while(count != 0){
            temp = temp->next;
            count--;
        }
        return temp->data;
    }
};
