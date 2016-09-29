<#macro page>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Stock Tracker </title>

  <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" />
  <link rel="stylesheet" href="../../static/css/stock_tracker.css" />

  <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css' />
  <link href='https://fonts.googleapis.com/css?family=Exo' rel='stylesheet' type='text/css' />

  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>

<div class="container">

  <#include  "navbar.ftl">
  <#include "alerts.ftl">

  <#-- This processes the enclosed content:  -->
  <#nested>

  <footer>
    <p> Copyright FSM IT </p>
  </footer>

</div>

<script src="/webjars/jquery/3.1.0/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>
</#macro>