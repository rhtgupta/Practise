package revision1;

class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;

        ListNode current1 = l1;
        ListNode current2 = l2;
        boolean carry = false;
        while (current1 != null && current2 != null) {
            int data1 = current1.val;
            int data2 = current2.val;
            int sumData = 0;
            if (carry) {
                sumData = data1 + data2 + 1;
            }

            carry = false;
            if (sumData >= 10) {
                sumData = sumData % 10;
                carry = true;
            }

            addData(sumData, head);
            current1 = current1.next;
            current2 = current2.next;

        }

        while (current1 != null) {
            int data1 = current1.val;
            int sumData = 0;
            if (carry) {
                sumData = data1 + 1;
            }
            carry = false;
            if (sumData >= 10) {
                sumData = sumData % 10;
                carry = true;
            }
            addData(sumData, head);
            current1 = current1.next;
        }


        while (current2 != null) {
            int data2 = current2.val;
            int sumData = 0;
            if (carry) {
                sumData = data2 + 1;
            }
            carry = false;
            if (sumData >= 10) {
                sumData = sumData % 10;
                carry = true;
            }
            addData(sumData, head);
            current2 = current2.next;
        }

        if (carry) {
            addData(1, head);
        }

        return head;
    }

    public void addData(int sumData, ListNode head) {
        ListNode current3 = head;
        if (current3 == null) {
            head = new ListNode(sumData);
        } else {
            while (current3.next != null) {
                current3 = current3.next;
            }
            current3.next = new ListNode(sumData);
        }
    }

}