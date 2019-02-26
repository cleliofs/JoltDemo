package com.jolt.sample.transform;

import com.bazaarvoice.jolt.Transform;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static java.lang.Long.parseLong;
import static java.lang.System.out;

public class JoltTimeTransform implements Transform {

    @Override
    public Object transform(Object input) {

        String secondsString = ((Map) input).get("new_custom_time").toString();
        final long epochTime = parseLong(secondsString);

        out.println("epochTime = " + epochTime);

        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
        String formattedDate = formatter.format(new Date(epochTime));

        // Overwrite the old value with the new one.
        ((Map) input).put("new_custom_time", formattedDate);

        return input;
    }
}
