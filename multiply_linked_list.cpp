/* Linked list node structure
struct Node
{
    int data;
    Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};*/

/*The method multiplies
two  linked lists l1 and l2
and returns their product*/

/*You are required to complete this method*/
long long  multiplyTwoLists (Node* l1, Node* l2)
{
    long long num1 = 0;
    long long num2 = 0;
    long long N = 1000000007;
    while(l1 || l2){
        if(l1){
            num1 = (num1*10)%N + l1->data;
            l1 = l1->next;
        }
        if(l2){
            num2 = (num2*10)%N + l2->data;
            l2 = l2->next;
        }
    }
    return ((num1%N)*(num2%N))%N;
}