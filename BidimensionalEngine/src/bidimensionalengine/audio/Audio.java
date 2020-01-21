package bidimensionalengine.audio;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public class Audio
{
	/**
	 * Name of the audio.
	 */
	private String name;

	/**
	 * Object holding audio data.
	 */
	private Clip audio;

	/**
	 * Stream of the {@code Clip}.
	 */
	private AudioInputStream stream;

	/**
	 * Creates a new {@code Audio} object and assigns variables.
	 * 
	 * @param name   name of the audio
	 * @param audio  {@code Clip} holding audio information
	 * @param stream {@code AudioInputStream} of the audio's clip
	 */
	public Audio(String name, Clip audio, AudioInputStream stream)
	{
		this.name = name;
		this.audio = audio;
		this.stream = stream;
	}

	/**
	 * Attempts to play the stored {@code Clip}.
	 * 
	 * @return true if successfully played, false if not
	 */
	public boolean play()
	{
		audio.addLineListener(new LineListener()
		{
			@Override
			public void update(LineEvent event)
			{
				if (event.getType() == LineEvent.Type.STOP)
					audio.close();
			}
		});

		try
		{
			audio.open(stream);
			audio.start();
		}
		catch (LineUnavailableException | IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* Access methods */

	/**
	 * @return name of the audio
	 */
	public String getName()
	{ return name; }
}
