package com.jason.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class sendfile {

    public static void main(String[] args) {
        if (args.length != 5) {
            System.out.println("usage: java sendfile <to> <from> <smtp> <file> true|false");
            System.exit(1);
        }

        String to = args[0];
        String from = args[1];
        String host = args[2];
        String filename = args[3];
        boolean debug = Boolean.valueOf(args[4]).booleanValue();
        String msgText1 = "Sending a file.\n";
        String subject = "Sending a file";

        // create some properties and get the default Session
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);

        Session session = Session.getInstance(properties, null);
        session.setDebug(debug);

        try {
            // create a message
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(from));
            InternetAddress[] addresses = {new InternetAddress(to)};
            mimeMessage.setRecipients(Message.RecipientType.TO, addresses);
            mimeMessage.setSubject(subject);

            // create and fill the first message part
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setText(msgText1);

            // create the second message part
            MimeBodyPart mimeBodyPart1 = new MimeBodyPart();

            // attach the file to the message
            mimeBodyPart1.attachFile(filename);

            /*
             * Use the following approach instead of the above line if
             * you want to control the MIME type of the attached file.
             * Normally you should never need to do this.
             *
            FileDataSource fds = new FileDataSource(filename) {
            public String getContentType() {
                return "application/octet-stream";
            }
            };
            mbp2.setDataHandler(new DataHandler(fds));
            mbp2.setFileName(fds.getName());
             */

            // create the Multipart and add its parts to it
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(mimeBodyPart1);

            // add the Multipart and add its parts to it
            mimeMessage.setContent(multipart);

            // set the Date: header
            mimeMessage.setSentDate(new Date());

            /*
             * If you want to control the Content-Transfer-Encoding
             * of the attached file, do the following.  Normally you
             * should never need to do this.
             *
            msg.saveChanges();
            mbp2.setHeader("Content-Transfer-Encoding", "base64");
             */

            // send the message
            Transport.send(mimeMessage);

        } catch (MessagingException mex) {
            mex.printStackTrace();
            Exception ex = null;
            if ((ex = mex.getNextException()) != null) {
                ex.printStackTrace();
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
}
