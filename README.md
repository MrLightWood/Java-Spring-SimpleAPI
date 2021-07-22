Simple API running on Java using Spring Framework

Examples:
<ul>
    <li>Request: http://localhost:8080/calculator/calculate1?input=1,2,3,4,5,6,7,8,9,0</li>
    <li>Response: {"sumOfEvenResult":20,"maxOddResult":9,"oddsResult":[1,3,5,7,9]}</li>
    <br><br>
    <li>Request: http://localhost:8080/calculator/calculate2?input=1,2,3,4,5,6,7,8,9,0</li>
    <li>Response: {"sumOfEvenResult":20,"powerOf4Result":[1,16,81,256,625,1296,2401,4096,6561,0],"averageOfNegativesResult":0.0}</li>
    <br><br>
    <li>Request: http://localhost:8080/calculator/calculate1?input=a,b</li>
    <li>Response: Provided arguments are invalid </li>
    <br><br>
    <li>Request: http://localhost:8080/calculator/calculate2?input=a,b</li>
    <li>Response: Provided arguments are invalid </li>
</ul>

<br><br><br>