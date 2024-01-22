class Solution
{
public:
    Node* reverse(Node* head){
        Node* dummy = nullptr;
        while(head != nullptr){
            Node* next = head->next;
            head->next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
    void deleteNodes(Node* &head){
        Node* current = head;
        Node* maxNode = head;
        Node* temp;
        while(current != nullptr && current->next != nullptr){
            if(current->next->data < maxNode->data){
                temp = current->next;
                current->next = temp->next;
                free(temp);
            }
            else{
                current = current->next;
                maxNode = current;
            }
        }
    }
    Node *compute(Node *head)
    {
        head = reverse(head);
        deleteNodes(head);
        Node* result = reverse(head);
        return result;
    }

};
   