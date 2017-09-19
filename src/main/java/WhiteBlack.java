import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;

public class WhiteBlack {
    private File image; // Paveikslelio failas

    public WhiteBlack(File image) {

        this.image = image;


    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;

    }

    public void make_bw() {
        try {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            BufferedImage img = ImageIO.read(image);
            byte[] data = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
            Mat mat = new Mat(img.getHeight(), img.getWidth(), CvType.CV_8UC4);
            mat.put(0, 0, data);
            Mat mat1 = new Mat(img.getHeight(), img.getWidth(), CvType.CV_8UC1);
            Imgproc.cvtColor(mat, mat1, Imgproc.COLOR_RGB2GRAY);

            byte[] data1 = new byte[mat1.rows() * mat1.cols() * (int) (mat1.elemSize())];
            mat1.get(0, 0, data1);
            BufferedImage img1 = new BufferedImage(mat1.cols(), mat1.rows(), BufferedImage.TYPE_BYTE_INDEXED);
            img1.getRaster().setDataElements(0, 0, mat1.cols(), mat1.rows(), data1);
            File output = new File("edited" + image);
            ImageIO.write(img1, "jpg", output);

        } catch (Exception e) {

        }
    }

}
