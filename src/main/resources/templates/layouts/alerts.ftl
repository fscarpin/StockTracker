<#if warning??>
  <div class="alert alert-warning" role="alert">
    ${warning}
  </div>
<#elseif error??>
  <div class="alert alert-danger" role="alert">
    ${error}
  </div>
<#elseif success??>
  <div class="alert alert-success" role="alert">
    ${success}
  </div>
<#elseif info??>
  <div class="alert alert-info" role="alert">
    ${info}
  </div>
</#if>