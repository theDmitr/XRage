package org.cheesecake.xrage.auth.rights;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresRights {
    Rights[] value();
}
