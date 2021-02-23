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
    public static void testNegate(){
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.negate();
        beach.explore();
    }

    /**
     * Method to test grayscale
     */
    public static void testGrayscale(){
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

    public static void testMirrorVerticalRightToLeft() {
        Picture pic = new Picture("beach.jpg");
        pic.explore();
        pic.mirrorVerticalRightToLeft();
        pic.explore();
    }

    public static void testMirrorHorizontal() {
        Picture pic = new Picture("beach.jpg");
        pic.explore();
        pic.mirrorHorizontal();
        pic.explore();
    }

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

    public static void testMirrorArms() {
        Picture temple = new Picture("snowman.jpg");
        temple.explore();
        temple.mirrorArms();
        temple.explore();
    }

    public static void testMirrorGull() {
        Picture temple = new Picture("seagull.jpg");
        temple.explore();
        temple.mirrorGull();
        temple.explore();
    }

    /**
     * Method to test edgeDetection
     */
    public static void testEdgeDetection() {
        Picture swan = new Picture("swan.jpg");
        swan.edgeDetection(10);
        swan.explore();
    }

    /**
     * Main method for testing.  Every class can have a main
     * method in Java
     */
    public static void main(String[] args) {
        String filepath = "C:\\Users\\Vivek\\Downloads\\deep-tunnel-5110033.jpg";
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run
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
        testMirrorGull();
        //testMirrorDiagonal();
        //testCollage();
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