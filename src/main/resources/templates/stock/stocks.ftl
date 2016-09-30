<#import "../layouts/main.ftl" as u>

<@u.page>

<#-- Show a lookup fiel, so users can find stocks -->
<#include "_lookup.ftl" />

<#-- Show the list of stocks the user is currently following -->
<#include "_list.ftl"/>

</@u.page>
