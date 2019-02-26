package com.jolt.sample.transform;

import com.bazaarvoice.jolt.Transform;

import java.util.Map;

public class JoltClientIpTransform implements Transform {

    @Override
    public Object transform(Object input) {
        String clientIp = ((Map) input).get("client_ip").toString();

        // Overwrite the old value with the new one.
        ((Map) input).put("client_ip", "http://" + clientIp.replaceAll("\\.", "-"));

        return input;
    }
}
