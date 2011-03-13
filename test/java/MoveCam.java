
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.IntByReference;

import com.eucalyptus.eucabot.webcam.CDevice;
import com.eucalyptus.eucabot.webcam.WebcamLibrary;

/** Simple example of JNA interface mapping and usage. */
public class MoveCam {

    public static void main(String[] args) {
        WebcamLibrary.c_init();
		CDevice devs = new CDevice();
		IntByReference req_size = new IntByReference();
		IntByReference count = new IntByReference();
		WebcamLibrary.c_enum_devices(devs, req_size, count);
		System.out.println("found "+count.getValue()+" cams");
//		for (CDevice dev : devs) {
//			System.out.println("found  :"+dev.name);
//		}

        WebcamLibrary.c_cleanup();
    }
}

