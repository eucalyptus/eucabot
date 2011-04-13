package com.eucalyptus.eucabot.cameracontrol.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class CameraControl {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        // Create an embedded Jetty server on port 8080
        Server server = new Server(8080);

        /*
        // Create a handler for processing our GWT app
        WebAppContext handler = new WebAppContext();
        handler.setContextPath("/CameraControl");
        handler.setWar("./build/CameraControl.war");
        */

        // If your app isn't packaged into a WAR, you can do this instead
        WebAppContext altHandler = new WebAppContext();
        altHandler.setResourceBase("./build/war");
        altHandler.setDescriptor("./build/war/WEB-INF/web.xml");
        altHandler.setContextPath("/");
        altHandler.setParentLoaderPriority(true);
        // Add it to the server
        //server.setHandler(handler);
        server.setHandler(altHandler);

        // Other misc. options
        server.setThreadPool(new QueuedThreadPool(20));

        // And start it up
        server.start();
        server.join();
	}

}
