package com.programmer.zaman.now.belajar.spring.config.properties.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties("application")
public class ApplicationProperties {
    private String name;
    private Integer version;
    private boolean productionMode;
    private DatabaseProperties databaseProperties;

    private List<Role> defaultRoles;
    private Map<String, Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public boolean isProductionMode() {
        return productionMode;
    }

    public void setProductionMode(boolean productionMode) {
        this.productionMode = productionMode;
    }

    public DatabaseProperties getDatabaseProperties() {
        return databaseProperties;
    }

    public void setDatabaseProperties(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }

    public List<Role> getDefaultRoles() {
        return defaultRoles;
    }

    public void setDefaultRoles(List<Role> defaultRoles) {
        this.defaultRoles = defaultRoles;
    }

    public Map<String, Role> getRoles() {
        return roles;
    }

    public void setRoles(Map<String, Role> roles) {
        this.roles = roles;
    }

    public static class DatabaseProperties {

        private String username;
        private String password;
        private String url;
        private String database;

        private List<String> whiteListTables;
        private Map<String, Integer> maxTableSize;


        public List<String> getWhiteListTables() {
            return whiteListTables;
        }

        public void setWhiteListTables(List<String> whiteListTables) {
            this.whiteListTables = whiteListTables;
        }

        public Map<String, Integer> getMaxTableSize() {
            return maxTableSize;
        }

        public void setMaxTableSize(Map<String, Integer> maxTableSize) {
            this.maxTableSize = maxTableSize;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDatabase() {
            return database;
        }

        public void setDatabase(String database) {
            this.database = database;
        }
    }

    public static class Role {
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
