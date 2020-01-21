package bidimensionalengine.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;

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

	/* Access methods */

	public String getName()
	{ return name; }
}
