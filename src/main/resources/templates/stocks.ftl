<#import "layouts/main.ftl" as u>

<@u.page>

<div id="stock-lookup">
  <h3> Search for stocks </h3>

  <form name="stock" action="findStock" method="get">
    <div class="form-group">
      <div class='row'>
        <div class='col-xs-9'>
          <input type="text" name="stock" id="stock" placeholder="Stock ticker symbol" autofocus="autofocus"
                 class="form-control search-box input-lg" />
        </div>
        <div class='col-xs-3'>
          <!-- btn-block: spans the full width of a parent (fills the column on this case) -->
          <button name="button" type="submit" class="btn btn-lg btn-success btn-block">
                  <#--data-disable-with="&lt;i class=&#39;fa fa-spinner fa-spin&#39;&gt;&lt;/i&gt; Searching...">-->
            <i class='fa fa-search'></i> <span class="hidden-sm hidden-xs"> Search Stock </span>
          </button>
        </div>
      </div>
    </div>
  </form>
</div>

<#if stock??>
  Here' your stock: ${stock.name} ${stock.symbol} ${stock.price}
</#if>

</@u.page>
