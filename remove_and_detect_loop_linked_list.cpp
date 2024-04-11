class Solution
{
public:
    //Function to remove a loop in the linked list.
    void removeLoop(Node* head)
    {
        //base case
        if(head == nullptr || head->next == nullptr) return;
        //detect the loop in the linked list
        Node* slow = head;
        Node* fast = head;
        while(fast != nullptr && fast->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;
            if(slow == fast) break;
        }
        //if the loop was present
        if(slow == fast){
            slow = head;
            if(slow == fast){
                while(fast->next != slow) fast = fast->next;
            }
            else{
                while(slow->next != fast->next){
                    fast = fast->next;
                    slow = slow->next;
                }
            }
            fast->next = nullptr;
        }

    }
};