import java.io.File;
import java.util.Scanner;

public class Collage {

    /**
     * Used in createCollage method to create the rotated recursive image.
     * @param pic the picture to modify.
     */
    public static void createRecursive(Picture pic) {
        Picture subpic = pic.scaleToSize(390, 293);
        pic.cropAndCopy(subpic, 0, 390, 0, 293, 104, 135);
        for (int i = 0; i < 500; i++) {
            subpic = pic;
            subpic = pic.scaleToSize(390, 293);
            subpic = subpic.rotate(0.2);
            pic.cropAndCopy(subpic, 0, 390, 0, 293, 104, 135);
        }
    }

    /**
     * Method to create collage by calling createCollage4 method from Picture class.
     */
    public static void createCollage() {
        Picture pic1 = new Picture("Iphone_camera_app.jpg");
        Picture pic2 = new Picture("Iphone_camera_app.jpg");
        Picture pic3 = new Picture("Iphone_camera_app.jpg");
        Picture pic4 = new Picture("Iphone_camera_app.jpg");

        System.out.println("Creating rgbEffect...");
        pic3 = pic3.rotate(0.1);
        pic3 = pic3.rgbEffect(15);
        System.out.println("rgbEffect created.");

        System.out.println("Scaling and cropping pictures...");
        pic1 = pic1.scaleToSize(716, 955);
        pic2 = pic2.scaleToSize(716, 955);
        pic3 = pic3.scaleToSize(716, 955);
        pic4 = pic4.scaleToSize(716, 955);

        pic1 = pic1.crop(0, 208, 716, 747);
        pic2 = pic2.crop(0, 208, 716, 747);
        pic3 = pic3.crop(0, 208, 716, 747);
        pic4 = pic4.crop(0, 208, 716, 747);
        System.out.println("Pictures scaled and cropped.");
        // recursive
       /*Picture subpic2 = pic2.scaleToSize(390, 293);
       //subpic2 = subpic2.rotate(0.2);
       pic2.cropAndCopy(subpic2, 0, 390, 0, 293, 104, 135);
       for (int i = 0; i < 500; i++) {
           subpic2 = pic2;
           subpic2 = pic2.scaleToSize(390, 293);
           subpic2 = subpic2.rotate(0.1);
           pic2.cropAndCopy(subpic2, 0, 390, 0, 293, 104, 135);
       }*/

        System.out.println("Creating recursive effect...");
        createRecursive(pic2);
        System.out.println("Recursive effect created.");

        System.out.println("Creating slicing effect...");
        pic4 = pic4.slice();
        System.out.println("Slicing effect created.");

        System.out.println("Creating collage...");
        Picture collage = Picture.createCollage(pic1, pic2, pic3, pic4);
        System.out.println("Collage created.");
        collage.explore();

        System.out.print("Enter the filepath to save the collage to: ");

        Scanner scan = new Scanner(System.in);
        String filepath = scan.nextLine();

        System.out.println(filepath + File.separator + "collage.jpg");
        collage.write(filepath + File.separator + "collage.jpg");

    }
}
