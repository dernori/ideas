package com.floppylab.ideas.service;

import org.springframework.stereotype.Service;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;

@Service
public class MarkdownService {
	
	public String convertToHtml(String text) {
		MutableDataSet options = new MutableDataSet();
		
        // uncomment to convert soft-breaks to hard breaks
        //options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Node document = parser.parse(text);
        return renderer.render(document);
	}

}
