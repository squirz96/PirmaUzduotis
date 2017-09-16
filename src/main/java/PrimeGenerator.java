import org.apache.commons.compress.archivers.ArchiveException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class PrimeGenerator {
    public PrimeGenerator() {
    }

    static void generate_data(int min, int max, PrintWriter writer, PrintWriter printWriter2) throws IOException, ArchiveException {

        for (int i = min; i < max; i++) {
            if (org.apache.commons.math3.primes.Primes.isPrime(i)) {

                writer.println(i);

            } else {
                printWriter2.print(i);
                printWriter2.print(" ");
                printWriter2.println(org.apache.commons.math3.primes.Primes.primeFactors(i));
            }

        }
        writer.close();
        printWriter2.close();
        File files[] = new File[]{
                new File(writer.toString()),
                new File(printWriter2.toString())
        };
        File source = new File("Primes");
        File destination = new File("Primes.zip");
        //Zipper zipper =  new Zipper(destination)
        //addFilesToZip(source, destination);

    }
   /* static void addFilesToZip(File source, File destination) throws IOException, ArchiveException {
        OutputStream archiveStream = new FileOutputStream(destination);
        ArchiveOutputStream archive = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, archiveStream);
        Collection< File > fileList = FileUtils.listFiles(source, null, true);
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
    }*/
}
