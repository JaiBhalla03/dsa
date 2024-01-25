
//Function to sort the given doubly linked list using Merge Sort.
struct Node* mergeBoth(struct Node* first, struct Node* second){
    if(!first) return second;
    else if(!second) return first;
    struct Node* answer = nullptr;
    if(first->data <= second->data){
        answer = first;
        answer->next = mergeBoth(first->next, second);
        if(answer->next){
            answer->next->prev = answer;
        }
    }
    else{
        answer = second;
        answer->next = mergeBoth(first, second->next);
        if(answer->next){
            answer->next->prev = answer;
        }
    }
    return answer;
}

void findMiddle(struct Node* curr, struct Node** first, struct Node** second){
    if(curr == nullptr || curr->next == nullptr){
        *first = curr;
        *second = nullptr;
        return;
    }
    struct Node* slow = curr;
    struct Node* fast = curr->next;
    while(fast && fast->next){
        slow = slow->next;
        fast = fast->next->next;
    }
    *first = curr;
    *second = slow->next;
    if(*second){
        (*second)->prev = nullptr;
    }
    slow->next = nullptr;
}

void mergeSorting(struct Node** head){
    struct Node* curr = *head;
    if(!curr || !curr->next) return;
    struct Node* first;
    struct Node* second;
    findMiddle(curr, &first, &second);
    mergeSorting(&first);
    mergeSorting(&second);
    *head = mergeBoth(first, second);
}

struct Node *sortDoubly(struct Node *head)
{
    mergeSorting(&head);
    return head;
}