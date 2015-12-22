package is.check;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

import is.BaseCheck;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Space extends BaseCheck {


    public Space(Context context) {
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
     * thanks to http://stackoverflow.com/a/9989440/4630627
     * @return Number of gega bytes available on External storage
     */
    public long getAvailableSpaceInGB(){
        final long SIZE_KB = 1024L;
        final long SIZE_GB = SIZE_KB * SIZE_KB * SIZE_KB;
        long availableSpace = -1L;
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        availableSpace = (long) stat.getAvailableBlocks() * (long) stat.getBlockSize();
        return availableSpace/SIZE_GB;
    }

    public  boolean isAvailableSpace(int bytes){
        return getAvailableSpaceInBytes()>bytes;
    }


}
