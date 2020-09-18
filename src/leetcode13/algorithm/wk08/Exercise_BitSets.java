package leetcode13.algorithm.wk08;

import java.util.BitSet;

public class Exercise_BitSets {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        System.out.println(bitSet.size() + "-" + bitSet.length());
        bitSet.set(64);
        System.out.println(bitSet.size() + "-" + bitSet.length());
        bitSet.set(Integer.MAX_VALUE - 64);
        System.out.println(bitSet.size() + "-" + bitSet.length());

        System.out.println(true & true);
        System.out.println(16 & 16 & (16-1));
    }
}
