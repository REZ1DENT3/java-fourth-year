package net.babichev.post.nnm;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import java.net.MalformedURLException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    private static String authLink = "http://nnm-club.me/forum/login.php";
    private static String thankLink = "http://nnm-club.me/forum/thank.php?a="; // + index

    private static String[] data = {"my-login", "my-password", "on"};

    private static String[] forPOST = {"username", "password", "autologin"};

    public static void main(String[] args) {

        for (int i = 809295; i > 0; --i) {

            URL url;

            try {
                url = new URL(authLink);

                try {

                    URLConnection urlConnection = url.openConnection();
                    HttpURLConnection httpConn = (HttpURLConnection) urlConnection;

                    httpConn.setRequestProperty("Accept", "application/json");
                    httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpConn.setRequestProperty("Connection", "keep-alive");
                    httpConn.setRequestMethod("POST");

                    String data = "json='{\"parameter\":[{\"name\":\"IPA_URL\",\"value\":\"a\"},{\"name\":\"IPA_FI‌​LENAME\",\"value\":\"a.ipa\"}]}'";
                    httpConn.setDoOutput(true);
                    httpConn.setDoInput(true);

                    OutputStreamWriter wr = new OutputStreamWriter(httpConn.getOutputStream());
                    wr.write(data.toString());
                    wr.flush();
                    wr.close();

                    String line;

                    ArrayList<String> result = new ArrayList<String>();

                    InputStreamReader inpStreamReader = new InputStreamReader(httpConn.getInputStream());

                    BufferedReader rd = new BufferedReader(inpStreamReader);

                    while ((line = rd.readLine()) != null) {
                        result.add(line);
                    }

                    rd.close();


                } catch (IOException $e) {
                    System.out.println($e.getMessage());
                }

            } catch (MalformedURLException $e) {
                System.out.println($e.getMessage());
            }

        }

    }

}
