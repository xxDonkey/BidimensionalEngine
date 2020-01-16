package basic2Dgraphics.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import basic2Dgraphics.core.Window;
import basic2Dgraphics.core.Window.ComplexMouseEventInterface;

/**
 * @author Dylan Raiff
 */
public class MouseInput implements MouseListener
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
