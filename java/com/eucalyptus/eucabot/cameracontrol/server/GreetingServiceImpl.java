package com.eucalyptus.eucabot.cameracontrol.server;

import com.eucalyptus.eucabot.cameracontrol.client.GreetingService;
import com.eucalyptus.eucabot.cameracontrol.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
    GreetingService {

  public String greetServer(String input) throws IllegalArgumentException {
    System.out.println("I got: " + input);
    return input;
  }
}
