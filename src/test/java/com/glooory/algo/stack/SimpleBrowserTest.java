package com.glooory.algo.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBrowserTest {
    private SimpleBrowser browser = null;
    private final int NUM_1 = 1;
    private final int NUM_2 = 2;
    private final int NUM_3 = 3;
    private final int NUM_4 = 4;

    @BeforeEach
    void setup() {
        browser = new SimpleBrowser();
    }

    @AfterEach
    void clearUp() {
        browser = null;
    }

    @Test
    void initialState() {
        assertEquals(Integer.MIN_VALUE, browser.getCurrentPage());
        assertFalse(browser.canGoForward());
        assertFalse(browser.canGoBack());

        browser = new SimpleBrowser(NUM_4);
        assertEquals(NUM_4, browser.getCurrentPage());
        assertFalse(browser.canGoForward());
        assertFalse(browser.canGoBack());
    }

    @Test
    void go() {
        browser.go(NUM_1);
        assertEquals(NUM_1, browser.getCurrentPage());
        browser.go(NUM_2);
        assertEquals(NUM_2, browser.getCurrentPage());
        assertTrue(browser.canGoBack());
        browser.go(NUM_3);
        assertEquals(NUM_3, browser.getCurrentPage());
        assertTrue(browser.canGoBack());
    }

    @Test
    void goForward() {
        browser.go(NUM_1);
        browser.go(NUM_2);
        browser.go(NUM_3);
        browser.goBack();
        browser.goBack();
        assertTrue(browser.canGoForward());
        browser.goForward();
        assertEquals(NUM_2, browser.getCurrentPage());
        browser.goForward();
        assertEquals(NUM_3, browser.getCurrentPage());
        assertTrue(browser.canGoBack());
    }

    @Test
    void goBack() {
        browser.go(NUM_1);
        browser.go(NUM_2);
        browser.go(NUM_3);
        assertTrue(browser.canGoBack());
        browser.goBack();
        assertTrue(browser.canGoForward());
        assertEquals(NUM_2, browser.getCurrentPage());
        browser.goBack();
        assertFalse(browser.canGoBack());
        assertEquals(NUM_1, browser.getCurrentPage());
    }

    @Test
    void canGoForward() {
        assertFalse(browser.canGoForward());
        browser.go(NUM_1);
        assertFalse(browser.canGoForward());
        browser.go(NUM_2);
        assertFalse(browser.canGoForward());
        browser.goBack();
        assertTrue(browser.canGoForward());
        browser.goForward();
        assertFalse(browser.canGoForward());
    }

    @Test
    void canGoBack() {
        assertFalse(browser.canGoBack());
        browser.go(NUM_1);
        assertFalse(browser.canGoBack());
        browser.go(NUM_2);
        assertTrue(browser.canGoBack());
        browser.goBack();;
        assertFalse(browser.canGoBack());
    }

    @Test
    void getCurrentPage() {
        browser.go(NUM_1);
        assertEquals(NUM_1, browser.getCurrentPage());
        browser.go(NUM_2);
        assertEquals(NUM_2, browser.getCurrentPage());
    }
}