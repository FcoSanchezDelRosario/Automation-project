package org.exercises.api.templates;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class CreateNewUser {

    private final String templateFile;
    private Map<String, String> defaultValues;

    private static final FreeMarkerTemplate freeMarkerTemplate = new FreeMarkerTemplate();

    public CreateNewUser(String templateFile) {
        this.templateFile = templateFile;
    }

    @NotNull
    public static CreateNewUser template(String template) {
        return new CreateNewUser(template);
    }

    public CreateNewUser withDefaultValuesFrom(Map<String, String> defaultValues) {
        this.defaultValues = defaultValues;
        return this;
    }

    public String withFieldsFrom(Map<String, String> fieldValues) {
        Map<String, String> fieldDictionary = new HashMap<>(defaultValues);
        fieldDictionary.putAll(fieldValues);

        Template template = freeMarkerTemplate.getTemplate(templateFile);

        Writer writer = new StringWriter();

        try {
            template.process(fieldDictionary, writer);
        } catch (TemplateException | IOException e) {
            throw new IllegalStateException("Failed to merge test data template", e);
        }

        return writer.toString();
    }

}
