package org.exercises.api.templates;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class AddNewPet {

    private final String templateFile;
    private Map<String, String> defaultValues;

    private static final FreeMarkerTemplate freemarkerTemplate = new FreeMarkerTemplate();

    public AddNewPet(String templateFile) {
        this.templateFile = templateFile;
    }

    public static AddNewPet template(String template) {
        return new AddNewPet(template);
    }

    public AddNewPet withDefaultValuesFrom(Map<String, String> defaultValues) {
        this.defaultValues = defaultValues;
        return this;
    }

    public String withFieldsFrom(Map<String, String> fieldValues) {
        Map<String, String> fieldDictionary = new HashMap<>(defaultValues);
        fieldDictionary.putAll(fieldValues);

        Template template = freemarkerTemplate.getTemplate(templateFile);

        Writer writer = new StringWriter();

        try {
            template.process(fieldDictionary, writer);
        } catch (TemplateException | IOException e) {
            throw new IllegalStateException("Failed to merge test data template", e);
        }

        return writer.toString();
    }
}
