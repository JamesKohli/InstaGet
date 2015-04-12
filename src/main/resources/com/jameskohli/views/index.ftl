<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Basic Page Needs
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <meta charset="utf-8">
    <title>Instaget! Download Instagram photos from your browser</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Mobile Specific Metas
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- FONT
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

    <!-- CSS
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/skeleton.css">

    <!-- Favicon
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <link rel="icon" type="image/png" href="images/favicon.png">

    <!-- Scripts
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>
      $(document).ready(function() {
        $( "#submitButton" ).click(function() {
          $( "#thinking" ).text("Thinking...");
          jQuery.get("gram", {shareUrl : $("#shareUrl").val() }, function( data ) {
            if (data.isValid) {
              $( "#instaimage" ).attr( "src", data.url );
              $( "#errorMessage").text("");
            } else {
              $( "#instaimage" ).removeAttr( "src" );
              $( "#errorMessage").text("Couldn't find an image! Your link might be invalid, or it could be from a private profile, which I unfortunately don't support yet.");
            }
            $( "#thinking" ).text("Thinking... Done!");
          }, "json" );
        });
      });
    </script>
    <script>
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

      ga('create', 'UA-51478818-3', 'auto');
      ga('send', 'pageview');

    </script>
</head>
<body>

<!-- Primary Page Layout
–––––––––––––––––––––––––––––––––––––––––––––––––– -->
<div class="container">
    <div class="row">
        <div class="one-half column" style="margin-top: 10%">
            <h3>Instaget</h3>
            <p>Instaget will pull photos from Instagram and display them so you can download them directly. Just copy and paste the url from the app (shown below) or your browser!</p>
            <img src="images/instructions.jpg" class="u-max-full-width" id="instructions">
			<label for="exampleMessage">Share URL</label>
			<textarea class="u-full-width" placeholder="https://instagram.com/p/sykBgGSGAF/" id="shareUrl"></textarea>
        </div>
    </div>
	<div class="row">
	    <div class="two columns">
	        <input class="button-primary" type="submit" value="Submit" id="submitButton">
	    </div>
	    <div class="three columns">
            <h5 id="thinking"></h5>
        </div>
	</div>
	<img class="u-max-full-width" id="instaimage">
	<div class="row">
        <div class="one-half column" style="margin-top: 5%">
            <h6 id="errorMessage"></h6>
            <p>If something seems to be working incorrectly, please log it <a href="https://github.com/JamesKohli/Instaget/issues">here!</a> Or just email me at james@jameskohli.com</p>
        </div>
    </div>
</div>

<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
