<#import "../layouts/main.ftl" as u>

<head>
  <title th:text="${post.title}"> Post Title </title>
</head>

<@u.page>
  <ol class="breadcrumb">
    <li><a href="/">Home</a></li>
    <li><a href="/post/list">Post</a></li>
    <li class="active"> ${post.title} </li>
  </ol>

  <article>
    <header>
      <h2> ${post.title} </h2>
      <p> Posted on ${post.postedOn} </p>
    </header>
    <section>
      ${post.body}
    </section>
    <footer>
      <address>
        Posted By ${post.author.firstName} ${post.author.lastName}
      </address>
    </footer>
  </article>
</@u.page>