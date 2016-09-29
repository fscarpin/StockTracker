<table class="table table-striped">

  <thead>
    <tr>
      <th>Name</th>
      <th>Symbol</th>
      <th>Current Price</th>

      <#-- Only show the actions if the user is connected -->
      <#if account??>
        <th>Actions</th>
      </#if>
    </tr>
  </thead>

  <tbody>
    <#list userStocks as userStock>
      <tr>
        <td> ${userStock.name} </td>
        <td> ${userStock.ticker} </td>
        <td> ${userStock.lastPrice} </td>

        <#if account??>
          <td>
            <form name="stock" action="deleteStock" method="post">
              <input type="hidden" name="stockId" value="${userStock.id}"
              <input type="submit" value="Remove Stock" class="btn btn-danger">
            </form>
          </td>
        </#if>
      </tr>
    </#list>
  </tbody>

</table>