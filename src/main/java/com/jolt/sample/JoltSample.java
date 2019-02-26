package com.jolt.sample;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;

import java.util.List;

import static java.lang.String.format;
import static java.lang.System.out;

public class JoltSample {

    public static void main(String[] args) {
        for (int i=1; i<=6; i++) {
            runSample(i);
        }
    }

    private static void runSample(int sampleNum) {
        List chainrSpecJSON = JsonUtils.classpathToList(format("/json/sample-%s/spec.json", sampleNum));
        Chainr chainr = Chainr.fromSpec( chainrSpecJSON );

        Object inputJSON = JsonUtils.classpathToObject(format("/json/sample-%s/input.json", sampleNum));

        Object transformedOutput = chainr.transform(inputJSON);
        out.println(JsonUtils.toJsonString(transformedOutput) + "\n");
    }

}