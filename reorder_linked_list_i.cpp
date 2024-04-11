/*

The structure of linked list is the following

struct Node
{
    int data;
    Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }
};
*/

Node* reverse(Node* head){
    Node* dummy = nullptr;
    while(head){
        Node* next = head->next;
        head->next = dummy;
        dummy = head;
        head = next;
    }
    return dummy;
}


Node *inPlace(Node *root)
{
    //finding the middle element
    Node* slow = root;
    Node* fast = root;
    while(fast != nullptr && fast->next != nullptr){
        slow = slow->next;
        fast = fast->next->next;
    }
    //spliting the linked list
    Node* h1 = root;
    Node* head2 = slow->next;
    slow->next = nullptr;
    //reverse the second half
    Node* h2 = reverse(head2);
    //merge the 2 list alternatively
    Node* h = new Node(0);
    Node* curr = h;
    while(h1 || h2){
        if(h1){
            curr->next = h1;
            curr = curr->next;
            h1 = h1->next;
        }
        if(h2){
            curr->next = h2;
            curr = curr->next;
            h2 = h2->next;
        }
    }
    return h->next;
}
