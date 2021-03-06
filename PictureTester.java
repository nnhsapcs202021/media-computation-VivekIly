import java.io.File;
import java.util.Scanner;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class
 * methods.  Uncomment the methods and the code
 * in the main to test.
 *
 * @author Barbara Ericson
 */
public class PictureTester {
    /**
     * Method to test zeroBlue
     */
    public static void testZeroBlue() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

    /**
     * Method to test keepOnlyBlue
     */
    public static void testKeepOnlyBlue() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.keepOnlyBlue();
        beach.explore();
    }

    /**
     * Method to test negate
     */
    public static void testNegate() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.negate();
        beach.explore();
    }

    /**
     * Method to test grayscale
     */
    public static void testGrayscale() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.grayscale();
        beach.explore();
    }

    /**
     * Method to test cropAndCopy
     */
    public static void testCropAndCopy() {
        Picture beach = new Picture("beach.jpg");
        Picture gorge = new Picture("gorge.jpg");
        beach.explore();
        beach.cropAndCopy(gorge, 5, 100, 5, 100, 5, 5);
        beach.explore();
    }

    /**
     * Method to test scaleByHalf
     */
    public static void testScaleByHalf() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach = beach.scaleByHalf();
        beach.explore();
    }

    /**
     * Method to test scaleToSize
     */
    public static void testScaleToSize() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach = beach.scaleToSize(960, 1280);
        beach.explore();
    }

    /**
     * Method to test mirrorVertical
     */
    public static void testMirrorVertical() {
        Picture caterpillar = new Picture("beach.jpg");
        caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }

    /**
     * Method to test mirrorVerticalRightToLeft
     */
    public static void testMirrorVerticalRightToLeft() {
        Picture pic = new Picture("beach.jpg");
        pic.explore();
        pic.mirrorVerticalRightToLeft();
        pic.explore();
    }

    /**
     * Method to test mirrorHorizontal
     */
    public static void testMirrorHorizontal() {
        Picture pic = new Picture("beach.jpg");
        pic.explore();
        pic.mirrorHorizontal();
        pic.explore();
    }

    /**
     * Method to test mirrorHorizontalBotToTop
     */
    public static void testMirrorHorizontalBotToTop(String filepath) {
        Picture pic = new Picture(filepath);
        pic.explore();
        pic.mirrorHorizontalBotToTop();
        pic.explore();
    }

    /**
     * Method to test mirrorTemple
     */
    public static void testMirrorTemple() {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }

    /**
     * Method to test mirrorArms
     */
    public static void testMirrorArms() {
        Picture temple = new Picture("snowman.jpg");
        temple.explore();
        temple.mirrorArms();
        temple.explore();
    }

    /**
     * Method to test mirrorGull
     */
    public static void testMirrorGull() {
        Picture temple = new Picture("seagull.jpg");
        temple.explore();
        temple.mirrorGull();
        temple.explore();
    }

    /**
     * Method to test crop
     */
    public static void testCrop() {
        Picture pic1 = new Picture("Iphone_camera_app.jpg");
        pic1 = pic1.scaleToSize(716, 955);

        pic1.explore();
        pic1 = pic1.crop(0, 310, 716, 670);
        pic1.explore();
    }

    /**
     * Method to test slice
     */
    public static void testSlice() {
        Picture pic = new Picture("Iphone_camera_app.jpg");
        Picture pic1 = pic.slice();
        pic1.explore();
    }

    /**
     * Method to test rgbEffect
     */
    public static void testRGBEffect() {
        Picture pic = new Picture("arch.jpg");
        pic = pic.rgbEffect(10);
        pic.explore();
    }

    /**
     * Method to test rotate.
     */
    public static void testRotate() {
        Picture pic1 = new Picture("Iphone_camera_app.jpg");

        //pic1 = pic1.scaleToSize(707, 942);
        pic1.explore();
        pic1 = pic1.rotate(0.1);
        pic1.explore();
    }

    /**
     * Method to test edgeDetection
     */
    public static void testEdgeDetection() {
        Picture pic = new Picture("Iphone_camera_app.jpg");
        pic.edgeDetection(15);
        pic.explore();
    }

    /**
     * Main method for testing.  Every class can have a main
     * method in Java
     */
    public static void main(String[] args) {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run
       /*Picture pic = new Picture("Iphone_camera_app.jpg");
       pic.explore();*/
        //testZeroBlue();
        //testKeepOnlyBlue();
        //testKeepOnlyRed();
        //testKeepOnlyGreen();
        //testNegate();
        //testGrayscale();
        //testCropAndCopy();
        //testScaleByHalf();
        //testScaleToSize();
        //testFixUnderwater();
        //testMirrorVertical();
        //testMirrorVerticalRightToLeft();
        //testMirrorHorizontal();
        //testMirrorHorizontalBotToTop(filepath);
        //testMirrorTemple();
        //testMirrorArms();
        //testMirrorGull();
        //testMirrorDiagonal();
        //testCrop();
        //testSlice();
        //testRGBEffect();
        testRotate();
        //testCopy();
        //testEdgeDetection();
        //testEdgeDetection2();
        //testChromakey();
        //testEncodeAndDecode();
        //testGetCountRedOverValue(250);
        //testSetRedToHalfValueInTopHalf();
        //testClearBlueOverValue(200);
        //testGetAverageForColumn(0);
    }
}
