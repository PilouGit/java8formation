package com.neuresys.formation.java8.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.html2pdf.HtmlConverter;

import java.util.UUID;
import java.util.concurrent.*;

public class ConsumerItext {

    private static final int NUM_OF_MSGS = 20;
    private static final BlockingQueue<String> queueHtml 
                                              = new ArrayBlockingQueue<String>(5);
    private static final BlockingQueue<File> queueFile= new ArrayBlockingQueue<File>(5);
    
    private static ExecutorService consumerHtmlPool = Executors.newFixedThreadPool(4);
    private static ExecutorService consumerFilePool = Executors.newFixedThreadPool(4);

    private static Logger logger =  Logger.getLogger(ConsumerItext.class.getName());

    public static void main(String[] args) throws IOException {
     
        Runnable consumerTask = () -> {
            try {
                
            	String html=queueHtml.take();
            	UUID uuid=UUID.randomUUID();
            	File outputFile=new File(uuid.toString()+".pdf");
            	HtmlConverter.convertToPdf(html, new FileOutputStream(outputFile));
            	queueFile.put(outputFile);
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, e.getMessage(), e);
            } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        };
        Runnable consumerFileTask = () -> {
            try {
                
            	File pdfFile=queueFile.take();
            	System.err.println(pdfFile.getAbsolutePath());
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, e.getMessage(), e);
            }
        };
        try {
            for (int i = 0; i < NUM_OF_MSGS; i++) {
            	consumerHtmlPool.submit(consumerFileTask);
            }
            for (int i = 0; i < NUM_OF_MSGS; i++) {
            	consumerFilePool.submit(consumerTask);
            }
            for (int i=0;i<10;i++)
				try {
					queueHtml.offer("\"<h1>Hello</h1>\"\r\n"
							+ "			+ \"<p>This was created using iText</p>\"\r\n"
							+ "			",5,TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            System.in.read();
        } finally {
            if (consumerHtmlPool != null) {
            	consumerHtmlPool.shutdown();
            }
            if (consumerFilePool != null) {
            	consumerFilePool.shutdown();
            }
        }
    }

}