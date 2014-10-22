package com.boxfuse.samples.javaspringboothello;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AcceptanceTest {
    private static final String NAME = "John Doe";

    @Test
    public void hello() throws Exception {
        WebClient webClient = new WebClient();
        HtmlPage page = webClient.getPage(System.getProperty("url"));
        assertTrue(page.asText().contains("What's your name?"));

        HtmlForm form = page.getFormByName("name-form");
        HtmlTextInput name = form.getInputByName("name");
        name.setText(NAME);
        HtmlSubmitInput submit = form.getInputByName("submit");
        page = submit.click();
        assertTrue(page.asText().contains("Hello " + NAME));

        webClient.closeAllWindows();
    }
}
