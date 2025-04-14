# Java Send Mail

A lightweight Java utility for sending emails via Gmail SMTP using JavaMail API.

## Features

- Send emails via Gmail SMTP (TLS on port 587)
- Simple API — pass recipient, subject, and body
- Works headless — no GUI required
- Suitable for automated alerts and notifications

## Requirements

- JDK 8+
- `javax.mail.jar` (JavaMail API)

Download: https://javaee.github.io/javamail/

## Usage

```java
GmailSMTP mailer = new GmailSMTP("your@gmail.com", "app-password");
mailer.send("recipient@example.com", "Subject", "Email body here");
```

> Use a Gmail App Password (not your main password):
> Google Account → Security → 2-Step Verification → App Passwords

## Compile and Run

```bash
javac -cp javax.mail.jar src/GmailSMTP.java -d out/
java -cp javax.mail.jar:out/ GmailSMTP
```
Current stable: v1.1.0
