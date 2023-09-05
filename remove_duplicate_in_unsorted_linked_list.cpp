
class Solution
{
public:
    //Function to remove duplicates from unsorted linked list.
    Node * removeDuplicates( Node *head)
    {
        Node* current = head;
        Node* prev  =nullptr;
        unordered_set<int> seen;
        while(current != nullptr){
            if(seen.find(current->data) != seen.end()){
                prev->next = current->next;
                delete(current);
            }
            else{
                seen.insert(current->data);
                prev = current;
            }
            current = prev->next;
        }
        return head;
    }
};
