class Solution{
public:
    Node* divide(int N, Node *head){
        Node* evenStart = nullptr;
        Node* oddStart = nullptr;
        Node* evenEnd = nullptr;
        Node* oddEnd = nullptr;
        Node* curr = head;
        while(curr != nullptr){
            if(curr->data % 2 == 0){
                if(evenStart == nullptr){
                    evenStart = curr;
                    evenEnd = evenStart;
                }
                else{
                    evenEnd->next = curr;
                    evenEnd = evenEnd->next;
                }
            }
            else{
                if(oddStart == nullptr){
                    oddStart = curr;
                    oddEnd = oddStart;
                }
                else{
                    oddEnd->next = curr;
                    oddEnd = oddEnd->next;
                }
            }
            curr = curr->next;
        }
        if(evenStart == nullptr || oddStart == nullptr) return head;
        evenEnd->next = oddStart;
        oddEnd->next = nullptr;
        return evenStart;
    }
};