import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import java.util.*;
import javax.tools.Diagnostic.Kind;

/** Check that a class marked {@code @Utility} is indeed a utility class. */
@SupportedAnnotationTypes("Utility")
@SupportedSourceVersion(SourceVersion.RELEASE_11)
public class UtilityProcessor extends AbstractProcessor {

	@Override
	public boolean process(
			Set<? extends TypeElement> annotations,
			RoundEnvironment roundingEnvironment)
	{
		Messager messager = processingEnv.getMessager();
		messager.printMessage(Kind.NOTE,
				"UtilityProcessor executed.");
		messager.printMessage(Kind.WARNING,
				"The provided UtilityProcessor class is wrong.  Correct it!");

		for (TypeElement te : annotations) {
			for (Element elt : roundingEnvironment.getElementsAnnotatedWith(te)) {
				if (elt.getKind().isClass()) {	// elt is a class
					// Check that the class is declared final
					boolean isFinal = (elt.getModifiers()).contains(Modifier.FINAL);
					if (!isFinal) {
						messager.printMessage(Kind.ERROR,
							"@Utility applies to final class only:", elt);
					}else{
						// Check that enclosed elements are static
						List<? extends Element> elementsClasse = elt.getEnclosedElements();
						for (Element e : elementsClasse){
							if ((e.getKind() != ElementKind.CONSTRUCTOR) && (!(e.getModifiers().contains(Modifier.STATIC)))){
								messager.printMessage(Kind.ERROR,
								"@Utility applies to class with static methods only:", e);
							}
						}

					}
					
				} else {
					messager.printMessage(Kind.ERROR,
							"@Utility applies to class only:", elt);
				}
			}
		}
		return true;
	}

}
