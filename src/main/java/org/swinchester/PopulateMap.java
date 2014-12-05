package org.swinchester;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.LinkedHashMap;

/**
 * Created by swinchester on 5/12/14.
 */
public class PopulateMap implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        String simpleExpression = "INSERT INTO SOMETHING (";
        simpleExpression+= "${bean:myeval?method=eval(${body[VALUE_ONE]})}" + ",";
        simpleExpression+= "${bean:myeval?method=eval(${body[VALUE_TWO]})}" + ")";

        LinkedHashMap<String,Object> map = new LinkedHashMap<String, Object>();
        map.put("VALUE_ONE", "'value'");
        map.put("VALUE_TWO", "'Thing (with brackets)'");

        exchange.getIn().setHeader("simpleInsert", simpleExpression);
        exchange.getIn().setBody(map);

    }
}
