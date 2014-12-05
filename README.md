simple-test
===========

for the camel-users forum - simple(?!) behavior...!

  <from uri="timer://foo?period=1000&amp;repeatCount=1" />
        <process ref="populateMap" />
        <log message="SIMPLE SPRING: INSERT INTO SOMETHING (${bean:myeval?method=eval(${body[VALUE_ONE]})},${bean:myeval?method=eval(${body[VALUE_TWO]})})" />
        <process ref="simpleExpProcessor"/>
        <log message="${body}" />
        <log message="EXPECTED: INSERT INTO SOMETHING ('value','Thing (with brackets)')" />
        
The populateMap bean creates a map as follows: 

  LinkedHashMap<String,Object> map = new LinkedHashMap<String, Object>(); 
  map.put("VALUE_ONE", "'value'"); 
  map.put("VALUE_TWO", "'Thing (with brackets)'"); 

The log output is: 

  [pache.camel.spring.Main.main()] SpringCamelContext             INFO  Apache Camel 2.13.3 (CamelContext: camel-1) started in 0.282 seconds 
  [mel-1) thread #0 - timer://foo] MyEvaluator                    DEBUG evaluated : value 
  [mel-1) thread #0 - timer://foo] MyEvaluator                    DEBUG evaluated : 'Thing (with brackets 
  [mel-1) thread #0 - timer://foo] route1                         INFO  SIMPLE SPRING: INSERT INTO SOMETHING (value,'Thing (with brackets) 
  [mel-1) thread #0 - timer://foo] SimpleExpressionProcessor      DEBUG INSERT INTO SOMETHING (${bean:myeval?method=eval(${body[VALUE_ONE]})},${bean:myeval?method=eval(${body[VALUE_TWO]})}) 
  [mel-1) thread #0 - timer://foo] MyEvaluator                    DEBUG evaluated : value 
  [mel-1) thread #0 - timer://foo] MyEvaluator                    DEBUG evaluated : 'Thing (with brackets 
  [mel-1) thread #0 - timer://foo] route1                         INFO  INSERT INTO SOMETHING (value,'Thing (with brackets) 
  [mel-1) thread #0 - timer://foo] route1                         INFO  EXPECTED: INSERT INTO SOMETHING ('value','Thing (with brackets)') 
