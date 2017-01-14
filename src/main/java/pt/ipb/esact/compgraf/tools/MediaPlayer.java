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

    public Player play(final String path) {
        return play(path, 0);
    }

    public Player play(final String path, final long delay) {
        if (!playerCache.containsKey(path))
            try {
                playerCache.put(path, Files.readAllBytes(Paths.get(path)));
            } catch (IOException e) {
                GlTools.exit(e.getMessage());
            }

        try (ByteArrayInputStream bis = new ByteArrayInputStream(playerCache.get(path))) {
            final Player player = new Player(bis);
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    if (player != null) {
                        try {
                            Thread.sleep(delay);
                            player.play();
                        } catch (JavaLayerException | InterruptedException e) {
                            GlTools.exit(e.getMessage());
                        }
                    }
                }
            });
            return player;
        } catch (JavaLayerException | IOException e) {
            GlTools.exit(e.getMessage());
            return null;
        }
    }

}
