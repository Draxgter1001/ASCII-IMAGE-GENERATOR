import java.io.File;

public class ImageType {

    private static String imageFullPath;
    private static final String IMAGE_EXT_JPG = "jpg";
    private static final String IMAGE_EXT_JPEG = "jpeg";
    private static final String IMAGE_EXT_PNG = "png";
    private static final String IMAGE_EXT_GIF = "gif";

    public static final String IMAGE_ALLOW_TYPES = "Images type allowed - " + IMAGE_EXT_JPG + IMAGE_EXT_JPEG
            + IMAGE_EXT_PNG + IMAGE_EXT_GIF;

    public ImageType(String imageFullPath){
        ImageType.imageFullPath = imageFullPath;
    }

    public boolean isFileValidImg(){
        if (imageFullPath == null){
            throw new NullPointerException("Image file path cannot be null or empty");
        }

        File imgFile = new File(imageFullPath);
        String ext = getFileExtension(imgFile);
        return IMAGE_EXT_GIF.equalsIgnoreCase(ext) || IMAGE_EXT_JPEG.equalsIgnoreCase(ext)
                || IMAGE_EXT_JPG.equalsIgnoreCase(ext) || IMAGE_EXT_PNG.equalsIgnoreCase(ext);
    }

    private static String getFileExtension(File img){
        if(img == null){
            throw new NullPointerException("Image file cannot be null");
        }

        String name = img.getName();

        int lastDotIndex = name.lastIndexOf(".");
        if(lastDotIndex > 0 && lastDotIndex < (name.length() - 1)){
            return name.substring(lastDotIndex + 1).toLowerCase();
        }

        return "";
    }
}
