class Solution {
public:
    ListNode* reverse(ListNode* head){
        ListNode* dummy = nullptr;
        while(head != nullptr){
            ListNode* next = head->next;
            head->next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
    void reorderList(ListNode* head) {
        /*algorithms to reorder list
        1-> find the middle of the list
        2-> seperate the two list
        3-> reverse the second half
        4-> merege the two list
        */
        //finding the middle
        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* last = head;
        while(fast != nullptr){
            last = slow;
            slow = slow->next;
            fast = fast->next;
            if(fast != nullptr){
                fast = fast->next;
            }
        }
        //seperate the two halfs
        last->next = nullptr;
        ListNode* second = reverse(slow);
        ListNode* first = head;
        while(second){
            ListNode* temp1 = first->next;
            ListNode* temp2 = second->next;
            first->next = second;
            second->next = temp1;
            second = temp2;
            first = temp1;
        }
    }
};
