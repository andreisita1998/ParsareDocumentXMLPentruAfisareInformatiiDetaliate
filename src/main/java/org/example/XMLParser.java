package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XMLParser {
    public static void main(String[] args) {
        try {
            String filePath = "books.xml";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(filePath));

            NodeList bookList = document.getElementsByTagName("book");

            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;

                    String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                    String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                    double price = Double.parseDouble(bookElement.getElementsByTagName("price").item(0).getTextContent());
                    String publishDate = bookElement.getElementsByTagName("publish_date").item(0).getTextContent();

                    if (price > 10) {
                        int publishYear = Integer.parseInt(publishDate.substring(0, 4));
                        if (publishYear > 2005) {
                            System.out.println("Title: " + title);
                            System.out.println("Author: " + author);
                            System.out.println("Price: " + price);
                            System.out.println("Publish Date: " + publishDate);
                            System.out.println("-----------------------------");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}