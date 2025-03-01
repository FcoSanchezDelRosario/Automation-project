package org.exercises.api.templates;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class FreeMarkerTemplate {

    private Configuration configuration = null;

    private Configuration getConfiguration() {
        if (configuration == null) {
            configuration = new Configuration(Configuration.VERSION_2_3_28);
            configuration.setDefaultEncoding("UTF-8");
            configuration.setClassForTemplateLoading(FreeMarkerTemplate.class, "/");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        }

        return configuration;
    }

    public Template getTemplate(String templateFile) {
        try {
            return getConfiguration().getTemplate(templateFile);
        } catch (Exception e) {
            throw new IllegalStateException("Could not find template " + templateFile, e);
        }
    }
}
