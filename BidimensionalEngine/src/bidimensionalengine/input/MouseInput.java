package bidimensionalengine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import bidimensionalengine.core.Window;
import bidimensionalengine.core.Window.ComplexMouseEventInterface;
import bidimensionalengine.ui.Button;
import bidimensionalengine.ui.UIElement;

/**
 * @author Dylan Raiff
 * @version 1.0
 */
public final class MouseInput implements MouseListener
{
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (Window.getOnMouseInputMethodData() == null)
			return;

		ComplexMouseEventInterface cmei = Window.getOnMouseInputMethodData().onMouseClicked;
		if (cmei == null)
			return;

		cmei.method(e);

		if (Window.getGameLoop() != null)
			for (UIElement uiElement : Window.getGameLoop().getUIElements())
			{
				if (uiElement instanceof Button)
					((Button) uiElement).onMouseClick();
			}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if (Window.getOnMouseInputMethodData() == null)
			return;

		ComplexMouseEventInterface cmei = Window.getOnMouseInputMethodData().onMousePressed;
		if (cmei == null)
			return;

		cmei.method(e);
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (Window.getOnMouseInputMethodData() == null)
			return;

		ComplexMouseEventInterface cmei = Window.getOnMouseInputMethodData().onMouseReleased;
		if (cmei == null)
			return;

		cmei.method(e);

		if (Window.getGameLoop() != null)
			for (UIElement uiElement : Window.getGameLoop().getUIElements())
			{
				if (uiElement instanceof Button)
					((Button) uiElement).onMouseRelease();
			}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		if (Window.getOnMouseInputMethodData() == null)
			return;

		ComplexMouseEventInterface cmei = Window.getOnMouseInputMethodData().onMouseEntered;
		if (cmei == null)
			return;

		cmei.method(e);
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		if (Window.getOnMouseInputMethodData() == null)
			return;

		ComplexMouseEventInterface cmei = Window.getOnMouseInputMethodData().onMouseExited;
		if (cmei == null)
			return;

		cmei.method(e);
	}

}
