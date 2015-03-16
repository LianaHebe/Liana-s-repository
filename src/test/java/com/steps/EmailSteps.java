package com.steps;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;

import com.sun.mail.imap.IMAPFolder;

public class EmailSteps extends ScenarioSteps {

	@Step
	public void checkLastEmailSubjectAndBody(String expectedSubject,
			String expectedBody) throws MessagingException, IOException {
		IMAPFolder folder = null;
		Store store = null;
		String subject = null;
		String body = null;
		try {
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");

			Session session = Session.getDefaultInstance(props, null);

			store = session.getStore("imaps");
			store.connect("mail.evozon.com", "liana.hebe@evozon.com",
					"Training-1");

			folder = (IMAPFolder) store.getFolder("Inbox");

			if (!folder.isOpen())
				folder.open(Folder.READ_WRITE);
			Message msg = folder.getMessage(folder.getMessageCount());

			subject = msg.getSubject();
			body = msg.getContent().toString();

			System.out.println("Subject: " + subject);
			System.out.println("From: " + msg.getFrom()[0]);
			System.out.println("To: " + msg.getAllRecipients()[0]);
			System.out.println("Date: " + msg.getReceivedDate());
			System.out.println("Size: " + msg.getSize());
			System.out.println(msg.getFlags());
			System.out.println("Body: \n" + body);
			System.out.println(msg.getContentType());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (folder != null && folder.isOpen()) {
				folder.close(true);
			}
			if (store != null) {
				store.close();
			}
		}

		Assert.assertTrue(subject.contains(expectedSubject));
		Assert.assertTrue(body.contains(expectedBody));

	}

}
