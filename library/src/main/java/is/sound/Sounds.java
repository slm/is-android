package is.sound;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;

import is.BaseCheck;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Sounds extends BaseCheck {

    public Sounds(Context context) {
        super(context);
    }

    /**
     * It's just only check STREAM_SYSTEM
     * @return isMuted
     */
     public boolean isMute(){
         AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
         return audioManager.getStreamVolume(AudioManager.STREAM_SYSTEM)==0;
    }

    /**
     *
     * @param streamType
     * @return
     */
    public boolean isMute(int streamType){
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        return audioManager.getStreamVolume(streamType)==0;
    }

    /**
     *
     * @return isMax
     */
    public boolean isMax(){
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        return audioManager.getStreamVolume(AudioManager.STREAM_SYSTEM)==audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM);
    }

    /**
     *
     * @param streamType
     * @return
     */
    public boolean isMax(int streamType){
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        return audioManager.getStreamVolume(streamType)==audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM);
    }

    /**
     * @return int
     */
    public int getMediaVolume() {
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        return audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
    }

    /**
     * @return int
     */
    public int getRingVolume() {
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        return audioManager.getStreamVolume(AudioManager.STREAM_RING);
    }



}
