import java.io.IOException;
import java.util.TreeMap;

public class Main {
    static int readPosInt() throws IOException {
        int c, n = System.in.read() & 15;
        while((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    //
    static String readFile() throws IOException {
        int c;
        StringBuilder sb = new StringBuilder();
        while((c = System.in.read()) != '.');
        while((c = System.in.read()) > ' ') {
            sb.appendCodePoint(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        int n = readPosInt();

        TreeMap<String, Integer> map = new TreeMap<>();

        for(int i = 0; i < n; i++) {
            String fileName = readFile();
            int count = 0;
            if(map.containsKey(fileName)) {
                count = map.get(fileName);
            }
            map.remove(fileName);
            map.put(fileName, ++count);
        }

        for(String fileName : map.keySet()) {
            System.out.println(fileName + " " + map.get(fileName));
        }

    }
}
