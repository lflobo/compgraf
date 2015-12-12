package pt.ipb.esact.compgraf.tools;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

class ClipData {
    int size;
    byte[] audio;
    AudioFormat audioFormat;
}

public abstract class MediaPlayer {

    private static final Logger logger = LoggerFactory.getLogger(MediaPlayer.class);

    public static final Map<String, ClipData> audioCache = Maps.newHashMap();

    public static void playSound(String path) {
        ClipData clipData = null;

        if (audioCache.containsKey(path)) {
            clipData = audioCache.get(path);
        } else {
            try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path))) {
                clipData = new ClipData();
                clipData.audioFormat = audioInputStream.getFormat();
                clipData.size = (int) (clipData.audioFormat.getFrameSize() * audioInputStream.getFrameLength());
                clipData.audio = new byte[clipData.size];
                audioInputStream.read(clipData.audio, 0, clipData.size);
                audioCache.put(path, clipData);
            } catch (UnsupportedAudioFileException e) {
                GlTools.exit("Ficheiro não suportado: " + e.getMessage());
                return;
            } catch (IOException e) {
                GlTools.exit(e.getMessage());
                return;
            }
        }

        DataLine.Info info = new DataLine.Info(Clip.class, clipData.audioFormat, clipData.size);
        try {
            final Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(clipData.audioFormat, clipData.audio, 0, clipData.size);
            new Thread() {
                public void run() {
                    clip.start();
                }
            }.start();
        } catch (LineUnavailableException e) {
            GlTools.exit(e.getMessage());
        }
    }

    public static void clear() {
        audioCache.clear();
    }

}
