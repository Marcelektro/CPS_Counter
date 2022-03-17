package net.marcelektro;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseListener;

public class Main {
    public static final CpsCounter leftClickCounter = new CpsCounter();
    public static final CpsCounter rightClickCounter = new CpsCounter();

    private static CounterGui gui;

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();

            GlobalScreen.addNativeMouseListener(new NativeMouseListener() {
                @Override
                public void nativeMouseClicked(NativeMouseEvent event) {}

                @Override
                public void nativeMousePressed(NativeMouseEvent event) {
                    // Left click
                    if (event.getButton() == 1) {
                        leftClickCounter.click();
                    }

                    // Right click
                    if (event.getButton() == 2) {
                        rightClickCounter.click();
                    }
                }

                @Override
                public void nativeMouseReleased(NativeMouseEvent event) {}
            });

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        gui = new CounterGui();

        new Thread(() -> {
            while(true) {

                gui.update();

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException e) {
                e.printStackTrace();
            }
        }));

    }
}
