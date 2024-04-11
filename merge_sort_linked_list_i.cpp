class Solution{
public:
    //Function to sort the given linked list using Merge Sort.
    Node* mergeBoth(Node* first, Node* second){
        if(first == nullptr) return second;
        else if(second == nullptr) return first;
        Node* result = nullptr;
        if(first->data <= second->data){
            result = first;
            result->next = mergeBoth(first->next, second);
        }
        else{
            result = second;
            result->next = mergeBoth(first, second->next);
        }
        return result;
    }
    void findMiddle(Node* curr, Node** first, Node** second) {
        if (!curr || !curr->next) {
            *first = curr;
            *second = nullptr;
            return;
        }

        Node* slow = curr;
        Node* fast = curr->next;

        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }

        *first = curr;
        *second = slow->next;
        slow->next = nullptr;
    }

    void mergeSorting(Node** head){
        Node* curr = *head;
        if(curr == nullptr || curr->next == nullptr) return;
        Node* first;
        Node* second;
        findMiddle(curr, &first, &second);
        mergeSorting(&first);
        mergeSorting(&second);
        *head = mergeBoth(first, second);
    }
    Node* mergeSort(Node* head) {
        mergeSorting(&head);
        return head;
    }
};