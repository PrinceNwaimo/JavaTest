package makingAdifference;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SMSLanguageTranslator {
    private static final Map<String, String> smsToEnglish = new HashMap<>();
    private static final Map<String, String> englishToSMS = new HashMap<>();

    static {
        smsToEnglish.put("imo", "in my opinion");
        smsToEnglish.put("btw", "by the way");
        smsToEnglish.put("imo", "in my opinion");
        smsToEnglish.put("tbh", "to be honest");
        smsToEnglish.put("idk", "I don't know");
        smsToEnglish.put("iirc", "if I remember correctly");
        smsToEnglish.put("brb", "be right back");
        smsToEnglish.put("btwn", "between");
        smsToEnglish.put("cu", "see you");
        smsToEnglish.put("fyi", "for your information");
        smsToEnglish.put("gg", "good game");
        smsToEnglish.put("gr8", "great");
        smsToEnglish.put("imo", "in my opinion");
        smsToEnglish.put("l8r", "later");
        smsToEnglish.put("lol", "laugh out loud");
        smsToEnglish.put("np", "no problem");
        smsToEnglish.put("omg", "oh my god");
        smsToEnglish.put("plz", "please");
        smsToEnglish.put("thx", "thanks");
        smsToEnglish.put("u", "you");
        smsToEnglish.put("ur", "your");
        smsToEnglish.put("w8", "wait");
        smsToEnglish.put("wbu", "what about you");
        smsToEnglish.put("wyd", "what you doing");
        smsToEnglish.put("ykw", "you know what");
        smsToEnglish.put("ym", "young man");
        smsToEnglish.put("yw", "you're welcome");

        for (Map.Entry<String, String> entry : smsToEnglish.entrySet()) {
            englishToSMS.put(entry.getValue(), entry.getKey());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SMS Language Translator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea inputTextArea = new JTextArea(10, 20);
        JButton translateToEnglishButton = new JButton("Translate to English");
        JButton translateToSMSButton = new JButton("Translate to SMS");
        JTextArea outputTextArea = new JTextArea(10, 20);
        outputTextArea.setEditable(false);

        translateToEnglishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputTextArea.getText().toLowerCase();
                String[] words = input.split("\\s+");
                StringBuilder output = new StringBuilder();
                for (String word : words) {
                    if (smsToEnglish.containsKey(word)) {
                        output.append(smsToEnglish.get(word)).append(" ");
                    } else {
                        output.append(word).append(" ");
                    }
                }
                outputTextArea.setText(output.toString().trim());
            }
        });

        translateToSMSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputTextArea.getText().toLowerCase();
                String[] words = input.split("\\s+");
                StringBuilder output = new StringBuilder();
                for (String word : words) {
                    if (englishToSMS.containsKey(word)) {
                        output.append(englishToSMS.get(word)).append(" ");
                    } else {
                        output.append(word).append(" ");
                    }
                }
                outputTextArea.setText(output.toString().trim());
            }
        });

        frame.add(new JScrollPane(inputTextArea), BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(translateToEnglishButton);
        buttonPanel.add(translateToSMSButton);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(new JScrollPane(outputTextArea), BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
