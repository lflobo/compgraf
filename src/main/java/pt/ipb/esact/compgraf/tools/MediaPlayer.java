package pt.ipb.esact.compgraf.tools;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MediaPlayer {

	private static final Logger logger = LoggerFactory.getLogger(MediaPlayer.class);

	public static void playSound(Object reference, String path) {
		URL url = reference.getClass().getResource(path);
		try (AudioInputStream audio = AudioSystem.getAudioInputStream(url)) {
			final Clip clip = AudioSystem.getClip();
			clip.open(audio);
			new Thread() {
				public void run() {
					clip.start();
				};
			}.start();
		} catch (IOException e) {
			logger.error("Error loading audio file: " + e.getMessage(), e);
		} catch (UnsupportedAudioFileException e) {
			logger.error("Audio file not supported: " + e.getMessage(), e);
		} catch (LineUnavailableException e) {
			logger.error("Sound system failed: " + e.getMessage(), e);
		}

	}

}
