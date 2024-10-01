import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class B_Forming_Triangles{

    
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
            long n = sc.nextInt();
            int[] a = new int[(int)n];
            for(int i=0;i<n;i++) {
                a[i] = sc.nextInt();
            }
            long ans = 0;
            Arrays.sort(a);
            // if(a[0] == a[(int)n-1] && n > 2) {
            //     System.out.println(n*(n-1)*(n-2)/6);
            //     continue;
            // }
            long count = 1;
            long check = 0;
            for(int i=1;i<n;i++) {
                if(a[i] == a[i-1]) {
                    count++;
                }
                else {
                    if((count & 1) == 0)
                    ans += (count/2)*(count-1)*check;
                    else 
                    ans += count*((count-1)/2)*check;
                    if(count > 1) {
                        if((count & 1) == 0) {
                            if(count % 3 == 0)
                            ans += (count/6)*(count-1)*(count-2);
                            else if(count % 3 == 1)
                            ans += (count/2)*((count-1)/3)*(count-2);
                            else 
                            ans += (count/2)*(count-1)*((count-2)/3);
                        }
                        else {
                            if(count % 3 == 0) 
                            ans += (count/3)*((count-1)/2)*(count-2);
                            else if(count % 3 == 1)
                            ans += (count)*((count-1)/6)*(count-2);
                            else 
                            ans += (count)*((count-1)/2)*(count-2)/3;
                        }
                    }
                    check = i;
                    count = 1;
                }
            }
            ans += count*(count-1)/2*check;
                    if(count > 1)
                    ans += (count)*(count-1)*(count-2)/6;
            System.out.println(ans);
        }
        out.flush();
    }
}