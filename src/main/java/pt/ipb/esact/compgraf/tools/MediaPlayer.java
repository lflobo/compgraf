package pt.ipb.esact.compgraf.tools;

import com.google.common.collect.Maps;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//class ClipData {
//    int size;
//    byte[] audio;
//    AudioFormat audioFormat;
//}

public class MediaPlayer {

    private static final Logger logger = LoggerFactory.getLogger(MediaPlayer.class);

    private static MediaPlayer INSTANCE;

    private final Map<String, byte[]> playerCache = Maps.newHashMap();

    private ExecutorService executorService;

    private MediaPlayer() {
        executorService = Executors.newFixedThreadPool(10);
    }

    public static MediaPlayer getInstance() {
        if (INSTANCE == null)
            INSTANCE = new MediaPlayer();
        return INSTANCE;
    }

    public void play(final String path) {
        play(path, 0);
    }

    public void play(final String path, final long delay) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                if (!playerCache.containsKey(path))
                    try {
                        playerCache.put(path, Files.readAllBytes(Paths.get(path)));
                    } catch (IOException e) {
                        GlTools.exit(e.getMessage());
                    }

                try (ByteArrayInputStream bis = new ByteArrayInputStream(playerCache.get(path))) {
                    Player player = new Player(bis);
                    Thread.sleep(delay);
                    player.play();
                } catch (InterruptedException | JavaLayerException | IOException e) {
                    GlTools.exit(e.getMessage());
                }
            }
        });
//        ClipData clipData = null;
//
//        if (audioCache.containsKey(path)) {
//            clipData = audioCache.get(path);
//        } else {
//            try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path))) {
//                clipData = new ClipData();
//                clipData.audioFormat = audioInputStream.getFormat();
//                clipData.size = (int) (clipData.audioFormat.getFrameSize() * audioInputStream.getFrameLength());
//                clipData.audio = new byte[clipData.size];
//                audioInputStream.read(clipData.audio, 0, clipData.size);
//                audioCache.put(path, clipData);
//            } catch (UnsupportedAudioFileException e) {
//                GlTools.exit("Ficheiro não suportado: " + e.getMessage());
//                return;
//            } catch (IOException e) {
//                GlTools.exit(e.getMessage());
//                return;
//            }
//        }
//
//        DataLine.Info info = new DataLine.Info(Clip.class, clipData.audioFormat, clipData.size);
//        try {
//            final Clip clip = (Clip) AudioSystem.getLine(info);
//            clip.open(clipData.audioFormat, clipData.audio, 0, clipData.size);
//            new Thread() {
//                public void run() {
//                    clip.start();
//                }
//            }.start();
//        } catch (LineUnavailableException e) {
//            GlTools.exit(e.getMessage());
//        }
    }

//    public static void clear() {
//        audioCache.clear();
//    }

}
