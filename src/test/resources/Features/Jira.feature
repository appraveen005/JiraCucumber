	Feature: Jira Api automation

Scenario Outline: verify user should create issue in Jira
Given User should add header "<key>", "<value>"
When User should add basic Auth "<username>", "<password>"
And User should add body
"""
{
    "fields": {
       "project":
       {
          "key": "JIR"
       },
       "summary": "RestAssured ",
       "description": "REST create issue using POST",
       "issuetype": {
          "name": "Bug"
       }
   }
} 
"""
And User should add "<methodType>" to send request "<endpoint>"
Then user should verify "<statusCode>"
And User should verify "key" contains "JIR"

Examples:
|key|value|username|password|methodType|endpoint|statusCode|
|Content-Type|application/json|appraveen005@gmail.com|pl8LNoik58l1u9Hier3N2BE2|POST|https://appraveen005.atlassian.net/rest/api/2/issue/|201|


Scenario Outline: verify user should modify issue in Jira
Given User should add header "<key>", "<value>" for modify
When User should add basic Auth "<username>", "<password>" for modify
And User should add body for modify
"""
{
    "fields": {
       "project":
       {
          "key": "JIR"
       },
       "summary": "Mod created issue",
       "description": "issue REST API",
       "issuetype": {
          "name": "Bug"
       }
   }
}
""" 
And User should add "<methodType>" to send request "<endpoint>" for modify
Then user should verify "<statusCode>" for modify

Examples:
|key|value|username|password|methodType|endpoint|statusCode|
|Content-Type|application/json|appraveen005@gmail.com|pl8LNoik58l1u9Hier3N2BE2|PUT|https://appraveen005.atlassian.net/rest/api/2/issue/|204|

Scenario Outline: verify user should delete created issue in Jira
Given User should add header "<key>", "<value>" for delete
When User should add basic Auth "<username>", "<password>" for delete
And User should add "<methodType>" to send request "<endpoint>" for delete
Then user should verify "<statusCode>" for delete

Examples:
|key|value|username|password|methodType|endpoint|statusCode|
|Content-Type|application/json|appraveen005@gmail.com|pl8LNoik58l1u9Hier3N2BE2|DELETE|https://appraveen005.atlassian.net/rest/api/3/issue/|204|


Scenario Outline: verify user should get issue in Jira
Given User should add header "<key>", "<value>" for get
When User should add basic Auth "<username>", "<password>" for get
And User should add "<methodType>" to send request "<endpoint>" for get
Then user should verify "<statusCode>" for get

Examples:
|key|value|username|password|methodType|endpoint|statusCode|
|Content-Type|application/json|appraveen005@gmail.com|pl8LNoik58l1u9Hier3N2BE2|GET|https://appraveen005.atlassian.net/rest/api/2/search/|200|
