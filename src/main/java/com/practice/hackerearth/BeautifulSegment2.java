package com.practice.hackerearth;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.OffsetDateTime;

class BeautifulSegment2 {
	static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
	
	 public static void main(String[] args) throws IOException 
	    { 
	        Reader s=new Reader(); 
	        int n = s.nextInt(); 
	        int k = s.nextInt(); 
	        int count=0; 
	        while (n-- > 0) 
	        { 
	            int x = s.nextInt(); 
	            if (x%k == 0) 
	               count++; 
	        } 
	        System.out.println(count); 
	    } 
  
    public static void main3(String[] args) throws IOException 
    { 
        Reader s=new Reader(); 
        int T = s.nextInt(); 
        int count=0; 
        while (T-- > 0) 
        { 
        	int totalSegments = 0;
			int N = s.nextInt();
			if (N == 0) {
				System.out.println(0);
				--T;
				continue;
			}
			if (N < 3) {
				s.readLine();
				System.out.println(0);
				--T;
				continue;
			}
			//String[] arr = br.readLine().split(" ");
			int[] a = new int[N];
//			String arr = br.readLine();
//			a= Stream.of(arr.split(" ")).mapToInt(Integer::parseInt).toArray();
//			for (int i = 0; i < N; i++) {
//				a[i] = Integer.parseInt(arr[i]);
//			}
			System.out.println(OffsetDateTime.now());

			int i = 0;
			while (i < N - 1) {
				int strt = i, mid = i, end = i;
				int val_i=s.nextInt();
				int val_mid=val_i;
				while (i < N - 1 ) {
					val_mid=s.nextInt();
					if(val_mid >= val_i) {
					++mid;
					++i;
					val_i= val_mid;
					}else {
						val_mid=val_i;
						break;
					}
						
				}
				end = mid;
				if (strt < mid) {
					while (i < N - 1 && a[i + 1] < a[i]) {
						++end;
						++i;
					}
				}
				if (end > mid && mid > strt) {
					totalSegments += Math.min((mid - strt), (end - mid));
				}
			}
			System.out.println(OffsetDateTime.now());
			System.out.println(totalSegments);
			--T;
		} 
         
        System.out.println(count); 
    } 

	public static void main1(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());

		while (T > 0) {
			System.out.println(OffsetDateTime.now());
			int totalSegments = 0;
			int N = Integer.parseInt(br.readLine().trim());
			if (N == 0) {
				System.out.println(0);
				--T;
				continue;
			}
			if (N < 3) {
				br.readLine();
				System.out.println(0);
				--T;
				continue;
			}
			String[] arr = br.readLine().split(" ");
			int[] a = new int[N];
//			String arr = br.readLine();
//			a= Stream.of(arr.split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(arr[i]);
			}
			System.out.println(OffsetDateTime.now());

			int i = 0;
			while (i < N - 1) {
				int strt = i, mid = i, end = i;
				while (i < N - 1 && a[i + 1] >= a[i]) {
					++mid;
					++i;
				}
				end = mid;
				if (strt < mid) {
					while (i < N - 1 && a[i + 1] < a[i]) {
						++end;
						++i;
					}
				}
				if (end > mid && mid > strt) {
					totalSegments += Math.min((mid - strt), (end - mid));
				}
			}
			System.out.println(OffsetDateTime.now());
			System.out.println(totalSegments);
			--T;
		}

	}
}
