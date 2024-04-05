package com.palladiumgroup.lamiscore.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
@Getter
public class CoreApplication {

    private static CoreApplication instance;
    // Getter for modules map
    private final Map<String, Module> modules;

    private CoreApplication() {
        this.modules = new HashMap<>();
    }

    public static CoreApplication getInstance() {
        if (instance == null) {
            instance = new CoreApplication();
        }
        return instance;
    }

    public void registerModule(String moduleName, Module module) {
        modules.put(moduleName, module);
    }

    // Other methods for interacting with modules, such as getting modules, starting modules, etc.

}
