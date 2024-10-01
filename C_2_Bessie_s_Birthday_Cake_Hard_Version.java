import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class C_2_Bessie_s_Birthday_Cake_Hard_Version{

    
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
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] a = new int[x];
            for(int i=0;i<x;i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int ans = n-2;
            ArrayList<Integer> check = new ArrayList<>();
            for(int i=1;i<x;i++) {
                if(a[i] - a[i-1] - 1 > 1) {
                    ans -= a[i]-a[i-1]-1;
                    check.add(a[i]-a[i-1]-1);
                }
            }
            if(n-a[x-1]+a[0] > 2) {
                ans -= n-a[x-1]+a[0]-1;
                check.add(n-a[x-1]+a[0] - 1);
            }
            Collections.sort(check);
            ArrayList<Integer> check2 = new ArrayList<>();
            for(int i : check) {
                if(i % 2 != 0) {
                    if(y-i/2 >= 0) {
                        y-= i/2;
                        ans += i;
                    }      
                    else {
                        check2.add(i);
                    }              
                }
                else {
                    check2.add(i);
                }
            }
            if(y > 0 && check2.size() != 0) {
                long sum = 0;
                for(int i : check2) {
                    sum += i;
                }
                ans += Math.min(2*y,sum);
            }
            System.out.println(ans);
        }
        out.flush();
    }
}