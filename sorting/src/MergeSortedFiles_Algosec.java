import java.io.*;
import java.util.*;

public class MergeSortedFiles_Algosec {
    // 0 p1 -> Eugene, Prakash,
    // 1 p2 -> Deepak, Ram, Shiva, Tarun ,Varun
    // 2 p3 -> Vohit
    // File -> List<String> -> 1 GB -> Sort -> 200 MB

    private static final String PATH = "C:\\code\\leetcode\\sorting\\src\\resources\\";
    public static void main(String[] args) {
        List<File> inputFiles = Arrays.asList(new File(PATH + "p1.txt"), new File( PATH + "p2.txt"), new File(PATH + "p3.txt"));
        File outputFile = new File("C:\\code\\leetcode\\sorting\\src\\resources\\output.txt");
        solve( inputFiles, outputFile);
    }

    static class Pair {
        String line;
        Integer fileId;

        public Pair(String line, Integer fileId) {
            this.line = line;
            this.fileId = fileId;
        }
    }

    public static void solve(List<File> sortedFiles, File outputFile) {
        // files sorted
        // until file has reached end check all for the smallest and add it to output
        PriorityQueue<Pair> pq  = new PriorityQueue<>(sortedFiles.size(), Comparator.comparing(a -> a.line));
        List<BufferedReader> readers = new ArrayList<>();
        BufferedWriter writer = null;
        try {

            for (int i=0; i < sortedFiles.size(); i++) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sortedFiles.get(i))));
                readers.add(reader);
            }

            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));

            for (int i=0; i < readers.size(); i++) {
                addToQueue(readers, i, pq);
            }

            while (!pq.isEmpty()){
                Pair pair = pq.poll();
                String line = pair.line;
                Integer fileId = pair.fileId;
                writer.write(line);
                writer.newLine();
                System.out.println(line);
                addToQueue(readers, fileId, pq);
            }
            writer.close();
            close(readers);
        }catch (IOException ex) {
            ex.printStackTrace();
        } finally {
        }
    }

    private static void close(List<BufferedReader> readers) {
        readers.stream().forEach(bufferedReader -> {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    private static void addToQueue(List<BufferedReader> readers, int fileId, PriorityQueue<Pair> pq) throws IOException {
        BufferedReader reader = readers.get(fileId);
        String line = reader.readLine();
        if (line != null && !line.isEmpty()) {
            pq.offer(new Pair(line, fileId));
        }
    }

}
