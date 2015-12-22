package is.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import java.io.ByteArrayOutputStream;

import is.BaseCheck;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Bitmaps extends BaseCheck {
    public Bitmaps(Context context) {
        super(context);
    }

    /**
     * @param bmp
     * @return byte[] array
     */
    public static byte[] toBytes(android.graphics.Bitmap bmp) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    /**
     *
     * @param sourceBitmap
     * @param newWidth
     * @param newHeight
     * @return
     */
    public static Bitmap resizeImage(Bitmap sourceBitmap, int newWidth, int newHeight) {
        if (sourceBitmap == null) {
            throw new NullPointerException("Bitmap to be resized cannot be null");
        }
        Bitmap resized = null;
        if (sourceBitmap.getWidth() < sourceBitmap.getHeight()) {
            resized = Bitmap.createScaledBitmap(sourceBitmap, newHeight, newWidth, true);
        } else{
            resized = Bitmap.createScaledBitmap(sourceBitmap, newWidth, newHeight, true);
        }
        return resized;
    }

    /**
     *
     * @param sourceBitmap
     * @param compressionFactor
     * @return
     */
    public static Bitmap compressImage(Bitmap sourceBitmap, int compressionFactor) {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inPreferredConfig = Bitmap.Config.ARGB_8888;
        opts.inSampleSize = compressionFactor;

        if (Build.VERSION.SDK_INT >= 10) {
            opts.inPreferQualityOverSpeed = true;
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sourceBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        Bitmap image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, opts);

        return image;
    }


}
