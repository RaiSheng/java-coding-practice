import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) {

        ListNode result = new AddTwoNumbers().addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0); // 創建一個虛擬頭結點
        ListNode current = dummyHead;        // 用於構建結果鏈表
        int carry = 0;                       // 初始化進位為 0

        // 當兩個鏈表都沒遍歷完，或者還有進位時：
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0; // 如果 l1 結束，則用 0 填充
            int v2 = (l2 != null) ? l2.val : 0; // 如果 l2 結束，則用 0 填充
            int sum = v1 + v2 + carry;          // 相加當前位數字和進位
            carry = sum / 10;                   // 求進位
            int digit = sum % 10;               // 當前位的值

            // 把計算出的值作為新節點加入到結果鏈表
            current.next = new ListNode(digit);
            current = current.next; // 移到下一個節點

            // 繼續遍歷 l1 和 l2
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next; // 返回結果頭節點

    }

    public static class ListNode {
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
}
