<#import "layouts/main.ftl" as u>

<@u.page>

<h2>About Me</h2>
<div class="row">
  <div class="col-md-12">
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec nisl libero, molestie vitae orci nec, luctus feugiat lorem. Maecenas eu massa non neque blandit tempor. Interdum et malesuada fames ac ante ipsum primis in faucibus. Suspendisse id consectetur enim, et cursus nisl. Ut volutpat tempor accumsan. Aliquam et libero id nunc consectetur consequat at eu nibh. Nam ut justo in sapien fermentum facilisis.</p>
    <p>Nullam sodales neque fringilla molestie facilisis. Morbi nisl neque, malesuada convallis felis vitae, pharetra maximus lorem. Fusce tincidunt sapien pretium leo scelerisque, eget egestas nisi dapibus. Sed ut magna egestas, condimentum ex vel, tempor justo. Duis ut magna et orci tincidunt vestibulum. Suspendisse sed enim nec mi convallis aliquam. Sed id urna ultricies dolor dictum vulputate. Nulla porta auctor sagittis.</p>
  </div>
</div>

<article>
  <header>
    <h2> ${latestPost.title} </h2>
    <p> ${latestPost.postedOn} </p>
  </header>
  <section>
    ${latestPost.teaser}
  </section>
  <footer>
    <a href="/post/show/${latestPost.slug}">Read More</a>
    <address>
      Posted By ${latestPost.author.firstName} ${latestPost.author.lastName}
    </address>
  </footer>
</article>

</@u.page>
