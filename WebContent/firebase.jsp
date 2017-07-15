<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Firebase</title>
    
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
             <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
 
        <style type="text/css">
            body{
            }
            div.container{
                width: 1000px;
                margin: 0 auto;
                position: relative;
            }
            legend{
                font-size: 30px;
                color: #555;
            }
            .btn_send{
                background: #00bcd4;
            }
            label{
                margin:10px 0px !important;
            }
            textarea{
                resize: none !important;
            }
            .fl_window{
                width: 400px;
                position: absolute;
                right: 0;
                top:100px;
            }
            pre, code {
                padding:10px 0px;
                box-sizing:border-box;
                -moz-box-sizing:border-box;
                webkit-box-sizing:border-box;
                display:block; 
                white-space: pre-wrap;  
                white-space: -moz-pre-wrap; 
                white-space: -pre-wrap; 
                white-space: -o-pre-wrap; 
                word-wrap: break-word; 
                width:100%; overflow-x:auto;
            }
            </style>
</head>
<body>
		  <div class="container">
          
 
            <form class="pure-form pure-form-stacked" method="post" action="/FcmNotif/SendFirebaseNotifServlet">
                <fieldset>
                    <legend>Send to Single Device</legend>
 
                    <label for="redId">Firebase Reg Email</label>
                    <input type="text" id="redId" name="regId" class="pure-input-1-2" placeholder="Enter firebase registration email-id">
 
                    <label for="title">Title</label>
                    <input type="text" id="title" name="title" class="pure-input-1-2" placeholder="Enter title">
 
                    <label for="message">Message</label>
                    <textarea class="pure-input-1-2" rows="5" name="message" placeholder="Notification message"></textarea>
   
                    <label for="image">Image URL</label>
                    <input type="text" id="image" name="image" class="pure-input-1-2" placeholder="Enter Image URL">
 
                    <input type="hidden" name="push_type" value="individual"/>
                    <button type="submit" class="pure-button pure-button-primary btn_send">Send</button>
                </fieldset>
            </form>
            <br/><br/><br/><br/>
 
            <form class="pure-form pure-form-stacked" method="post" action="/FcmNotif/SendFirebaseNotifServlet">
                <fieldset>
                    <legend>Send to All Device</legend>
                     <label for="title">Title</label>
                    <input type="text" id="title" name="title" class="pure-input-1-2" placeholder="Enter title">
 
                    <label for="message">Message</label>
                    <textarea class="pure-input-1-2" rows="5" name="message" placeholder="Notification message"></textarea>
 
                     <label for="image">Image URL</label>
                    <input type="text" id="image" name="image" class="pure-input-1-2" placeholder="Enter Image URL">
 
                    <input type="hidden" name="push_type" value="all"/>
                    <button type="submit" class="pure-button pure-button-primary btn_send">Send to All</button>
                </fieldset>
            </form>
</div>
</body>
</html>