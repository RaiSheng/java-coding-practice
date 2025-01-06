public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(128));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1; // n 與 1 以二進制的形式 & ， n 最右邊是1的話則 count = count + 1
            n >>>= 1; // 無符號右移一位，拋棄已檢查的位
        }
        return count;
    }
}
