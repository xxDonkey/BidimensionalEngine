package bidimensionalengine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import bidimensionalengine.core.Window;
import bidimensionalengine.core.Window.ComplexKeyEventInterface;

/**
 * @author Dylan Raiff
 */
public class KeyboardInput implements KeyListener
{
	@Override
	public void keyPressed(KeyEvent e)
	{
		if (Window.getOnKeyboardInputMethodData() == null)
			return;

		ComplexKeyEventInterface ckei = Window.getOnKeyboardInputMethodData().onKeyPressed;
		if (ckei == null)
			return;

		ckei.method(e);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		if (Window.getOnKeyboardInputMethodData() == null)
			return;

		ComplexKeyEventInterface ckei = Window.getOnKeyboardInputMethodData().onKeyTyped;
		if (ckei == null)
			return;

		ckei.method(e);
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (Window.getOnKeyboardInputMethodData() == null)
			return;

		ComplexKeyEventInterface ckei = Window.getOnKeyboardInputMethodData().onKeyReleased;
		if (ckei == null)
			return;

		ckei.method(e);
	}

}
