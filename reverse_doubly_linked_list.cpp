class Solution
{
public:
    Node* reverseDLL(Node * head)
    {
        if(head == nullptr || head->next == nullptr) return head;
        Node* temp = head;
        Node* last = head;
        while(last->next != nullptr){
            last = last->next;
        }
        while(temp != last && last->next != temp){
            int t = temp->data;
            temp->data = last->data;
            last->data = t;
            temp = temp->next;
            last = last->prev;
        }
        return head;
    }
};
