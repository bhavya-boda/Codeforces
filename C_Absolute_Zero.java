    /*
                    वक्रतुण्ड महाकाय सूर्यकोटि समप्रभ।    
                    निर्विघ्नं कुरु मे देव सर्वकार्येषु सर्वदा।     
    */

    import java.io.BufferedReader;
    import java.time.Duration;
    import java.time.Instant;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.PrintWriter;
    import java.lang.reflect.Array;
    import java.math.BigInteger;
    import java.util.*;
    public class C_Absolute_Zero{

        
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


        public static void ha() {
            System.out.println("YES");
        }

        public static void na() {
            System.out.println("NO");
        }

        public static void line() {
            System.out.println();
        }

        public static int mod = 1000000007;


        public static long pow(long x, long p) {
            x %= mod;
            long ans = 1;
            while (p > 0) {
                if (p % 2 == 1) ans = ans * x % mod;
                x = x * x % mod;
                p /= 2;
            }
            return ans;
        }

        public static void main(String args[]) {
            FastReader sc = new FastReader();
            PrintWriter out = new PrintWriter(System.out);
            int t = sc.nextInt();
            while (t-- != 0) {
                int n = sc.nextInt();
                List<Long> a = new ArrayList<>();
                for(int i=0;i<n;i++) {
                    a.add(sc.nextLong());
                }
                Collections.sort(a);
                List<Long> ans = new ArrayList<>();
                while (zero(a)) {
                    long mid = (Collections.max(a)+Collections.min(a))/2;
                    if (mid == 0) {
                        System.out.println("-1");
                        break;
                    } else {
                        a = update(a, mid);
                        ans.add(mid);
                    }
                }
    
                if (!zero(a)) {
                    System.out.println(ans.size());
                    for (Long num : ans) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
            }
            out.flush();
        }

        public static List<Long> update(List<Long> a, long mid) {
            List<Long> updatedList = new ArrayList<>();
            for (Long i : a) {
                updatedList.add(Math.abs(i - mid));
            }
            return updatedList;
        }

        public static boolean zero(List<Long> a) {
            for (Long num : a) {
                if (num != 0) {
                    return true;
                }
            }
            return false;
        }
}

