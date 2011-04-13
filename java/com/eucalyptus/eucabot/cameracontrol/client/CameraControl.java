package com.eucalyptus.eucabot.cameracontrol.client;

import com.eucalyptus.eucabot.cameracontrol.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CameraControl implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
		final Button resetButton = new Button("RESET");
		final Button fastUpButton = new Button("Fast UP");
		final Button slowUpButton = new Button("Slow UP");
		final Button fastDownButton = new Button("Fast DOWN");
		final Button slowDownButton = new Button("Slow DOWN");
		final Button fastLeftButton = new Button("Fast LEFT");
		final Button slowLeftButton = new Button("Slow LEFT");
		final Button fastRightButton = new Button("Fast RIGHT");
		final Button slowRightButton = new Button("Slow RIGHT");

		RootPanel.get("resetButtonContainer").add(resetButton);
		RootPanel.get("fastUpButtonContainer").add(fastUpButton);
		RootPanel.get("slowUpButtonContainer").add(slowUpButton);
		RootPanel.get("fastDownButtonContainer").add(fastDownButton);
		RootPanel.get("slowDownButtonContainer").add(slowDownButton);
		RootPanel.get("fastLeftButtonContainer").add(fastLeftButton);
		RootPanel.get("slowLeftButtonContainer").add(slowLeftButton);
		RootPanel.get("fastRightButtonContainer").add(fastRightButton);
		RootPanel.get("slowRightButtonContainer").add(slowRightButton);

    resetButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        sendToServer("RESET");
      }
    });
    fastUpButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        sendToServer("FAST_UP");
      }
    });
    slowUpButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        sendToServer("SLOW_UP");
      }
    });
    fastDownButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        sendToServer("FAST_DOWN");
      }
    });
    slowDownButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        sendToServer("SLOW_DOWN");
      }
    });
    fastLeftButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        sendToServer("FAST_LEFT");
      }
    });
    slowLeftButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        sendToServer("SLOW_LEFT");
      }
    });
    fastRightButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        sendToServer("FAST_RIGHT");
      }
    });
    slowRightButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        sendToServer("SLOW_RIGHT");
      }
    });

  }

	public static native void log(String msg) /*-{
    console.log(msg);
  }-*/;

  public void sendToServer(String action) {
    greetingService.greetServer(action, new AsyncCallback<String>() {
      public void onFailure(Throwable caught) {
        log("Failure!");
      }

      public void onSuccess(String result) {
        log(">>> " + result);
      }
    });
  }
}
