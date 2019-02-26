package com.jolt.sample.transform;

import com.bazaarvoice.jolt.Transform;

import java.util.Map;

import static java.lang.System.getProperty;

public class JoltUserAgentTransform implements Transform {

    @Override
    public Object transform(Object input) {
        String userAgent = ((Map) input).get("user_agent").toString();

        // Overwrite the old value with the new one.
        ((Map) input).put("user_agent", String.format("%s:%s", userAgent.toLowerCase(), getProperty("os.name").toLowerCase()));

        return input;
    }
}
