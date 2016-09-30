<#-- Shows a message if the user is not tracking any stock -->
<#if userStocks?size <= 0 >

  <div class="alert alert-info" role="alert">
    You are not tracking any stock. Add some now!
  </div>

<#else >
<#-- Show the users'stock(s) -->
  <table class="table table-striped">

    <thead>
      <tr>
        <th> Name </th>
        <th> Symbol </th>
        <th> Currency </th>
        <th> Previous Closed Price </th>
        <th> Current Price </th>
        <th> Percentage </th>

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
          <td> ${userStock.currency} </td>
          <td> ${userStock.yesterdayClosePrice} </td>
          <td> ${userStock.lastPrice} </td>
          <th> ${userStock.percentage} </th>

          <#if account??>
            <td>
              <a data-confirm="Are you sure you want to remove ${userStock.name} from your portfolio?"
                 class="btn btn-danger btn-sm" rel="nofollow" data-method="delete" href="/deleteStock?stockId=${userStock.id}">
                Delete
              </a>
            </td>
          </#if>
        </tr>
      </#list>
    </tbody>

  </table>

</#if>