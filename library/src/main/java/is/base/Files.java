package is.base;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;

import java.io.File;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Files extends BaseCheck {


    public Files(Context context) {
        super(context);
    }

    /**
     * thanks to http://stackoverflow.com/a/9989440/4630627
     * @return Number of bytes available on External storage
     */
    public  long getAvailableSpaceInBytes() {
        long availableSpace = -1L;
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        availableSpace = (long) stat.getAvailableBlocks() * (long) stat.getBlockSize();
        return availableSpace;
    }

    /**
     * thanks to http://stackoverflow.com/a/9989440/4630627
     * @return Number of kilo bytes available on External storage
     */
    public  long getAvailableSpaceInKB(){
        final long SIZE_KB = 1024L;
        long availableSpace = -1L;
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        availableSpace = (long) stat.getAvailableBlocks() * (long) stat.getBlockSize();
        return availableSpace/SIZE_KB;
    }
    /**
     * thanks to http://stackoverflow.com/a/9989440/4630627
     * @return Number of Mega bytes available on External storage
     */
    public  long getAvailableSpaceInMB(){
        final long SIZE_KB = 1024L;
        final long SIZE_MB = SIZE_KB * SIZE_KB;
        long availableSpace = -1L;
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        availableSpace = (long) stat.getAvailableBlocks() * (long) stat.getBlockSize();
        return availableSpace/SIZE_MB;
    }

    /**
     * @return boolean
     */
    public boolean isSdCardMounted() {
        String status = Environment.getExternalStorageState();

        if (status.equals(Environment.MEDIA_MOUNTED))
            return true;

        return false;
    }

    /**
     * @param uri
     * @return String type like that image/jpeg
     */
    public String getMediaType(Uri uri) {
        ContentResolver cR = context.getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        String type = mime.getExtensionFromMimeType(cR.getType(uri));
        return type;
    }

    /**
     * @param filePath
     * @param fileName
     * @return
     */
    public boolean isFileExistsInSDCard(String filePath, String fileName) {
        boolean flag = false;
        if (isSdCardMounted()) {
            File file = new File(filePath, fileName);
            if (file.exists()) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * @param directoryPath
     * @return
     */
    public static boolean isFolderExist(String directoryPath) {
        if (TextUtils.isEmpty(directoryPath)) {
            return false;
        }
        File dire = new File(directoryPath);
        return (dire.exists() && dire.isDirectory());
    }


    /**
     * Check file extension
     * @param ext
     * @param file
     * @return
     */
    public boolean isFile(String ext,File file){
        String fullPath = file.getAbsolutePath();
        int dot = fullPath.lastIndexOf(".");
        String ext1 = fullPath.substring(dot + 1);
        if(ext1.equals(ext))
        {
            return true;
        }
        return false;
    }







}
