package com.eucalyptus.eucabot.cameracontrol.server;

import com.eucalyptus.eucabot.cameracontrol.client.GreetingService;
import com.eucalyptus.eucabot.cameracontrol.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.nio.IntBuffer;

import com.eucalyptus.eucabot.webcam.CControlValue;
import com.eucalyptus.eucabot.webcam.CDevice;
import com.eucalyptus.eucabot.webcam.WebcamLibrary;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
  private int handle = -1;

  public GreetingServiceImpl() {
	WebcamLibrary.c_init();
	IntBuffer req_size = IntBuffer.allocate(1);
	IntBuffer count = IntBuffer.allocate(1);
	WebcamLibrary.c_enum_devices(null, req_size, count);
	int n = count.get();
	System.out.println("found "+n+" cams");
	this.handle = WebcamLibrary.c_open_device("video0");
  }
  public String greetServer(String input) throws IllegalArgumentException {
    System.out.println("I got: " + input);
	if (input.equals("RESET")) {
		setControl(0x23, 1);	// Tilt reset
		try { Thread.sleep(2000); } catch (Exception ex) {}
		setControl(0x22, 1);	// Pan reset
		try { Thread.sleep(2000); } catch (Exception ex) {}
	}
	else if (input.equals("FAST_UP")) {
		setControl(0x1e, 200);	// Tilt (relative)
	}
	else if (input.equals("SLOW_UP")) {
		setControl(0x1e, 70);	// Tilt (relative)
	}
	else if (input.equals("FAST_DOWN")) {
		setControl(0x1e, -200);	// Tilt (relative)
	}
	else if (input.equals("SLOW_DOWN")) {
		setControl(0x1e, -70);	// Tilt (relative)
	}
	else if (input.equals("FAST_LEFT")) {
		setControl(0x1c, 200);	// Pan (relative)
	}
	else if (input.equals("SLOW_LEFT")) {
		setControl(0x1c, 70);	// Pan (relative)
	}
	else if (input.equals("FAST_RIGHT")) {
		setControl(0x1c, -200);	// Pan (relative)
	}
	else if (input.equals("SLOW_RIGHT")) {
		setControl(0x1c, -70);	// Pan (relative)
	}
    return input;
  }

	private void setControl(int control, int value) {
		if (this.handle == -1) return;
		int ret = WebcamLibrary.c_set_control(this.handle, control,
			new CControlValue(WebcamLibrary.CControlType.CC_TYPE_DWORD, value));
		System.out.println("setControl ret = "+ret);
	}

	public void close() {
		if (handle != -1) {
			WebcamLibrary.c_close_device(handle);
		}
		WebcamLibrary.c_cleanup();
	}
}
