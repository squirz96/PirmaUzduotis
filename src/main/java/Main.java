import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.math3.primes.Primes;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Collection;


public class Main {




    public static void main(String[] args) {
        create_dirs();
        DateTime starting_point = new DateTime();
        //region Primes 100 - 1000
        try {

            DateTime now = new DateTime();
            PrintWriter writer = new PrintWriter("Primes/primes_0.txt");
            int min = 100, max = 1000;
            PrintWriter printWriter = new PrintWriter("Primes/primes_0_factors.txt");
            generate_data(min, max, writer, printWriter);

            DateTime end = new DateTime();
            Interval interval = new Interval(now, end);
            System.out.println("Trukmes laikas: " + interval.toDurationMillis());

        } catch (Exception ex) {

        }

        //endregion

        // region Primes 1001 - 10000
        try {
            DateTime now = new DateTime();
            PrintWriter writer = new PrintWriter("Primes/primes_1.txt");
            int min = 1001, max = 10000;
            PrintWriter printWriter = new PrintWriter("Primes/primes_1_factors.txt");
            generate_data(min, max, writer, printWriter);
            DateTime end = new DateTime();
            Interval interval = new Interval(now, end);
            System.out.println("Trukmes laikas: " + interval.toDurationMillis());
        } catch (Exception ex) {

        }
        //endregion

        // region Primes 10001 - 100000
        try {
            DateTime now = new DateTime();
            PrintWriter writer = new PrintWriter("Primes/primes_2.txt");
            int min = 10001, max = 100000;
            PrintWriter printWriter = new PrintWriter("Primes/primes_2_factors.txt");
            generate_data(min, max, writer, printWriter);
            DateTime end = new DateTime();
            Interval interval = new Interval(now, end);
            System.out.println("Trukmes laikas: " + interval.toDurationMillis());
        } catch (Exception ex) {

        }
        //endregion
        // region Primes 100001 - 1000000
        try {
            DateTime now = new DateTime();
            PrintWriter writer = new PrintWriter("Primes/primes_3.txt");
            int min = 100001, max = 1000000;
            PrintWriter printWriter = new PrintWriter("Primes/primes_3_factors.txt");
            generate_data(min, max, writer, printWriter);
            DateTime end = new DateTime();
            Interval interval = new Interval(now, end);
            System.out.println("Trukmes laikas: " + interval.toDurationMillis());
        } catch (Exception ex) {

        }

        //endregion
        delete_dir();
        DateTime ending_point = new DateTime();
        Interval interval = new Interval(starting_point, ending_point);
        System.out.println("Pilnutinis trukmes laikas: " + interval.toDurationMillis());
    }

    // Sitoje Vietoje baigiasi pirmoji uzduoties dalis
    int width = 600, height = 600;
    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    ImageGen images = new ImageGen(width, height, img);
 
    static void generate_data(int min, int max, PrintWriter writer, PrintWriter printWriter2) throws IOException, ArchiveException {

        for (int i = min; i < max; i++) {
            if (Primes.isPrime(i)) {

                writer.println(i);

            } else {
                printWriter2.print(i);
                printWriter2.print(" ");
                printWriter2.println(Primes.primeFactors(i));
            }

        }
        writer.close();
        printWriter2.close();
        File files[] = new File[] {
                new File(writer.toString()),
                new File(printWriter2.toString())
        };
        File source = new File("Primes");
        File destination = new File("Primes.zip");
        addFilesToZip(source, destination);

    }
    static void create_dirs() {
        File theDir = new File("Primes");
        if (!theDir.exists()) {
            boolean result = false;
            try {
                theDir.mkdir();
                result = true;
            } catch (Exception ex) {

            }
        }
    }
    static void delete_dir() {
        File theDir = new File("Primes");
        if (theDir.exists()) {
            try {
                FileUtils.deleteDirectory(theDir);

            } catch (Exception ex) {

            }
        }
    }
    static void addFilesToZip(File source, File destination) throws IOException, ArchiveException {
        OutputStream archiveStream = new FileOutputStream(destination);
        ArchiveOutputStream archive = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, archiveStream);
        Collection < File > fileList = FileUtils.listFiles(source, null, true);
        for (File file: fileList) {
            String entryName = getEntryName(source, file);
            ZipArchiveEntry entry = new ZipArchiveEntry(entryName);
            archive.putArchiveEntry(entry);
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
            IOUtils.copy(input, archive);
            input.close();
            archive.closeArchiveEntry();
        }
        archive.finish();
        archiveStream.close();
    }
    static String getEntryName(File source, File file) throws IOException {
        int index = source.getAbsolutePath().length() + 1;
        String path = file.getCanonicalPath();

        return path.substring(index);
    }


}