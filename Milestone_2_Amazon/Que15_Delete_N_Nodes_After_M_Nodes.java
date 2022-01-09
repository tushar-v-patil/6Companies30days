/*
Que15: https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1/#
*/
class Solution
{
    static void linkdelete(Node head, int M, int N)
    {
        Node curr = head;
        while(curr != null){
            int temp = M;
            while(curr != null && temp > 1){
                curr = curr.next;
                temp--;
            }
            if(curr == null) break;
            
            Node next = curr.next;
            temp = N;
            while(next != null && temp > 0){
                next = next.next;
                temp--;
            }
            
            curr.next = next;
            curr = next;
        }
    }
}
