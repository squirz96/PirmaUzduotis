import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class Zipper {


    public Zipper() {


    }

    public void make_zip_pass() {
        try {

            ZipParameters zipParameters = new ZipParameters();
            zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            zipParameters.setEncryptFiles(true);
            zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
            zipParameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
            zipParameters.setPassword("password");
            ZipFile zipFile = new ZipFile("Primes.zip");
            zipFile.addFolder("Primes", zipParameters);
            System.out.println("Primes.zip failas apsaugotas slaptazodziu");
        } catch (ZipException e) {

        }
    }
}
