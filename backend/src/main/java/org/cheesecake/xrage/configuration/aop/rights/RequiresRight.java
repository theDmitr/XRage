package org.cheesecake.xrage.configuration.aop.rights;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresRight {
    Rights[] value();
}
