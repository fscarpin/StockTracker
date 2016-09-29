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
            <a data-confirm="Are you sure you want to remove ${userStock.name} from your portfolio?"
               class="btn btn-danger btn-sm" rel="nofollow" data-method="post" href="/deleteStock?stockId=${userStock.id}">
              Delete
            </a>
          </td>
        </#if>
      </tr>
    </#list>
  </tbody>

</table>