    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int needNum = Integer.parseInt(st.nextToken());
            long[] arr = new long[num];

            // 한 랜선 길이의 최대값
            long max = 0;
            for (int i = 0; i < num; i++) {
                arr[i] = Long.parseLong(br.readLine());
                if (arr[i] > max) max = arr[i];
            }

            long right = 1;
            long left = max;
            long mid = 0;
            long maxLength = 0;

            while(right <= left) {
                mid = (right + left) / 2;
                if(checkMaxlength(arr,needNum,mid)) {
                    right = mid + 1;
                    maxLength = mid;
                }else {
                    left = mid - 1;
                }
            }

            System.out.println(maxLength);

        }


        static boolean checkMaxlength(long[] arr, int needNum, long mid) {
            long cnt = 0;
            for(int i = 0; i < arr.length; i++) {
                long length = arr[i];
                cnt += length / mid;
                if(cnt >= needNum) return true;
            }

            return false;
        }
    }
