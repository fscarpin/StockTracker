<#import "layouts/main.ftl" as u>

<head>
  <title> All Posts </title>
</head>

<@u.page>

<div class="container-fluid">
  <div class="row">
    <div class="box col-md-6 col-md-offset-3">
      <div class="stormpath-header">
        <img src="http://stormpath.com/images/template/logo-nav.png"/>
      </div>

      <h1> Hello ${account.fullName} </h1>
      <a href="/logout" class="btn btn-danger"> Logout </a>
    </div>
  </div>
</div>

</@u.page>