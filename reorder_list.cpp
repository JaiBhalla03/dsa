class Solution {
public:
    void reorderList(ListNode* head) {
        if (!head || !head->next)
            return;

        vector<int> v1;
        vector<int> v2;
        ListNode* slow = head;
        ListNode* fast = head;

        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        slow = fast ? slow->next : slow;
        fast = head;
        while (fast != slow) {
            v1.push_back(fast->val);
            fast = fast->next;
        }


        while (slow) {
            v2.push_back(slow->val);
            slow = slow->next;
        }

        slow = head;
        int a = 0;
        int b = v2.size() - 1;
        bool flag = true;

        while (slow) {
            if (flag && a < v1.size()) {
                slow->val = v1[a];
                a++;
            }
            else if (!flag && b >= 0 && b < v2.size()) {
                slow->val = v2[b];
                b--;
            }
            slow = slow->next;
            flag = !flag;
        }
    }
};
