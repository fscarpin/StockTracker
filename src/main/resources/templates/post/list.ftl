<#import "../layouts/main.ftl" as u>

<head>
  <title> All Posts </title>
</head>

<@u.page>
  <#list posts as post>
    <article>
      <header>
        <h2> ${post.title} </h2>
        <p> Posted on ${post.postedOn} </p>
      </header>
      <section th:utext="${post.teaser}">
        teaser
      </section>
      <footer>
        <a href="/post/show/${post.slug}">Read More</a>
        <address>
          Posted By ${post.author.firstName} ${post.author.lastName}
        </address>
      </footer>
    </article>
  </#list>
</@u.page>

