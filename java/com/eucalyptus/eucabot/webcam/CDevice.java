package com.eucalyptus.eucabot.webcam;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class CDevice extends Structure {
	/**
	 * This member is never NULL.<br>
	 * C type : char*
	 */
	public Pointer shortName;
	/**
	 * This member is never NULL.<br>
	 * C type : char*
	 */
	public Pointer name;
	/**
	 * This member is never NULL.<br>
	 * C type : char*
	 */
	public Pointer driver;
	/**
	 * This member is never NULL.<br>
	 * C type : char*
	 */
	public Pointer location;
	/**
	 * USB related information about the camera.<br>
	 * C type : CUSBInfo
	 */
	public CUSBInfo usb;
	public CDevice() {
		super();
		initFieldOrder();
	}
	protected void initFieldOrder() {
		setFieldOrder(new java.lang.String[]{"shortName", "name", "driver", "location", "usb"});
	}
	/**
	 * @param shortName This member is never NULL.<br>
	 * C type : char*<br>
	 * @param name This member is never NULL.<br>
	 * C type : char*<br>
	 * @param driver This member is never NULL.<br>
	 * C type : char*<br>
	 * @param location This member is never NULL.<br>
	 * C type : char*<br>
	 * @param usb USB related information about the camera.<br>
	 * C type : CUSBInfo
	 */
	public CDevice(Pointer shortName, Pointer name, Pointer driver, Pointer location, CUSBInfo usb) {
		super();
		this.shortName = shortName;
		this.name = name;
		this.driver = driver;
		this.location = location;
		this.usb = usb;
		initFieldOrder();
	}
	public static class ByReference extends CDevice implements Structure.ByReference {
		
	};
	public static class ByValue extends CDevice implements Structure.ByValue {
		
	};
}
