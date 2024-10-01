import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class D_GCD_sequence{

    
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

    public static long decimalToBinary(long decimal) {
        if (decimal == 0) {
            return 0;
        }
        long binary = 0;
        long place = 1;
        while (decimal > 0) {
            long remainder = decimal % 2;
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
            long[] a = new long[n];
            for(int i=0;i<n;i++) {
                a[i] = sc.nextInt();
            }
            long[] b = new long[n-1];
            for(int i=0;i<n-1;i++) {
                b[i] = gcd(a[i], a[i+1]);
            }
            int index = -1;
            for(int i=1;i<n-1;i++) {
                if(b[i] < b[i-1]) {
                    index = i;
                    break;
                }
            }
            if(index == -1 || index == n-2) {
                System.out.println("YES");
                continue;
            }
            int flag = 0;
            if(index == 1 && gcd(a[0], a[2]) <= b[2]) {
                for(int i=3;i<n-1;i++) {
                    if(b[i] < b[i-1]) {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) {
                    System.out.println("YES");
                    continue;
                }
            }
            if(index == 1 && b[0] <= gcd(a[1], a[3])) {
                flag = 0;
                if(n > 3 && gcd(a[1], a[3]) > b[3]) {
                    flag = 1;
                }
                for(int i=4;i<n-1;i++) {
                    if(b[i] < b[i-1]) {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) {
                    System.out.println("YES");
                    continue;
                }
            }
            if(index == 1 && b[1] <= b[2]) {
                flag = 0;
                for(int i=3;i<n-1;i++) {
                    if(b[i] < b[i-1]) {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) {
                    System.out.println("YES");
                    continue;
                }
            }
            if(index == 2 && gcd(a[0], a[2]) <= b[2]) {
                flag = 0;
                for(int i=3;i<n-1;i++) {
                    if(b[i] < b[i-1]) {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) {
                    System.out.println("YES");
                    continue;
                }
            }
            if(index > 2 && b[index-3] <= gcd(a[index-2], a[index]) && gcd(a[index-2], a[index]) <= b[index]) {
                flag = 0;
                for(int i=index+1;i<n-1;i++) {
                    if(b[i] < b[i-1]) {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) {
                    System.out.println("YES");
                    continue;
                }
            }
            if(index > 1 && b[index-2] <= gcd(a[index-1], a[index+1]) && gcd(a[index-1], a[index+1]) <= b[index+1]) {
                flag = 0;
                for(int i=index+2;i<n-1;i++) {
                    if(b[i] < b[i-1]) {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) {
                    System.out.println("YES");
                    continue;
                }
            }
            // System.out.println(index + " " + b[index-1] + " " + gcd(a[index], a[index+2]));
            if(index > 1 && b[index-1] <= gcd(a[index], a[index+2])) {
                // System.out.println("fuck off");
                flag = 0;
                b[index+1] = gcd(a[index], a[index+2]);
                for(int i=index+2;i<n-1;i++) {
                    if(b[i] < b[i-1]) {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) {
                    System.out.println("YES");
                    continue;
                }
            }
            else {
                System.out.println("NO");
            }
        }
        out.flush();
    }
}