import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Queue;

public class FileLoader {

    private static Queue<String> urls;
    private static int fileNumber = 0;

    public static void initQ(Queue<String> queue) {
        urls = queue;
    }

    public static synchronized String getNextUrl() {
        String url;
        if ((url = urls.poll()) != null)
            return url;
        return null;
    }

    public static void downloadFile(String url) {

		try {
			URL newUrl = new URL(url);
			Path file = Paths.get(url);
			if (Files.exists(file.getFileName())) {
				System.out.println("File " + file.getFileName() + " already loaded");
				return;
			}
			int fileNum;
			synchronized (FileLoader.class){
				fileNum = fileNumber++;
			}
			System.out.println(Thread.currentThread().getName() + " start download file number " + fileNum);
			InputStream input = newUrl.openStream();
            Files.copy(input, file.getFileName());
            System.out.println(Thread.currentThread().getName() + " finish download file number " + fileNum);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}
		