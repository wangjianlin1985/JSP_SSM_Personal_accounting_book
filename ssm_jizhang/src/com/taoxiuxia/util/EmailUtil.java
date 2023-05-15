// 
// 
// 

package com.taoxiuxia.util;

import java.util.Hashtable;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeUtility;
import javax.activation.DataSource;
import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.internet.MimeBodyPart;
import java.util.Iterator;
import javax.mail.internet.MimeMultipart;
import javax.mail.Authenticator;
import java.util.LinkedList;
import javax.activation.FileDataSource;
import java.util.List;
import javax.mail.Multipart;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

public class EmailUtil
{
    private static String defaultSenderName;
    private static String defaultSenderPass;
    private static String defaultSmtpHost;
    private static String smtpHost;
    private static String sendUserName;
    private static String sendUserPass;
    private static MimeMessage mimeMsg;
    private static Session session;
    private static Properties props;
    private static Multipart mp;
    private static List<FileDataSource> files;
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    
    static {
        EmailUtil.defaultSenderName = "";
        EmailUtil.defaultSenderPass = "";
        EmailUtil.defaultSmtpHost = "";
        EmailUtil.files = new LinkedList<FileDataSource>();
    }
    
    public static String sendEmail(final String emailTo) {
        final String userName = "yuanmamatouemail@163.com";
        final String password = "yuanmamatou1234";
        final String smtpHost = "smtp.163.com";
        final String subject = "\u5929\u5929\u8bb0\u8d26\u672c\u6fc0\u6d3b\u7801";
        final String activationCode = activationCode();
        final String body = "\u60a8\u6b63\u5728\u6ce8\u518c\u5929\u5929\u8bb0\u8d26\u672c<br>\u8fd9\u662f\u60a8\u7684\u6fc0\u6d3b\u7801\uff0c3\u5c0f\u65f6\u5185\u6709\u6548<br><b>" + activationCode + "</b>";
        final EmailUtil email = entity(smtpHost, userName, password, emailTo, subject, body);
        try {
            email.send();
        }
        catch (Exception ex) {}
        return activationCode;
    }
    
    private void init() {
        if (EmailUtil.props == null) {
            EmailUtil.props = System.getProperties();
        }
        EmailUtil.session = Session.getDefaultInstance(EmailUtil.props, (Authenticator)null);
        EmailUtil.props.setProperty("mail.smtp.host", EmailUtil.smtpHost);
        EmailUtil.props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        EmailUtil.props.setProperty("mail.smtp.socketFactory.fallback", "false");
        EmailUtil.props.setProperty("mail.smtp.port", "465");
        EmailUtil.props.setProperty("mail.smtp.socketFactory.port", "465");
        ((Hashtable<String, String>)EmailUtil.props).put("mail.smtp.auth", "true");
        EmailUtil.session.setDebug(true);
        EmailUtil.mimeMsg = new MimeMessage(EmailUtil.session);
        EmailUtil.mp = (Multipart)new MimeMultipart();
    }
    
    private EmailUtil(final String smtpHost, final String sendUserName, final String sendUserPass, final String to, final String mailSubject, final String mailBody) {
        EmailUtil.smtpHost = smtpHost;
        EmailUtil.sendUserName = sendUserName;
        EmailUtil.sendUserPass = sendUserPass;
        this.init();
        this.setFrom(sendUserName);
        this.setTo(to);
        this.setBody(mailBody);
        this.setSubject(mailSubject);
    }
    
    private EmailUtil(final String smtpHost, final String sendUserName, final String sendUserPass, final String to, final String cc, final String mailSubject, final String mailBody, final List<String> attachments) {
        EmailUtil.smtpHost = smtpHost;
        EmailUtil.sendUserName = sendUserName;
        EmailUtil.sendUserPass = sendUserPass;
        this.init();
        this.setFrom(sendUserName);
        this.setTo(to);
        this.setCC(cc);
        this.setBody(mailBody);
        this.setSubject(mailSubject);
        if (attachments != null) {
            for (final String attachment : attachments) {
                this.addFileAffix(attachment);
            }
        }
    }
    
