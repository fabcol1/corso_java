package assertion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DaCompletare {
	String descrizione();
	String assegnataA() default "da assegnare";
}
