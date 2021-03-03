import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {

    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture() {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     *
     * @param height the height of the desired picture
     * @param width  the width of the desired picture
     */
    public Picture(int height, int width) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a
     * copy of that picture
     *
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     *
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName() +
                " height " + getHeight()
                + " width " + getWidth();
        return output;

    }

    /**
     * Method to set the blue to 0
     */
    public void zeroBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setBlue(0);
            }
        }
    }

    /**
     * Method to set the red and green to 0, while keeping blue the same
     */
    public void keepOnlyBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }

    /**
     * Inverts the picture to make the lightest areas of the photo appear as the darkest and vice versa
     */
    public void negate() {
        Pixel[][] pixels = this.getPixels2D();

        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                Color color = pixelObj.getColor();

                int negatedRed = 255 - color.getRed();
                int negatedBlue = 255 - color.getBlue();
                int negatedGreen = 255 - color.getGreen();

                Color negated = new Color(negatedRed, negatedBlue, negatedGreen);
                pixelObj.setColor(negated);
            }
        }
    }

    /**
     * Makes the picture appear black and white
     */
    public void grayscale() {
        Pixel[][] pixels = this.getPixels2D();

        for (Pixel[] rowArray : pixels) {
            for (Pixel pixel : rowArray) {
                int red = pixel.getRed();
                int green = pixel.getGreen();
                int blue = pixel.getBlue();
                int average = (red + green + blue) / 3;

                pixel.setRed(average);
                pixel.setGreen(average);
                pixel.setBlue(average);
            }
        }
    }

    /**
     * Method that mirrors the picture around a
     * vertical mirror in the center of the picture
     * from left to right
     */
    public void mirrorVertical() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a
     * vertical mirror in the center of the picture
     * from right to left
     */
    public void mirrorVerticalRightToLeft() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = width - 1; col > width / 2; col--) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][(width - col) - 1];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a horizontal mirror in the center of the picture from top to bottom
     */
    public void mirrorHorizontal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int col = 0; col < pixels[0].length; col++) {
            for (int row = 0; row < height / 2; row++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a horizontal mirror in the center of the picture from bottom to top
     */
    public void mirrorHorizontalBotToTop() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int col = 0; col < pixels[0].length; col++) {
            for (int row = height - 1; row > height / 2; row--) {
                bottomPixel = pixels[row][col];
                topPixel = pixels[(height - row) - 1][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        }
    }

    /**
     * Mirror just part of a picture of a temple
     */
    public void mirrorTemple() {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++) {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++) {

                count++;

                leftPixel = pixels[row][col];
                rightPixel = pixels[row]
                        [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }

        System.out.println(count);
    }

    /**
     * Mirrors the arms on the snowman to make a snowman with 4 arms.
     */
    public void mirrorArms() {
        int mirrorPoint = 190;

        Pixel topPixel = null;
        Pixel bottomPixel = null;

        Pixel[][] pixels = this.getPixels2D();

        for (int row = 160; row < mirrorPoint; row++) {
            for (int col = 50; col < 170; col++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }

        for (int row = 160; row < mirrorPoint; row++) {
            for (int col = 239; col < 300; col++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /**
     * Mirrors the seagull to the right so that there are two seagulls on the beach near each other.
     */
    public void mirrorGull() {
        int mirrorPoint = 350;
        Pixel leftPixel = null;
        Pixel rightPixel = null;

        Pixel[][] pixels = this.getPixels2D();

        for (int row = 230; row < 330; row++) {
            for (int col = 230; col < mirrorPoint; col++) {

                leftPixel = pixels[row][col];
                rightPixel = pixels[row]
                        [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Method to show large changes in color
     *
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist) {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0;
                 col < pixels[0].length - 1; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > edgeDist) leftPixel.setColor(Color.BLACK);
                else leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /**
     * Copies a portion of a source pictore to the specified location in the detination picture.
     *
     * @param sourcePicture  the picture to copy from
     * @param startSourceRow the starting row of the section to copy
     * @param endSourceRow   the ending row of the section to copy
     * @param startSourceCol the starting column of the section to copy
     * @param endSourceCol   the ending column of the section to copy
     * @param startDestRow   the row to start copying to
     * @param startDestCol   the column to start copying to
     */
    public void cropAndCopy(Picture sourcePicture, int startSourceRow, int endSourceRow, int startSourceCol, int endSourceCol, int startDestRow, int startDestCol) {
        Pixel[][] sourcePixels = sourcePicture.getPixels2D();
        Pixel[][] destPixels = this.getPixels2D();

        int rowDelta = startDestRow - startSourceRow;
        int colDelta = startDestCol - startSourceCol;

        for (int row = startSourceRow; row < endSourceRow; row++) {
            for (int col = startSourceCol; col < endSourceCol; col++) {
                destPixels[row + rowDelta][col + colDelta].setColor(sourcePixels[row][col].getColor());
            }
        }

    }

    /**
     * Crops the image.
     * @param startRow the starting row
     * @param startCol the starting column
     * @param endRow the ending row
     * @param endCol the ending column
     * @return the cropped image
     */
    public Picture crop(int startRow, int startCol, int endRow, int endCol) {
        Picture returnPic = new Picture(endRow - startRow, endCol - startCol);

        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] returnPixels = returnPic.getPixels2D();

        for (int row = 0; row < returnPixels.length; row++) {
            for (int col = 0; col < returnPixels[0].length; col++) {
                returnPixels[row][col].setColor(pixels[row + startRow][col + startCol].getColor());
            }
        }

        return returnPic;
    }

    /**
     * Scales the picture to half the original size and returns the scaled picture
     *
     * @return a scaled copy of the picture
     */
    public Picture scaleByHalf() {

        Pixel[][] pixels = this.getPixels2D();

        int width = pixels[0].length;
        int height = pixels.length;

        Picture returnPic = new Picture(height / 2, width / 2);
        Pixel[][] returnPixels = returnPic.getPixels2D();

        for (int row = 0; row < returnPixels.length; row++) {
            for (int col = 0; col < returnPixels[0].length; col++) {
                returnPixels[row][col].setColor(pixels[row * 2][col * 2].getColor());
            }
        }

        return returnPic;
    }

    /**
     * Scales the picture to the specified width and height and returns the scaled picture
     *
     * @param height the height to scale to
     * @param width  the width to scale to
     * @return the scaled image
     */
    public Picture scaleToSize(int height, int width) {

        Pixel[][] pixels = this.getPixels2D();

        int originalWidth = pixels[0].length;
        int originalHeight = pixels.length;

        double rowFactor = 1.0 * pixels.length / height;
        double colFactor = 1.0 * pixels[0].length / width;

        Picture returnPic = new Picture(height, width);
        Pixel[][] returnPixels = returnPic.getPixels2D();

        for (int row = 0; row < returnPixels.length; row++) {
            for (int col = 0; col < returnPixels[0].length; col++) {
                returnPixels[row][col].setColor(pixels[(int) (row * rowFactor)][(int) (col * colFactor)].getColor());
            }
        }

        return returnPic;
    }

    /**
     * Slices the picture about an offset diagonal and scrapes the pixels along that diagonal to the right side of the image.
     * @return the sliced image.
     */
    public Picture slice() {
        Pixel[][] pixels = this.getPixels2D();

        /*for (int row = 218; row < 1037; row++) {
            for (int col = 720; col < 1335; col++) {
                pixels[row][col].setColor(Color.WHITE);
            }
        }*/

        Picture returnPic = new Picture(pixels.length, pixels[0].length);
        Pixel[][] returnPixels = returnPic.getPixels2D();

        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                if (col > 0 && col > 0.746583850932 * row + 0.25 * pixels[0].length) {
                    returnPixels[row][col].setColor(returnPixels[row][col - 1].getColor());
                } else {
                    returnPixels[row][col].setColor(pixels[row][col].getColor());
                }
            }
        }
        return returnPic;
    }

    /**
     * Creates a 3D glasses effect.
     * @param offset the number of pixels to offset the red and blue counterparts.
     * @return the modified image.
     */
    public Picture rgbEffect(int offset) {
        Picture red = new Picture(this);
        Picture blue = new Picture(this);

        Pixel[][] redP = red.getPixels2D();
        Pixel[][] blueP = blue.getPixels2D();

        for (Pixel[] row : redP) {
            for (Pixel pix : row) {
                int average = (pix.getRed() + pix.getGreen() + pix.getBlue()) / 3;

                if (average < 150) {
                    pix.setRed((pix.getRed() + 210) / 2);
                    pix.setGreen((pix.getGreen() + 9) / 2);
                    pix.setBlue((pix.getBlue() + 12) / 2);
                    pix.setAlpha(50);
                }
            }
        }

        for (Pixel[] row : blueP) {
            for (Pixel pix : row) {
                int average = (pix.getRed() + pix.getGreen() + pix.getBlue()) / 3;

                if (average < 150) {
                    pix.setRed((pix.getRed() + 30) / 2);
                    pix.setGreen((pix.getGreen() + 208) / 2);
                    pix.setBlue((pix.getBlue() + 255) / 2);
                    pix.setAlpha(50);
                }
            }
        }

        Pixel[][] pixels = this.getPixels2D();

        Picture returnPic = new Picture(pixels.length, pixels[0].length);
        Pixel[][] returnPix = returnPic.getPixels2D();

        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                if (col > offset - 1) {
                    returnPix[row][col].setRed((redP[row][col - offset].getRed() + blueP[row][col].getRed() + pixels[row][col].getRed()) / 3);
                    returnPix[row][col].setGreen((redP[row][col - offset].getGreen() + blueP[row][col].getGreen() + pixels[row][col].getGreen()) / 3);
                    returnPix[row][col].setBlue((redP[row][col - offset].getBlue() + blueP[row][col].getBlue() + pixels[row][col].getBlue()) / 3);
                }
            }
        }

        return returnPic;
    }

    /**
     * Creates a collage of four pictures
     *
     * @param picture1 the first picture
     * @param picture2 the second picture
     * @param picture3 the third picture
     * @param picture4 the fourth picture
     */
    public static Picture createCollage4(Picture picture1, Picture picture2, Picture picture3, Picture picture4) {
        Pixel[][] pixels1 = picture1.getPixels2D();
        Pixel[][] pixels2 = picture2.getPixels2D();
        Pixel[][] pixels3 = picture3.getPixels2D();
        Pixel[][] pixels4 = picture4.getPixels2D();

        int width1 = pixels1[0].length;
        int height1 = pixels1.length;

        int width2 = pixels2[0].length;
        int height2 = pixels2.length;

        int width3 = pixels3[0].length;
        int height3 = pixels3.length;

        int width4 = pixels4[0].length;
        int height4 = pixels4.length;

        int canvasWidth = width1 * 2;
        int canvasHeight = height1 * 2;

        Picture canvas = new Picture(canvasHeight, canvasWidth);

        canvas.cropAndCopy(picture1, 0, pixels1.length, 0, pixels1[0].length, 0, 0);
        canvas.cropAndCopy(picture2, 0, pixels2.length, 0, pixels2[0].length, 0, pixels1[0].length);
        canvas.cropAndCopy(picture3, 0, pixels3.length, 0, pixels3[0].length, pixels1.length, 0);
        canvas.cropAndCopy(picture4, 0, pixels4.length, 0, pixels4[0].length, pixels2.length, pixels3[0].length);

        return canvas;
    }

    public static void main(String[] args) {
        Picture beach = new Picture("water.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

}