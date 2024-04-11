class Solution
{
public:
    //Function to reverse a linked list.
    struct Node* reverseList(struct Node *head)
    {
        struct Node* dummy = nullptr;
        while(head != nullptr){
            struct Node* next = head->next;
            head->next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }

};