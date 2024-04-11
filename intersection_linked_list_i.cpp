int intersectPoint(Node* head1, Node* head2)
{
    Node* a = head1;
    Node* b = head2;
    while(a != b){
        a = (a == nullptr) ? head2 : a->next;
        b = (b == nullptr) ? head1 : b->next;
        if(a == nullptr && b == nullptr) return -1;
    }
    return a == nullptr ? -1 : a->data;
}
