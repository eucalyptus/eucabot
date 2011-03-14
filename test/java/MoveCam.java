
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.nio.IntBuffer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.eucalyptus.eucabot.webcam.CControlValue;
import com.eucalyptus.eucabot.webcam.CDevice;
import com.eucalyptus.eucabot.webcam.WebcamLibrary;

public class MoveCam extends JPanel implements KeyListener {
	private JFrame parent;
	private int handle = -1;

	public MoveCam(JFrame parent) {
		this.parent = parent;
		JTextField tf = new JTextField("click here to gain focus");
		tf.addKeyListener(this);
		this.add(tf);

		WebcamLibrary.c_init();

		IntBuffer req_size = IntBuffer.allocate(1);
		IntBuffer count = IntBuffer.allocate(1);
		WebcamLibrary.c_enum_devices(null, req_size, count);
		int n = count.get();
		System.out.println("found "+n+" cams");

		CDevice device = new CDevice();
		CDevice [] devs = {device, new CDevice()};
//		WebcamLibrary.c_enum_devices(device, req_size, count);
//		for (CDevice dev : devs) {
//			System.out.println("found : "+dev.shortName.getString(0)+": "+dev.name.getString(0));
//		}
		this.handle = WebcamLibrary.c_open_device("video0");
		System.out.println("dev handle : "+handle);

		setControl(0x23, 1);	// Tilt reset
		try { Thread.sleep(2000); } catch (Exception ex) {}
		setControl(0x22, 1);	// Pan reset
		try { Thread.sleep(2000); } catch (Exception ex) {}
	}

	public void close() {
		if (handle != -1) {
			WebcamLibrary.c_close_device(handle);
		}
		WebcamLibrary.c_cleanup();
	}

	public void keyPressed(KeyEvent e) {
		int speed = 1;
		if (e.isAltDown()) speed = 3;
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setControl(0x1c, 200/speed);	// Pan (relative)
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setControl(0x1c, -200/speed);	// Pan (relative)
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			setControl(0x1e, 200/speed);	// Tilt (relative)
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			setControl(0x1e, -200/speed);	// Tilt (relative)
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	private void setControl(int control, int value) {
		if (this.handle == -1) return;
		int ret = WebcamLibrary.c_set_control(this.handle, control,
			new CControlValue(WebcamLibrary.CControlType.CC_TYPE_DWORD, value));
		System.out.println("setControl ret = "+ret);
	}

    public static void main(String[] args) {
		final JFrame frame = new JFrame("cam mover");
		final MoveCam mc = new MoveCam(frame);
		frame.setSize(300, 100);
		frame.addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent event) {
				mc.close();
				System.exit(0);
			}
		});
		frame.setContentPane(mc);
		frame.setVisible(true);
    }

}

