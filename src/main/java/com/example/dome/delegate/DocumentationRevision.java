package com.example.dome.delegate;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.impl.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocumentationRevision implements JavaDelegate {
//    protected static final String HOST = "mail-hog";
    protected static final String HOST = "localhost";
    protected static final int PORT = 1025;

    protected final static Logger LOGGER = LoggerFactory.getLogger(DocumentationRevision.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String assignee = (String) delegateExecution.getVariable("assignee");

        if (assignee != null) {

            IdentityService identityService = Context.getProcessEngineConfiguration().getIdentityService();
            User user = identityService.createUserQuery().userId(assignee).singleResult();

            if (user != null) {
                String sender = user.getEmail();

                if (sender != null && !sender.isEmpty()) {

                    Email email = new SimpleEmail();
                    email.setCharset("utf-8");
                    email.setHostName(HOST);
                    email.setSmtpPort(PORT);

                    try {
                        email.setFrom(sender);
                        email.setSubject("Documentation Revision Required");
                        email.setMsg("Dear CSP,\n\nPlease review the submitted documentation files for the revision process.\n\nBest regards,\nTeam");
                        email.addTo("csp@example.com");
                        email.send();
                        LOGGER.info("Email sent to user '{}'", assignee);

                    } catch (Exception e) {
                        LOGGER.info("Could not send email to assignee", e);
                    }

                } else {
                    LOGGER.info("Not sending email to user " + assignee + "', user has no email address.");
                }

            } else {
                LOGGER.info("Not sending email to user " + assignee + "', user is not enrolled with identity service.");
            }

        }

    }
}
