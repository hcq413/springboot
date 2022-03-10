package com.hcq.spring.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "file")
@Component
public class FilePropties {

    private String stacticAccessPath;

    private String uploadFileFolder;

    public String getStacticAccessPath() {
        return stacticAccessPath;
    }

    public void setStacticAccessPath(String stacticAccessPath) {
        this.stacticAccessPath = stacticAccessPath;
    }

    public String getUploadFileFolder() {
        return uploadFileFolder;
    }

    public void setUploadFileFolder(String uploadFileFolder) {
        this.uploadFileFolder = uploadFileFolder;
    }
}
