package com.hhly.lottomsg.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.hhly.lottomsg.common.constants.SymbolConstants;
import com.hhly.lottomsg.vo.BodyPartVO;

/**
 * 
 * @Description 邮箱发送工具类
 * @author syb
 * @Date 2017年3月8日 下午5:07:57
 * @version 1.0.0
 */
public class MailUtil {

	Logger logger = LoggerFactory.getLogger(MailUtil.class);

	private Properties javaMailProperties = new Properties();

	private Session session;

	public boolean sendMail(final String content, final String subject, final String from, final String to) {
		return sendMail(content, subject, from, to, null);
	}

	public boolean sendMail(final String content, final String subject, final String from, final String to, final String filePath) {
		String[] toArr = to.split(SymbolConstants.COMMA);
		String[] filePathArr = ObjectUtil.isBlank(filePath) ? null : new String[] { filePath };
		return sendMail(content, subject, from, toArr, filePathArr);
	}

	public boolean sendMail(final String content, final String subject, final String from, final String[] toArr,
			final String[] filePathArr) {
		Transport ts = null;
		try {
			ts = getSession().getTransport();
			ts.connect();
			MimeMessage message = new MimeMessage(session);
			String from_ = "";// 邮件来源
			try {
				from_ = MimeUtility.encodeText(from);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			message.setFrom(new InternetAddress(from_ + " <" + "yc@2ncai.com" + ">"));
			for (String to : toArr) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			}
			message.setSubject(subject);
			Multipart mp = new MimeMultipart();
			// 正文
			if (!ObjectUtil.isBlank(content)) {
				MimeBodyPart contentBodyPart = new MimeBodyPart();
				contentBodyPart.setContent(content.toString(), "text/html;charset=UTF-8");
				mp.addBodyPart(contentBodyPart);
			}
			// 附件
			if (!ObjectUtil.isBlank(filePathArr)) {
				for (String filePath : filePathArr) {
					BodyPart fileBodyPart = new MimeBodyPart();
					DataSource source = new FileDataSource(filePath);
					fileBodyPart.setDataHandler(new DataHandler(source));
					fileBodyPart.setFileName(source.getName());
					mp.addBodyPart(fileBodyPart);
				}
			}
			message.setContent(mp);
			ts.sendMessage(message, message.getAllRecipients());
			ts.close();
			logger.info(">>用户在" + DateUtil.convertDateToStr(new Date()) + "发送邮件到" + Arrays.toString(toArr) + "成功!");
			return true;
		} catch (MessagingException e) {
			logger.error("发送邮件失败:");
			e.printStackTrace();
		} finally {
			try {
				if (ts != null) {
					ts.close();
				}
			} catch (MessagingException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean sendMail(final String content, final String subject, final String from, final String[] toArr,
			final List<BodyPartVO> fileBodyPartList) {
		Transport ts = null;
		try {
			ts = getSession().getTransport();
			ts.connect();
			MimeMessage message = new MimeMessage(session);
			String from_ = "";// 邮件来源
			try {
				from_ = MimeUtility.encodeText(from);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			message.setFrom(new InternetAddress(from_ + " <" + "yc@2ncai.com" + ">"));
			for (String to : toArr) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			}
			message.setSubject(subject);
			Multipart mp = new MimeMultipart();
			// 正文
			if (!ObjectUtil.isBlank(content)) {
				MimeBodyPart contentBodyPart = new MimeBodyPart();
				contentBodyPart.setContent(content.toString(), "text/html;charset=UTF-8");
				mp.addBodyPart(contentBodyPart);
			}
			// 附件
			if (!ObjectUtil.isBlank(fileBodyPartList)) {
				for (BodyPartVO fileInfo : fileBodyPartList) {
					BodyPart fileBodyPart = new MimeBodyPart();
					DataSource source = new ByteArrayDataSource(fileInfo.getIs(),fileInfo.getMimeType());
					fileBodyPart.setDataHandler(new DataHandler(source));
					fileBodyPart.setFileName(fileInfo.getFileName());
					mp.addBodyPart(fileBodyPart);
				}
			}
			message.setContent(mp);
			ts.sendMessage(message, message.getAllRecipients());
			ts.close();
			logger.info(">>用户在" + DateUtil.convertDateToStr(new Date()) + "发送邮件到" + Arrays.toString(toArr) + "成功!");
			return true;
		} catch (MessagingException e) {
			logger.error("发送邮件失败:");
			e.printStackTrace();
		}
		finally {
			try {
				if (ts != null) {
					ts.close();
				}
			} catch (MessagingException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

	public Properties getJavaMailProperties() throws FileNotFoundException, IOException {
		return javaMailProperties;
	}

	public void setJavaMailProperties(Properties javaMailProperties) throws FileNotFoundException, IOException {
		this.javaMailProperties = javaMailProperties;
		synchronized (this) {
			this.session = null;
		}
	}

	public Session getSession() {
		javaMailProperties.setProperty("mail.smtp.auth", "true");
		javaMailProperties.setProperty("mail.smtp.user", "yc");
		javaMailProperties.setProperty("mail.smtp.host", "mail.2ncai.com");
		javaMailProperties.setProperty("mail.transport.protocol", "smtp");
		javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
		javaMailProperties.setProperty("mail.smtp.ssl.trust", "mail.2ncai.com");
		javaMailProperties.setProperty("mail.smtp.localhost", "mail.2ncai.com");
		javaMailProperties.setProperty("mail.smtp.port", "587");
		if (this.session == null) {
			Authenticator auth = new SMTPAuthenticator();
			this.session = Session.getInstance(javaMailProperties, auth);
			this.session.setDebug(false);
		}
		return this.session;
	}

	public void setSession(Session session) {
		Assert.notNull(session, "Session must not be null");
		this.session = session;
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("yc", "YCwl2017");
		}
	}
}