    public static EmailUtil entity(final String smtpHost, final String sendUserName, final String sendUserPass, final String to, final String cc, final String mailSubject, final String mailBody, final List<String> attachments) {
        return new EmailUtil(smtpHost, sendUserName, sendUserPass, to, cc, mailSubject, mailBody, attachments);
    }
    
    public static EmailUtil entity(final String smtpHost, final String sendUserName, final String sendUserPass, final String to, final String mailSubject, final String mailBody) {
        return new EmailUtil(smtpHost, sendUserName, sendUserPass, to, mailSubject, mailBody);
    }
    
    public static EmailUtil defaultEntity(final String to, final String cc, final String subject, final String body, final List<String> attachments) {
        return new EmailUtil(EmailUtil.defaultSmtpHost, EmailUtil.defaultSenderName, EmailUtil.defaultSenderPass, to, cc, subject, body, attachments);
    }
    
    private boolean setSubject(final String mailSubject) {
        try {
            EmailUtil.mimeMsg.setSubject(mailSubject);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    
    private boolean setBody(final String mailBody) {
        try {
            final BodyPart bp = (BodyPart)new MimeBodyPart();
            bp.setContent((Object)("<meta http-equiv=Content-Type content=text/html; charset=UTF-8>" + mailBody), "text/html;charset=UTF-8");
            EmailUtil.mp.addBodyPart(bp);
        }
        catch (Exception e) {
            System.err.println("\u8bbe\u7f6e\u90ae\u4ef6\u6b63\u6587\u65f6\u53d1\u751f\u9519\u8bef\uff01" + e);
            return false;
        }
        return true;
    }
    
    public boolean addFileAffix(final String filename) {
        try {
            if (filename != null && filename.length() > 0) {
                final BodyPart bp = (BodyPart)new MimeBodyPart();
                final FileDataSource fileds = new FileDataSource(filename);
                bp.setDataHandler(new DataHandler(fileds));
                bp.setFileName(MimeUtility.encodeText(fileds.getName(), "utf-8", (String)null));
                EmailUtil.mp.addBodyPart(bp);
                EmailUtil.files.add(fileds);
            }
        }
        catch (Exception e) {
            System.err.println("\u589e\u52a0\u90ae\u4ef6\u9644\u4ef6\uff1a" + filename + "\u53d1\u751f\u9519\u8bef\uff01" + e);
            return false;
        }
        return true;
    }
    
    public boolean delFileAffix() {
        try {
            FileDataSource fileds = null;
            final Iterator<FileDataSource> it = EmailUtil.files.iterator();
            while (it.hasNext()) {
                fileds = it.next();
                if (fileds != null && fileds.getFile() != null) {
                    fileds.getFile().delete();
                }
            }
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    
    private boolean setFrom(final String from) {
        try {
            EmailUtil.mimeMsg.setFrom((Address)new InternetAddress(from));
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    
    private boolean setTo(final String to) {
        if (to == null) {
            return false;
        }
        try {
            EmailUtil.mimeMsg.setRecipients(Message.RecipientType.TO, (Address[])InternetAddress.parse(to));
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    
    private boolean setCC(final String cc) {
        if (cc == null) {
            return false;
        }
        try {
            EmailUtil.mimeMsg.setRecipients(Message.RecipientType.CC, (Address[])InternetAddress.parse(cc));
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean send() throws Exception {
        EmailUtil.mimeMsg.setContent(EmailUtil.mp);
        EmailUtil.mimeMsg.saveChanges();
        System.out.println("\u6b63\u5728\u53d1\u9001\u90ae\u4ef6....");
        final Transport transport = EmailUtil.session.getTransport("smtp");
        transport.connect(EmailUtil.smtpHost, EmailUtil.sendUserName, EmailUtil.sendUserPass);
        transport.sendMessage((Message)EmailUtil.mimeMsg, EmailUtil.mimeMsg.getRecipients(Message.RecipientType.TO));
        System.out.println("\u53d1\u9001\u90ae\u4ef6\u6210\u529f\uff01");
        transport.close();
        return true;
    }
    
    public static String activationCode() {
        return new StringBuilder(String.valueOf((int)((Math.random() * 9.0 + 1.0) * 100000.0))).toString();
    }
}
