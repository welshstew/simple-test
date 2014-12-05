package org.swinchester;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.Processor;
import org.apache.camel.spi.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by swinchester on 5/12/14.
 */
public class SimpleExpressionProcessor implements Processor {

    Logger log = LoggerFactory.getLogger(SimpleExpressionProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {

        String simpleInsert = (String) exchange.getIn().getHeader("simpleInsert");
        Language language = exchange.getContext().resolveLanguage("simple");
        Expression expression =
                language.createExpression(simpleInsert);

        log.debug(simpleInsert);

        String value = expression.evaluate(exchange, String.class);

        exchange.getIn().setBody(value);
    }
}
