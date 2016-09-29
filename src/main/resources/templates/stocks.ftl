<#import "layouts/main.ftl" as u>

<@u.page>

<div id="stock-lookup">
  <h3> Search for stocks </h3>

  <#-- Form to find a stock by the symbol -->
  <form name="stock" action="findStock" method="get">
    <div class="form-group">
      <div class='row'>
        <div class='col-xs-9'>
          <input type="text" name="stockSymbol" placeholder="Stock ticker symbol" autofocus="autofocus"
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

<#-- Shows some stock information if it was found, and allow the user to add it -->
<#if stock??>

<div class="well well-lg">
  <strong> Symbol: </strong> ${stock.symbol}
  <strong> Name: </strong> ${stock.name}
  <strong> Currency: </strong> ${stock.currency}
  <strong> Price: </strong> ${stock.price}

  <#if stock_already_added??>
    <p class="medium-margin-top">
      <h4><span class="label label-danger"> You already added this stock </span></h4>
    </p>
  <#else >
    <form name="stock" action="addStock" method="get">
      <input type="hidden" name="stockSymbol" value= ${stock.symbol}>
      <input type="submit" value="Add Stock" class="btn btn-success medium-margin-top">
    </form>
  </#if>
</div>
</#if>

</@u.page>
