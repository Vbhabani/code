/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.link_shortener;

/**
 *
 * @author vbhabani_RaJu..
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class URLShortenerGUI extends JFrame {
    private JTextField originalUrlTextField;
    private JTextField shortUrlTextField;
    private JButton shortenButton;
    private Map<String, String> urlMap;

    public URLShortenerGUI() {
        // Initialize the URL map
        urlMap = new HashMap<>();

        // Set up the JFrame
        setTitle("URL Shortener");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);

        // Create components
        originalUrlTextField = new JTextField();
        shortUrlTextField = new JTextField();
        shortUrlTextField.setEditable(false);
        shortenButton = new JButton("Shorten");

        // Set layout
        setLayout(new GridLayout(3, 2));

        // Add components to the JFrame
        add(new JLabel("Original URL:"));
        add(originalUrlTextField);
        add(new JLabel("Shortened URL:"));
        add(shortUrlTextField);
        add(new JLabel());
        add(shortenButton);

        // Add action listener to the shorten button
        shortenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shortenUrl();
            }
        });
    }

    private void shortenUrl() {
        String originalUrl = originalUrlTextField.getText().trim();

        if (originalUrl.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid URL.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if the URL is already shortened
        if (urlMap.containsValue(originalUrl)) {
            for (Map.Entry<String, String> entry : urlMap.entrySet()) {
                if (entry.getValue().equals(originalUrl)) {
                    shortUrlTextField.setText(entry.getKey());
                    return;
                }
            }
        }

        // Generate a short URL
        String shortUrl = generateShortUrl();
        urlMap.put(shortUrl, originalUrl);
        shortUrlTextField.setText(shortUrl);
    }

    private String generateShortUrl() {
        // Generate a random short URL (in practice, a more sophisticated algorithm
        // would be used)
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 6;
        Random random = new Random();
        StringBuilder shortUrl = new StringBuilder();

        for (int i = 0; i < length; i++) {
            shortUrl.append(characters.charAt(random.nextInt(characters.length())));
        }

        return shortUrl.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new URLShortenerGUI().setVisible(true);
            }
        });
    }
}
