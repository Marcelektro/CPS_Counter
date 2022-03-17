package net.marcelektro;

import java.util.LinkedList;
import java.util.Queue;

public class CpsCounter {
    private final Queue<Long> clicks = new LinkedList<>();

    public void click() {
        this.clicks.add(System.currentTimeMillis());
    }

    public int getCPS() {
        while (!clicks.isEmpty() && clicks.peek() < System.currentTimeMillis() - 1000) {
            clicks.remove();
        }

        return clicks.size();
    }

}
