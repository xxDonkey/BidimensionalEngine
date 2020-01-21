package bidimensionalengine.audio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import bidimensionalengine.core.Window;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public class AudioLoader
{
	/**
	 * Private constructer to disallow instantiation of the class.
	 */
	private AudioLoader()
	{}

	/**
	 * List of all loaded audio files.
	 */
	private static ArrayList<Audio> loadedAudio = new ArrayList<Audio>();

	public static boolean loadAudio(String filename)
	{
		if (Window.getInstance() == null)
			return false;

		File audioFile = new File(Window.getAssetDirectory() + "audio/" + filename);
		AudioInputStream stream = null;
		AudioFormat format = null;
		DataLine.Info info = null;
		Clip clip = null;

		try
		{
			stream = AudioSystem.getAudioInputStream(audioFile);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);

			clip = (Clip) AudioSystem.getLine(info);
			System.out.println(clip);
			loadedAudio.add(new Audio(filename, clip, stream));
		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
