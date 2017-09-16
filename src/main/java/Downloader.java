import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader {
    private String url = ""; //Failo csv url
    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Downloader(String url, String file) {
        this.url = url;
        this.file = file;
        URL u;
        BufferedInputStream is = null;
        FileOutputStream dis = null;
        String s;

        try {

            u = new URL(url);
            is = new BufferedInputStream(u.openStream());
            dis = new FileOutputStream(file);
            int data = is.read();
            System.out.println("Downloading file..");
            while (data != -1) {
                dis.write(data);
                data = is.read();

            }
            System.out.println("Download is finished");

        } catch (MalformedURLException mue) {
            System.out.println("Ouch - a MalformedURLException happened.");
            mue.printStackTrace();
            System.exit(1);
        } catch (IOException ioe) {

            System.out.println("Oops- an IOException happened.");
            ioe.printStackTrace();
            System.exit(1);

        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
