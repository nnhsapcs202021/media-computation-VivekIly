import java.io.File;
import java.util.Scanner;

public class Collage {

    /**
     * Used in main method to create the rotated recursive image.
     *
     * @param pic the picture to modify.
     */
    public static void createRecursive(Picture pic) {
        Picture subpic = pic.scaleToSize(390, 293);
        pic.cropAndCopy(subpic, 0, 390, 0, 293, 104, 135);
        for (int i = 0; i < 50; i++) {
            subpic = pic.scaleToSize(390, 293);
            //subpic = subpic.rotate(0.2);
            pic.cropAndCopy(subpic, 0, 390, 0, 293, 104, 135);
        }
    }

    /**
     * Determines if a directory with the inputted name exists in the specified File directory
     *
     * @param name      the name of the File to search for.
     * @param directory the directory in which to search for the File.
     * @return true if the File exists in the directory.
     */
    public static boolean fileExists(String name, File directory) {
        File returnFile = null;
        File[] list = directory.listFiles();
        if (list != null) {
            for (File fil : list) {
                if (fil.isDirectory()) {
                    fileExists(name, fil);
                } else if (name.equalsIgnoreCase(fil.getName())) {
                    returnFile = fil.getParentFile();
                }
            }
        }

        return returnFile != null;
    }

    /**
     * Method to create collage by calling createCollage4 method from Picture class.
     */
    public static void main(String[] args) throws InterruptedException {
        Picture pic1 = new Picture("Iphone_camera_app.jpg");
        Picture pic2 = new Picture("Iphone_camera_app.jpg");
        Picture pic3 = new Picture("Iphone_camera_app.jpg");
        Picture pic4 = new Picture("Iphone_camera_app.jpg");

        System.out.println("Creating rgbEffect...");
        long startRGB = System.currentTimeMillis();
        pic3 = pic3.rotate(0.1);
        pic3 = pic3.rgbEffect(27);
        long endRGB = System.currentTimeMillis();
        System.out.println("rgbEffect created in " + 1.0 * (endRGB - startRGB) / 1000 + " milliseconds.");

        System.out.println("Scaling and cropping pictures...");
        long startScale = System.currentTimeMillis();
        pic1 = pic1.scaleToSize(716, 955);
        pic2 = pic2.scaleToSize(716, 955);
        pic3 = pic3.scaleToSize(716, 955);
        pic4 = pic4.scaleToSize(716, 955);

        pic1 = pic1.crop(0, 208, 716, 747);
        pic2 = pic2.crop(0, 208, 716, 747);
        pic3 = pic3.crop(0, 208, 716, 747);
        pic4 = pic4.crop(0, 208, 716, 747);
        long endScale = System.currentTimeMillis();
        System.out.println("Pictures scaled and cropped in " + 1.0 * (endScale - startScale) / 1000 + " seconds.");

        System.out.println("Creating recursive effect...");
        long startRec = System.currentTimeMillis();
        createRecursive(pic2);
        long endRec = System.currentTimeMillis();
        System.out.println("Recursive effect created in " + 1.0 * (endRec - startRec) / 1000 + " seconds.");

        System.out.println("Creating slicing effect...");
        long startSlice = System.currentTimeMillis();
        pic4 = pic4.slice();
        long endSlice = System.currentTimeMillis();
        System.out.println("Slicing effect created in " + 1.0 * (endSlice - startSlice) / 1000 + " seconds.");

        System.out.println("Creating collage...");
        long startCollage = System.currentTimeMillis();
        Picture collage = Picture.createCollage(pic1, pic2, pic3, pic4);
        long endCollage = System.currentTimeMillis();
        System.out.println("Collage created in " + 1.0 * (endCollage - startCollage) / 1000 + " seconds.");
        System.out.println("Total process completed in " + 1.0 * (endCollage - startRGB) / 1000 + " seconds.\n");
        collage.explore();

        System.out.print("Enter the filepath to save the collage to: ");

        Scanner scan = new Scanner(System.in);
        String filepath = scan.nextLine();

        System.out.println("Saving to: " + filepath + File.separator + "collage.jpg");

        File jpg = new File(filepath + File.separator + "collage.jpg");
        if (jpg.delete()) {

            collage.write(filepath + File.separator + "collage.jpg");

            if (fileExists("collage.jpg", new File("C:\\Users\\Vivek\\Downloads")))
                System.out.println("Successfully saved.");
            else
                System.out.println("Could not save successfully.");
        } else {
            System.out.println("Could not delete previous version of the file. The new file may not be updated.");
        }
    }
}
