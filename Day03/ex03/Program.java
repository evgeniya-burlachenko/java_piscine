import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Program {

	static class newThread extends Thread {

		public void run(){
			String url;
	
			while ((url = FileLoader.getNextUrl()) != null)
				FileLoader.downloadFile(url);
		}
	}
    public static void main(String[] args) throws IOException {
        int threadsCount = Integer.parseInt(args[0].substring(15));
        BufferedReader rd = new BufferedReader(new FileReader("urls_for_load.txt"));
        Queue<String> queue_urls = new LinkedList<>();
        String url;
        while ((url = rd.readLine()) != null)
            queue_urls.add(url);

        FileLoader.initQ(queue_urls);

        for (int i = 0; i < threadsCount; i++){
            new newThread().start();
        }
		rd.close();

    }
}