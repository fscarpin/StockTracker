<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/"> Stock Tracker </a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="/">My Portfolio</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
            Posts <span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li><a href="/post/list">List</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
            Authors <span class="caret"></span>
          </a>
          <ul class="dropdown-menu">

          </ul>
        </li>
      </ul>

      <ul class="nav navbar-nav navbar-right">

        <#if account??>
          <li><a href="#">Signed in as ${account.fullName}</a></li>

          <li>
            <form class="button_to" action="/logout">
              <input class="btn btn-sm btn-danger navbar-btn" type="submit" value="Log out"/>
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