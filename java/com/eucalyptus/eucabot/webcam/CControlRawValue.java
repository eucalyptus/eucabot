package com.eucalyptus.eucabot.webcam;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class CControlRawValue extends Structure {
	/**
	 * Pointer to the raw data.<br>
	 * C type : void*
	 */
	public Pointer data;
	/// Size of the raw data.
	public int size;
	public CControlRawValue() {
		super();
		initFieldOrder();
	}
	protected void initFieldOrder() {
		setFieldOrder(new java.lang.String[]{"data", "size"});
	}
	/**
	 * @param data Pointer to the raw data.<br>
	 * C type : void*<br>
	 * @param size Size of the raw data.
	 */
	public CControlRawValue(Pointer data, int size) {
		super();
		this.data = data;
		this.size = size;
		initFieldOrder();
	}
	public static class ByReference extends CControlRawValue implements Structure.ByReference {
		
	};
	public static class ByValue extends CControlRawValue implements Structure.ByValue {
		
	};
}