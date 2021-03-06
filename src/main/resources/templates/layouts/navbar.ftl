<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/"> Stock Tracker </a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="/">My Portfolio <span class="badge"> ${userStocks?size} </span> </a></li>
      </ul>

      <ul class="nav navbar-nav navbar-right">

        <#if account??>
          <li><a href="#">Signed in as ${account.fullName}</a></li>

          <li>
            <form class="button_to" action="/logout">
              <input class="btn btn-sm btn-primary navbar-btn" type="submit" value="Log out"/>
            </form>
          </li>
        <#else>
          <form class="button_to" action="/login">
            <input class="btn btn-sm btn-success navbar-btn" type="submit" value="Log in"/>
          </form>
        </#if>

      </ul>
    </div>
  </div>
</nav>