import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintWriter;


public class Main {


    public static void main(String[] args) throws ZipException {
        DateTime starting_point = new DateTime();
        create_dirs();
        //region Primes 100 - 1000
        try {

            PrintWriter writer = new PrintWriter("Primes/primes_0.txt");
            int min = 100, max = 1000;
            PrintWriter printWriter = new PrintWriter("Primes/primes_0_factors.txt");
            PrimeGenerator generator0 = new PrimeGenerator();
            generator0.generate_data(min, max, writer, printWriter);

        } catch (Exception ex) {


        }


        //endregion

        // region Primes 1001 - 10000
        try {
            PrintWriter writer = new PrintWriter("Primes/primes_1.txt");
            int min = 1001, max = 10000;
            PrintWriter printWriter = new PrintWriter("Primes/primes_1_factors.txt");
            PrimeGenerator generator1 = new PrimeGenerator();
            generator1.generate_data(min, max, writer, printWriter);
        } catch (Exception ex) {

        }
        //endregion

        // region Primes 10001 - 100000
        try {
            PrintWriter writer = new PrintWriter("Primes/primes_2.txt");
            int min = 10001, max = 100000;
            PrintWriter printWriter = new PrintWriter("Primes/primes_2_factors.txt");
            PrimeGenerator generator2 = new PrimeGenerator();
            generator2.generate_data(min, max, writer, printWriter);
        } catch (Exception ex) {

        }
        //endregion
        // region Primes 100001 - 1000000
        try {
            PrintWriter writer = new PrintWriter("Primes/primes_3.txt");
            int min = 100001, max = 1000000;
            PrintWriter printWriter = new PrintWriter("Primes/primes_3_factors.txt");
            PrimeGenerator generator3 = new PrimeGenerator();
            generator3.generate_data(min, max, writer, printWriter);
        } catch (Exception ex) {

        }

        //endregion
        Zipper zip = new Zipper();
        zip.make_zip_pass();
        delete_dir();
        Solver equation = new Solver(5, 6, 1);
        BufferedImage bufferedImage = new BufferedImage(800, 800, BufferedImage.TYPE_4BYTE_ABGR);
        ImageGen gen = new ImageGen(800, 800, bufferedImage);
        gen.create_random_image();
        Downloader d = new Downloader("http://cdn.newsapi.com.au/image/v1/a959d7242a67b2682136cec3cad538dd", "man.jpg");
        File input = new File("man.jpg");
        WhiteBlack whiteBlack = new WhiteBlack(input);
        whiteBlack.make_bw();
        Asmuo petras = new Asmuo("Petras", "Petraitis");
        petras.printInfo();
        DateTime ending_point = new DateTime();
        Interval interval = new Interval(starting_point, ending_point);
        System.out.println("Programos trukmes laikas milisekundemis: " + interval.toDurationMillis());

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

}