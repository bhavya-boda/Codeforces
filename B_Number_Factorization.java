import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class B_Number_Factorization{

    
    // Time complexity = O(sqrt(n))
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //GCD OF TWO NUMBERS
    public static long gcd(long a, long b){
        if(a == 0){
            return b;
        }

        return gcd(b % a, a);
    }

    //LCM OF TWO NUMBERS
    public static long LCM(int a, int b){
        return  ((long) a * b) / gcd(a, b);
    }

    //    FOR TAKING FASTER INPUTS
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static int decimalToBinary(int decimal) {
        if (decimal == 0) {
            return 0;
        }
        int binary = 0;
        int place = 1;
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary += remainder * place;
            place *= 10;
            decimal = decimal / 2;
        }
        return binary;
    }

    public static ArrayList<Integer> primeFactors(int n) {
        ArrayList<Integer> check = new ArrayList<>();
        while (n % 2 == 0) {
            check.add(2);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                check.add(i);
                n /= i;
            }
        }

        if (n > 2) {
            check.add(n);
        }
        return check;
    }

    public static void main(String args[]) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> check = primeFactors(n);
            long k = check.size();
            long[] a = new long[(int)k];
            long[] p = new long[(int)k];
            int j = 0;
            for(int i=0;i<k;i++) {
                if(i != 0 && check.get(i) == check.get(i-1)) {
                }
                else {
                    if(i != 0)
                    j++;
                    a[j] = check.get(i);
                }
                p[j]++;
            }
            // for(int i=0;i<k;i++) {
            //     System.out.println(a[i] + " " + p[i]);
            // }
            long min = Integer.MAX_VALUE;
            long ans = 0;
            long sum = -1;
            long checking = 1;
            while(sum != ans) {
                sum = ans;
                for(int i=0;i<k;i++) {
                    if(p[i] < min && p[i] != 0)
                    min = p[i];
                    if(p[i] == 0)
                    break;
                }
                checking = 1;
                for(int i=0;i<k;i++) {
                    if(p[i] >= min) {
                        checking *= a[i];
                        p[i] -= min;
                    }
                }
                if(checking != 1)
                ans += checking*min;
            }
            System.out.println(ans);
        }
        out.flush();
    }
}