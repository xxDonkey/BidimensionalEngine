package bidimensionalengine.audio;

import javax.sound.sampled.FloatControl;

import bidimensionalengine.datastructs.Vector2;
import bidimensionalengine.playercomponents.Transform;

/**
 * Plays audio that can decrease with distance from a given point.
 * 
 * @author Dylan Raiff
 * @version 1.0
 */
public class DistanceAudioPlayer
{
	/* Static data */

	/**
	 * Distance at which audio can no longer be heard.
	 */
	public static final double falloffDistance = 35;

	/* Instance data */

	/**
	 * Listener of the audio.
	 */
	private Transform listener;

	/**
	 * Creates a new {@code DistanceAudioPlayer}.
	 * 
	 * @param listener listener of the audio
	 */
	public DistanceAudioPlayer(Transform listener)
	{ this.listener = listener; }

	/**
	 * @param audio
	 */
	public void playAudio(Audio audio, Vector2 location)
	{
		double dst = Vector2.distance(location, listener.position);
		double percent = 1d / (dst <= 10E-6 ? 1 : dst);

		// not working, idk why
		FloatControl volume = (FloatControl) audio.getClip().getControl(FloatControl.Type.VOLUME);
		volume.setValue((float) ((volume.getMaximum() - volume.getMinimum()) * percent));
		audio.play();
	}
}
