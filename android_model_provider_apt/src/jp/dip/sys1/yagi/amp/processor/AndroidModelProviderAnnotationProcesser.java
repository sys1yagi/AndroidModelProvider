package jp.dip.sys1.yagi.amp.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;

import jp.dip.sys1.yagi.amp.annotation.Attribute;
import jp.dip.sys1.yagi.amp.model.ModelObject;

@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes({ "jp.dip.sys1.yagi.amp.annotation.Model", "jp.dip.sys1.yagi.amp.annotation.Attribute", })
public class AndroidModelProviderAnnotationProcesser extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment environment) {
        for (Element element : environment.getRootElements()) {
            ModelVisitor visitor = new ModelVisitor();
            ModelObject modelObject = element.accept(visitor, null);

            for (Element child : element.getEnclosedElements()) {
                child.accept(visitor, modelObject);
            }
        }
        return false;
    }

    class ModelVisitor implements ElementVisitor<ModelObject, ModelObject> {
        @Override
        public ModelObject visitExecutable(ExecutableElement e, ModelObject p) {
            System.out.println("visitExecutable:" + e);
            return p;
        }

        @Override
        public ModelObject visitPackage(PackageElement e, ModelObject p) {
            System.out.println("visitPackage:" + e);
            return p;
        }

        @Override
        public ModelObject visitType(TypeElement e, ModelObject p) {
            System.out.println("visitType:" + e);
            try {
                Class<?> clazz = Class.forName(e.getQualifiedName().toString());
                ModelObject modelObject = new ModelObject(clazz);
                return modelObject;
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return null;
        }

        @Override
        public ModelObject visitTypeParameter(TypeParameterElement e, ModelObject p) {
            System.out.println("visitTypeParameter:" + e);
            return p;
        }

        @Override
        public ModelObject visitUnknown(Element e, ModelObject p) {
            System.out.println("visitUnknown:" + e);
            return p;
        }

        @Override
        public ModelObject visitVariable(VariableElement e, ModelObject p) {
            if (p == null) {
                return p;
            }
            //Class<?> clazz = p.getClazz();
            boolean isKey = false;
            Attribute attribute = e.getAnnotation(Attribute.class);
            if (attribute != null) {
                if (!attribute.persistence()) {
                    return p;
                }
                isKey = attribute.primaryKey();
            }
            System.out.println("visitVariable:" + e);
            // getter setterのチェック

            return p;
        };
        @Override
        public ModelObject visit(Element e) {
            return null;
        }
        @Override
        public ModelObject visit(Element e, ModelObject p) {
            return p;
        }
        
        
    }
}
