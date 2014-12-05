package org.swinchester;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by swinchester on 5/12/14.
 */
public class MyEvaluator {

    Logger log = LoggerFactory.getLogger(MyEvaluator.class);

    public String eval(String input){
        log.debug("evaluated : " + input);
        return input;
    }
}
