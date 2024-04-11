class Solution
{
public:
    //Function to remove duplicates from unsorted linked list.
    Node * removeDuplicates( Node *head)
    {
        if(head == nullptr || head->next == nullptr ) return head;
        Node* curr = head;
        Node* prev = nullptr;
        unordered_set<int> seen;
        while(curr != nullptr){
            if(seen.find(curr->data) != seen.end()){
                prev->next = curr->next;
                free(curr);
            }
            else{
                seen.insert(curr->data);
                prev = curr;
            }
            curr = prev->next;
        }
        return head;
    }
};