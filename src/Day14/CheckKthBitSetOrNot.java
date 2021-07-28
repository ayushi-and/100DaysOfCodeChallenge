package Day14;

//We have two numbers n and k, we have to find whether kth bit in n is set or not. (Kth bit from the right side)
//n=5, k=1  -> o/p=yes (5 -> 000...0101)
//k <= No of bits in binary representation
//Using left shift
public class CheckKthBitSetOrNot {
    public static void isKthBitSet(int n,
                                   int k)
    {
        if ((n & (1 << (k - 1))) == 1)
            System.out.print("SET");
        else
            System.out.print("NOT SET");
    }
    public static void main(String[] args)
    {
        int n = 5, k = 1;
        isKthBitSet(n, k);
    }
}
