import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class B_Binary_Path{

    
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


    public static void main(String args[]) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
            String s = "";
            int index = -1;
            char[][] a = new char[2][n];
            a[0] = s1.toCharArray();
            a[1] = s2.toCharArray();
            for(int i=1;i<n;i++) {
                if(a[0][i] == '1' && a[1][i-1] == '0') {
                    index = i;
                    break;
                }
            }
            if(index == -1) {
                s = s1.substring(0) + "" + s2.charAt(n-1);
            }
            else {
                s = s1.substring(0, index) + "" + s2.substring(index-1);
            }
            int count = 1;
            char[] check = s.toCharArray();
            for(int i=1;i<n;i++) {
                if(index == i)
                break;
                if(a[0][i] == a[1][i-1] && a[1][i] == check[i+1]) {
                    count++;
                }
                else {
                    count = 1;
                }
            }
            out.println(s + "\n" + count);
        }
        out.flush();
    }
}