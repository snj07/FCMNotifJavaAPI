# FCMNotifJavaAPI
Send Firebase (FCM) Notification to android devices using Java. JSP Example  ( Java API )

It sends Firebase Notification to android mobile. You need to pull FCMNotif android project for this, from my repository.
You have to place firebase API key in FirebaseConfig class and username & password in DbConnection class.
Then you can register device using android app(FCMNotif) first and then you can send notification to android device using firebase.jsp page.

You need to create a table in fcm database as
CREATE TABLE `devices` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `token` text NOT NULL
) ;
