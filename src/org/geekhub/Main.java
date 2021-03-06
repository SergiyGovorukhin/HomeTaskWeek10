package org.geekhub;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static final String FOLDER_TO_DOWNLOAD = "d:/temp/images/";

    public static void main(String[] args) throws IOException {
        ImageCrawler imageCrawler = new ImageCrawler(FOLDER_TO_DOWNLOAD);
        imageCrawler.downloadImages("http://trinixy.ru/16356-prikolnye_kartinki_ochen_mnogo.html");

        System.out.println("While it's loading you can enter another url to start download images:");

        Scanner scanner = new Scanner(System.in);
        String command;
        while(!"exit".equals(command = scanner.next())) {
            imageCrawler.downloadImages(command);
            System.out.println("...and another url:");
        }

        imageCrawler.stop();
    }

    public void test(URL url) throws IOException {
        long time = System.currentTimeMillis();

        ImageCrawler imageCrawler = new ImageCrawler(FOLDER_TO_DOWNLOAD);
        imageCrawler.downloadImages(url.toString());

        try {
            imageCrawler.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Time spent ms " + (System.currentTimeMillis() - time));
    }
}
