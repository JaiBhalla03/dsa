class Solution
{
public:
    Node* reverseDLL(Node * head)
    {
        Node* left = head;
        Node* right = head;
        while(right->next != nullptr){
            right = right->next;
        }
        Node* slow = head; Node* fast = head;
        while(fast && fast->next){
            fast = fast->next->next;
            slow = slow->next;
        }
        while(left->next != slow->next){
            int temp = left->data;
            left->data = right->data;
            right->data = temp;
            left = left->next;
            right = right->prev;
        }
        return head;
    }
};