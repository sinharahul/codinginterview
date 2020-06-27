package top100interview;

import java.util.HashSet;
import java.util.Set;

public class Happy {
    public static void main(String[] args) {
        Happy h = new Happy();
        System.out.println(h.isHappy(19));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        int sum = 0;
        while (true) {
            int h = sum(n);
            if (h == 1) return true;
            if(set.contains(h))return false;
            set.add(h);
            n=h;
        }

    }

    int sum(int n) {
        int t = 0;
        while (n != 0) {
            int d = n % 10;
            t += d * d;
            n = n / 10;
        }
        return t;
    }
}
