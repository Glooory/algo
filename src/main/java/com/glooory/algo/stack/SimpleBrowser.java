package com.glooory.algo.stack;

public class SimpleBrowser {
    private StackBasedOnArray forwardStack = new StackBasedOnArray(4);
    private final StackBasedOnArray backStack = new StackBasedOnArray(4);
    private int currPage = Integer.MIN_VALUE;

    public SimpleBrowser() {};

    public SimpleBrowser(int page) {
        currPage = page;
    }

    public void go(int page) {
        if (Integer.MIN_VALUE == currPage) {
            currPage = page;
            return;
        }

        backStack.push(currPage);
        forwardStack = new StackBasedOnArray(4);
        currPage = page;
    }

    public void goForward() {
        if (canGoForward()) {
            backStack.push(currPage);
            currPage = forwardStack.pop();
        }
    }

    public void goBack() {
        if (canGoBack()) {
            forwardStack.push(currPage);
            currPage = backStack.pop();
        }
    }

    public boolean canGoForward() {
        return forwardStack.size() > 0;
    }

    public boolean canGoBack() {
        return backStack.size() > 0;
    }

    public int getCurrentPage() {
        return currPage;
    }
}
