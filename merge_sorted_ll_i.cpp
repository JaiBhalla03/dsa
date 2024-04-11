Node* sortedMerge(Node* head1, Node* head2)
{
    if(head1 == nullptr){
        return head2;
    }
    else if(head2 == nullptr){
        return head1;
    }
    Node* result;
    if(head1->data < head2->data){
        result = new Node(head1->data);
        result->next = sortedMerge(head1->next, head2);
    }
    else{
        result = new Node(head2->data);
        result->next = sortedMerge(head1, head2->next);
    }
    return result;
}  